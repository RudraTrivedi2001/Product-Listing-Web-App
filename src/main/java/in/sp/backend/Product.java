package in.sp.backend;

public class Product {
	
	String pname;
	float price;
	int pid;
	
	
	
	
	public Product(int pid,String pname, float price) {
	
		this.pname = pname;
		this.price = price;
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
	

}
