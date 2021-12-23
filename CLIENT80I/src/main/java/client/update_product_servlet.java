package client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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

/**
 * Servlet implementation class update_product_servlet
 */
@WebServlet("/update_product")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class update_product_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_product_servlet() {
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
		request.getRequestDispatcher("update_product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String value = request.getParameter("value");
		String id = request.getParameter("product_id");
		String state = request.getParameter("state");
		
		// TODO Auto-generated method stub
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
		if (product == null) {
			String[] error = {"Access denied","You dont have enough privileges to access here"};
			request.setAttribute("error",error);
			request.getRequestDispatcher("logs.jsp").forward(request, response);
		}
		
		String image;
		try {
			Part filePart = request.getPart("product_file");
		    String fileName = filePart.getSubmittedFileName();
		    String path = "C:\\Users\\MrTabernero\\TIW\\CLIENT80I\\src\\main\\webapp\\assets\\img\\items\\"+fileName;
		    InputStream fileContent = filePart.getInputStream();
		    File fileToSave = new File(path);
			Files.copy(fileContent, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
			image = fileName;
		}catch(Exception e) {
			image = product.getImage();
		}
		
		
		String owner = product.getOwner();
		if (title.isEmpty()) {
			title = product.getTitle();
		}
		if (category.isEmpty()) {
			category = product.getCategory();
		}
		if (description.isEmpty()) {
			description = product.getDescription();
		}
		if (value.isEmpty()) {
			value = Float.toString(product.getValue());
		}
		if (id.isEmpty()) {
			id = Long.toString(product.getId_product());
		}
		long l_id = Long.parseLong(id);
		float f_value = Float.parseFloat(value);
		Product putProduct = new Product(l_id,title,category,description,f_value,image,owner,state);
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		webtarget = client.target("http://localhost:10103");
		webtargetPath = webtarget.path("update/"+putProduct.getId_product());
		invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		responsews = invocationBuilder.put(Entity.entity(putProduct, MediaType.APPLICATION_JSON));
		status = responsews.getStatus();
		putProduct = responsews.readEntity(Product.class);
		System.out.println(status);/*
		System.out.println(putProduct.getTitle());
		System.out.println(putProduct.getValue());
		System.out.println(putProduct.getId_product());
		*/
		response.sendRedirect("update_product?id_product="+putProduct.getId_product());
		}

}
