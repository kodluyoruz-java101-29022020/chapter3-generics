package chapter3.generics.queue;

public class NumberQueue <N extends Number> extends Queue<N>{

	public NumberQueue(int size) {
		super(size);
	}

}
