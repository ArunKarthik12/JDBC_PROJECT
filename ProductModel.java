package model;

public class ProductModel {
	
	private int id;
	private String name;
	private String code;
	private int price;
	private int quantity;
	
	public ProductModel(int id, String name, String code, int price,
			int quantity) {
		
		super();
		
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
	}
	public ProductModel() {
		super();
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getcode() {
		return code;
	}
	public void setcode(String code) {
		this.code = code;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	public double getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
