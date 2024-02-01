package dto;

public class Product {
	
	private int pId;
	private String pName;
	private double price;
	private String type;
	
	
	public Product() {
		
	}


	public Product(int pId, String pName, double price, String type) {
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.type = type;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	

}
