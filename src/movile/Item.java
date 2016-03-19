package movile;

public class Item {

	private String name;
	private String id;
	private double price;
	
	public Item(String name, String id, double price){
		this.name = name;
		this.id = id;
		this.price = price;
	}
	
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public double getPrice(){
		return price;
	}
}
