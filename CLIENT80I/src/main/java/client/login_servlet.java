package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;

import domains.User;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User client = (User) session.getAttribute("user");
		
		if (client == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("index");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//***** 1. Create an Instance of a Client *****/
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		//***** 2A. Create a WebTarget, using the URI of the targeted web resource *****/		
		WebTarget webtarget = client.target("http://localhost:10102");
		//***** 2B. Using the WebTarget define the path to the specific resource *****/		
		WebTarget webtargetPath = webtarget.path("login/"+email);
		
		//***** 3. Build an HTTP Request Invocation *****/		
		Invocation.Builder invocationBuilder = webtargetPath.request(MediaType.APPLICATION_JSON);
		
		//***** 4. Invoking HTTP Request *****/		
		Response responsews = invocationBuilder.get();
		
		//***** 5. From the response you can get the HTTP status and the data obtained *****/
		int status = responsews.getStatus();
		//User[] userArray = responsews.readEntity(User[].class);
		try {
			User user = responsews.readEntity(User.class);
			if (user.getPass().equals(password)) {
				User session_info = new User(user.getName(), user.getSurname(), user.getEmail(), user.getPass(), user.getCity(), user.getImage());
				HttpSession session = request.getSession();
				session.setAttribute("user", session_info);
				response.sendRedirect("login");
				return;
			}else {
				String[] error = {"User login failed","Your password is incorrect."};
				request.setAttribute("error",error);
				request.getRequestDispatcher("logs.jsp").forward(request, response);
				return;
			}	
		} catch(Exception e) {
			System.out.println(e.getMessage());
			String[] error = {"User login failed","email not found, you are not registered in our web app."};
			request.setAttribute("error",error);
			request.getRequestDispatcher("logs.jsp").forward(request, response);
			return;
		}
		
		// Consuming path /users
			// COMPLETE WITH THE CALL OF THE SERVICE TO THE url /users
			// DISPLAY THE RESULTS
		/*
		out.println("<p> STATUS: "+status+" </p>");
		for (int i=0; i< userArray.length; i++) {
			out.println("<h2>Name: "+((User) userArray[i]).getPass()+"</h2>");	
		}
		*/
	}

}
