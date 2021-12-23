package client;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import domains.Product;
import domains.User;

import javax.servlet.annotation.*;

/**
 * Servlet implementation class add_product_servlet
 */
@WebServlet("/add_product")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class add_product_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_product_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("add_product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part filePart = request.getPart("product_file");
	    String fileName = filePart.getSubmittedFileName();
	    String path = "C:\\Users\\MrTabernero\\TIW\\CLIENT80I\\src\\main\\webapp\\assets\\img\\items\\"+fileName;
	    InputStream fileContent = filePart.getInputStream();
	    File fileToSave = new File(path);
		Files.copy(fileContent, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		String image = fileName;
		
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		float value = Float.parseFloat(request.getParameter("value"));
		
		HttpSession session = request.getSession();
		User user_client = (User) session.getAttribute("user");
		String owner = user_client.getEmail();
		
		Product postProduct = new Product(title,category,description,value,image,owner,"disponible");
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10103");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		WebTarget webtargetPath = webtarget.path("Products");
		
		//***** 3. Build an HTTP Request Invocation *****/		
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		Response responsews = invocationBuilder.post(Entity.entity(postProduct, MediaType.APPLICATION_JSON));
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		int status = responsews.getStatus();
		if (status == 201) {
			String[] error = {"Product upload succeed","Now everyone can buy you new offer"};
			request.setAttribute("error",error);
			request.getRequestDispatcher("logs.jsp").forward(request, response);
		}
		System.out.println(status);
		postProduct = responsews.readEntity(Product.class);
		String[] error = {"Something went wrong","You couldnt update the product"};
		request.setAttribute("error",error);
		request.getRequestDispatcher("logs.jsp").forward(request, response);
	}
	

}
