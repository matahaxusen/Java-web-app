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
 * Servlet implementation class update_user_servlet
 */
@WebServlet("/update_user")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class update_user_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_user_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user_client = (User) session.getAttribute("user");
		if (user_client == null) {
			String[] error = {"Access denied","You dont have enough privileges to access here"};
			request.setAttribute("error",error);
			request.getRequestDispatcher("logs.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10103");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		WebTarget webtargetPath = webtarget.path("products/owner/"+user_client.getEmail());
		
		//***** 3. Build an HTTP Request Invocation *****/		
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		Response responsews = invocationBuilder.get();
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		int status = responsews.getStatus();
		
		Product[] products_array = responsews.readEntity(Product[].class);
		request.setAttribute("user_products",products_array);
		for (int i=0;i<products_array.length;i++) {
		}
		
		request.getRequestDispatcher("update_user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name").toUpperCase();
		String surname = request.getParameter("surname").toUpperCase();
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String city = request.getParameter("city");
		
		HttpSession session = request.getSession();
		User user_client = (User) session.getAttribute("user");
		if (user_client == null) {
			String[] error = {"Access denied","You dont have enough privileges to access here"};
			request.setAttribute("error",error);
			request.getRequestDispatcher("logs.jsp").forward(request, response);
		}
		
		String image;
		try {
			Part filePart = request.getPart("user_file");
		    String fileName = filePart.getSubmittedFileName();
		    String path = "C:\\Users\\MrTabernero\\TIW\\CLIENT80I\\src\\main\\webapp\\assets\\img\\usersIMG\\"+fileName;
		    InputStream fileContent = filePart.getInputStream();
		    File fileToSave = new File(path);
			Files.copy(fileContent, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
			fileName = fileName.replaceAll(".jpg", "");
			image = fileName;
		}catch(Exception e) {
			image = user_client.getImage();
		}
		
		if (name.isEmpty()) {
			name = user_client.getName();
		}
		if (surname.isEmpty()) {
			surname = user_client.getSurname();
		}
		if (email.isEmpty()) {
			email = user_client.getEmail();
		}
		if (pass.isEmpty()) {
			pass = user_client.getPass();
		}
		if (city.isEmpty()) {
			city = user_client.getCity();
		}
		
		User putUser = new User(name,surname,email,pass,city,image);
		request.getSession().setAttribute("user", putUser);
		
		// TODO Auto-generated method stub
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10102");
		WebTarget webtargetPath = webtarget.path("update/"+user_client.getEmail());
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		Response responsews = invocationBuilder.put(Entity.entity(putUser, MediaType.APPLICATION_JSON));
		int status = responsews.getStatus();
		putUser = responsews.readEntity(User.class);
		System.out.println(status);
		response.sendRedirect("update_user");
	}

}
