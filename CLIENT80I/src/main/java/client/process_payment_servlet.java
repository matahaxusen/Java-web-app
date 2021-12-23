package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

import org.glassfish.jersey.client.ClientConfig;

import domains.Bank;
import domains.Product;
import domains.User;

/**
 * Servlet implementation class process_payment_servlet
 */
@WebServlet("/process_payment")
public class process_payment_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process_payment_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] error = {"How did you get here?","You have wrongly accessed the payment method"};
		request.setAttribute("error",error);
		request.getRequestDispatcher("logs.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id_product");
		System.out.println(id);
		
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10103");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		WebTarget webtargetPath = webtarget.path("products/id/"+id);
		
		//***** 3. Build an HTTP Request Invocation *****/		
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		Response responsews = invocationBuilder.get();
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		int status = responsews.getStatus();
		System.out.println(status);
		Product product = responsews.readEntity(Product.class);
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		String buyer = user.getEmail();
		String seller = product.getOwner();
		float value = product.getValue();
		long product_id = product.getId_product();
		String date = LocalDate.now().toString();
		String title = product.getTitle();
		
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		webtargetPath = webtarget.path("delete/"+product.getId_product());
		
		//***** 3. Build an HTTP Request Invocation *****/		
		invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		responsews = invocationBuilder.delete();
		
		status = responsews.getStatus();
		System.out.println(status);
		
		Bank bank = new Bank(buyer, seller, value, product_id, title, date);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		webtarget = client.target("http://localhost:10101");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		webtargetPath = webtarget.path("transactions");
		
		//***** 3. Build an HTTP Request Invocation *****/		
		invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		responsews = invocationBuilder.post(Entity.entity(bank, MediaType.APPLICATION_JSON));
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		status = responsews.getStatus();
		System.out.println(status);
		
		
		String[] error = {"Successful purchase","We have received the payment, shipping will begin shortly"};
		request.setAttribute("error",error);
		request.getRequestDispatcher("logs.jsp").forward(request, response);
	}

}
