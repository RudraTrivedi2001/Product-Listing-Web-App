package in.sp.backend;

import java.util.ArrayList;

public class ProductManager {
	
	static ArrayList<Product> al = new ArrayList<Product>();
	
	static int pid = 0;
	


	public boolean addProducts(String name, float price) 
	{
		if (name == null || name.trim().isEmpty()) {
          System.out.println("Product name cannot be empty.");
          return false;
      }
      if (price < 0) {
          System.out.println("Product price cannot be negative.");
          return false;
      }
      
	Product product = new Product(pid++,name, price);
	al.add(product);
	
	return true;
	
		
	}
	
	
	
	  
	public ArrayList<Product> viewProducts()
	  {
		  
		  return al;
	  }
	
	public boolean updateProduct(int pid, String name, float price) 
	{
		for(Product p : al) {
			if(pid == p.pid) {
				p.pname = name;
				p.price = price;
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean deleteProduct(int pid)
	{
		for(Product p : al) {
			if(pid == p.pid) {
				int index = al.indexOf(p);
				al.remove(index);
				return true;
			}
		}
		return false;
		
		
	}
	
	
	
	

}
