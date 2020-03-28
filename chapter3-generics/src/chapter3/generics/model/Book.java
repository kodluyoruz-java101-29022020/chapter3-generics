package chapter3.generics.model;

public class Book {

	private String name;
	private int pageCount;
	
	public Book(String name, int pageCount) {
		this.setName(name);
		this.setPageCount(pageCount);
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("[Name: ");
		builder.append(this.getName());
		builder.append(" PageCount: ");
		builder.append(this.getPageCount());
		builder.append("]");
		
		return builder.toString();
	}
}
