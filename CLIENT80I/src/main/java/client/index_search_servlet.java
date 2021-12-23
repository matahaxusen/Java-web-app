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
 * Servlet implementation class index_search_servlet
 */
@WebServlet("/index_search")
public class index_search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index_search_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public boolean getCheck(Product product, String area, String sub_string_nc) {
    	String sub_string = sub_string_nc.toLowerCase();
    	if(area.equals("descripcion")) {
        	if(product.getDescription().toLowerCase().contains(sub_string)) {
        		return true;
        	}
    	}
    	if(area.equals("vendedor")) {
        	if(product.getOwner().toLowerCase().contains(sub_string)) {
        		return true;
        	}
    	}
    	if(area.equals("titulo")) {
        	if(product.getTitle().toLowerCase().contains(sub_string)) {
        		return true;
        	}
    	}
    	if(area.equals("categoria")) {
        	if(product.getCategory().toLowerCase().contains(sub_string)) {
        		return true;
        	}
    	}
    	return false;
    }
    
    public Product[] item_adder(Product[] product_list, Product product) {
    	Product[] copy = new Product[product_list.length + 1];
    	for (int i=0;i<product_list.length;i++) {
    		copy[i] = product_list[i];
    	}
    	copy[copy.length-1] = product;
    	return copy;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sub_search = request.getParameter("search");
		String area = request.getParameter("area");
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10103");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		WebTarget webtargetPath = webtarget.path("products");
		
		//***** 3. Build an HTTP Request Invocation *****/		
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		Response responsews = invocationBuilder.get();
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		int status = responsews.getStatus();
		HttpSession session = request.getSession();
		User user_client = (User) session.getAttribute("user");
		if (user_client == null) {
			String[] error = {"Access denied","You dont have enough privileges to access here"};
			request.setAttribute("error",error);
			request.getRequestDispatcher("logs.jsp").forward(request, response);
		}
		Product[] products_array = responsews.readEntity(Product[].class);
		boolean created = false;
		Product[] copy = new Product[1];
		for (int x=0;x<products_array.length;x++) {
			if ((!user_client.getEmail().equals(products_array[x].getOwner()) || products_array[x].getState().equals("disponible")) && getCheck(products_array[x],area,sub_search)) {
				if(!created) {
					copy[0] = products_array[x];
					created = true;
				}else {
					copy = item_adder(copy,products_array[x]);
				}	
			}
		}
		created = false;
		try {
			request.setAttribute("products",copy);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception e) {
			response.sendRedirect("index");
		}
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
