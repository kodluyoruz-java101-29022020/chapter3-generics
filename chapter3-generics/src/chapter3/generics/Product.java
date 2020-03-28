package chapter3.generics;

public class Product <T> {

	private T price;
	
	public Product(T price) {
		this.price = price;
	}
	
	public void setPrice(T price) {
		this.price = price;
	}
	
	public T getPrice() {
		return this.price;
	}
	
}
