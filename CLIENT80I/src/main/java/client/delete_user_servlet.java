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
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import domains.Product;
import domains.User;

/**
 * Servlet implementation class delete_user_servlet
 */
@WebServlet("/delete_user")
public class delete_user_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_user_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user_client = (User) session.getAttribute("user");
		// TODO Auto-generated method stub
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10103");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		WebTarget webtargetPath = webtarget.path("/products/owner/"+user_client.getEmail());
		
		//***** 3. Build an HTTP Request Invocation *****/		
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		Response responsews = invocationBuilder.get();
		
		Product[] products_array = responsews.readEntity(Product[].class);
		
		for (int i=0;i<products_array.length;i++) {
			//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
			//***** 2B. Using the WebTarget define the path to the specific resource *****/		
			webtargetPath = webtarget.path("delete/"+products_array[i].getId_product());
			
			//***** 3. Build an HTTP Request Invocation *****/		
			invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
			
			//***** 4. Invoking HTTP Request *****/		
			responsews = invocationBuilder.delete();
		}
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		webtarget = client.target("http://localhost:10102");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		webtargetPath = webtarget.path("delete/"+user_client.getEmail());
		
		//***** 3. Build an HTTP Request Invocation *****/		
		invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		responsews = invocationBuilder.delete();
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		int status = responsews.getStatus();
		session.invalidate();
		response.sendRedirect("login");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
