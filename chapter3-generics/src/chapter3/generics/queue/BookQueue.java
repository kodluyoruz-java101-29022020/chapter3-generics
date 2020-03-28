package chapter3.generics.queue;

import chapter3.generics.model.Book;

public class BookQueue <B extends Book> extends Queue<B>{

	public BookQueue(int size) {
		super(size);
	}

}
