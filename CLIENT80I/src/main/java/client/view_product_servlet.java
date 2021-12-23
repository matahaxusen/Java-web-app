package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * Servlet implementation class view_product_servlet
 */
@WebServlet("/view_product")
public class view_product_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_product_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id_product");
		
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
		
		Product product = responsews.readEntity(Product.class);
		request.setAttribute("show_product",product);
		request.getRequestDispatcher("view_product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at view_product (get): ").append(request.getContextPath());
	}

}
