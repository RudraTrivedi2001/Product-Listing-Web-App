package in.sp.backend;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.sendRedirect("deleteProduct.html");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        
        ProductManager pm = new ProductManager();
        boolean delete = pm.deleteProduct(pid);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<html><head><link rel='stylesheet' type='text/css' href='style.css'></head><body>");
        
        if(delete) {
            out.print("<html><head>");
            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; text-align: center; }");
            out.print(".response-container { margin: 50px auto; padding: 20px; width: 60%; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }");
            out.print(".success { background-color: #28a745; color: white; }");
            out.print(".error { background-color: #dc3545; color: white; }");
            out.print("h1 { font-size: 24px; margin-bottom: 20px; }");
            out.print("a.back-button { display: inline-block; padding: 10px 20px; background-color: #007bff; color: white; text-decoration: none; font-size: 16px; border-radius: 5px; margin-top: 20px; }");
            out.print("a.back-button:hover { background-color: #0056b3; }");
            out.print("</style>");
            out.print("</head><body>");
            
            out.print("<div class='response-container success'>");
            out.print("<h1>Product with ID: " + pid + " deleted successfully!</h1>");
            out.print("<a href='Menu.html' class='back-button'>Back to Menu</a>");
            out.print("</div>");
            
            out.print("</body></html>");
        } else {
            out.print("<html><head>");
            out.print("<style>");
            out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; text-align: center; }");
            out.print(".response-container { margin: 50px auto; padding: 20px; width: 60%; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }");
            out.print(".success { background-color: #28a745; color: white; }");
            out.print(".error { background-color: #dc3545; color: white; }");
            out.print("h1 { font-size: 24px; margin-bottom: 20px; }");
            out.print("a.back-button { display: inline-block; padding: 10px 20px; background-color: #007bff; color: white; text-decoration: none; font-size: 16px; border-radius: 5px; margin-top: 20px; }");
            out.print("a.back-button:hover { background-color: #0056b3; }");
            out.print("</style>");
            out.print("</head><body>");
            
            out.print("<div class='response-container error'>");
            out.print("<h1>Error: Product with ID: " + pid + " failed to delete.</h1>");
            out.print("<a href='Menu.html' class='back-button'>Back to Menu</a>");
            out.print("</div>");
            
            out.print("</body></html>");
        }



        out.print("</body></html>");
    }
}
