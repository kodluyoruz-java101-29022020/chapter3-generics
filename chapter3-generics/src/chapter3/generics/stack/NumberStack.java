package chapter3.generics.stack;

public class NumberStack <N extends Number> extends Stack<N>{

	public NumberStack(int size) {
		super(size);
	}

}
