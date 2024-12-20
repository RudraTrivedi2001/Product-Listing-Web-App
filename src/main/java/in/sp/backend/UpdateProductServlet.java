package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("pname");
		float price = Float.parseFloat(request.getParameter("price"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		
		ProductManager pm = new ProductManager();
		
		boolean update = pm.updateProduct(pid, name, price);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(update) {
			
			
			out.print("<h1> Product with ID : "  + pid + " updated successfully </h1>" );
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Updated.html");
	        dispatcher.include(request, response);
		
		}else {
			out.print("<h1> Error Product with Id : "  + pid + " failed to Update </h1>" );
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("updateError.html");
				        dispatcher.include(request, response);
					}
	}

}
