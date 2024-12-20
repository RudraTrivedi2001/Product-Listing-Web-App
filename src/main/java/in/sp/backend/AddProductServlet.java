package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("pname");
		float price = Float.parseFloat(request.getParameter("price"));
		
		ProductManager pm = new ProductManager();
		boolean add = pm.addProducts(name, price);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(add) {
			
			
			out.print("<h1> Product with name : "  + name + " added successfully </h1>" );
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Product-saved.html");
	        dispatcher.include(request, response);
		}else {
out.print("<h1> Error Product with name : "  + name + " failed to add </h1>" );
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("addError.html");
	        dispatcher.include(request, response);
		}
		
	
	}

}
