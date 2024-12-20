package in.sp.backend;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewProductServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		ProductManager pm = new ProductManager();
		 ArrayList<Product> al = pm.viewProducts();
	     
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>View Products</title>");
	        out.println("<style>");
	        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
	        out.println(".container { text-align: center; margin: 50px auto; padding: 20px; width: 60%; background-color: #ffffff; box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); border-radius: 10px; }");
	        out.println("h1 { color: #333333; margin-bottom: 20px; }");
	        out.println("p { font-size: 16px; color: #555555; }");
	        out.println(".back-button { display: inline-block; margin-top: 20px; text-decoration: none; font-size: 16px; color: #ffffff; background-color: #007bff; padding: 10px 20px; border-radius: 5px; }");
	        out.println(".back-button:hover { background-color: #0056b3; }");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='container'>");
	        
		 if(al.isEmpty()) {
			  out.println("<h1>No Products Available</h1>");
	            out.println("<p>There are currently no products in the list.</p>");
	            out.println("<a href='Menu.html' class='back-button'>Go to Menu</a>");
			 
			 
		 }else {
		 
			 out.println("<h1>Available Products</h1>");
	            for (Product p : al) {
	                out.println("<p><strong>Product ID:</strong> " + p.pid + "</p>");
	                out.println("<p><strong>Product Name:</strong> " + p.pname + "</p>");
	                out.println("<p><strong>Product Price:</strong> ₹" + p.price + "</p>");
	                out.println("<hr>");
	            }
	            out.println("<a href='Menu.html' class='back-button'>Go to Menu</a>");
	        }

	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
	   
	}



}
