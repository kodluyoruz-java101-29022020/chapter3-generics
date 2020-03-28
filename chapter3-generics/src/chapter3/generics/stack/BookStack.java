package chapter3.generics.stack;

import chapter3.generics.model.Book;

public class BookStack <B extends Book> extends Stack<B>{

	public BookStack(int size) {
		super(size);
	}
}
