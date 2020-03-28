package chapter3.generics.datalist;

public interface DataList <T> {

	public void push(T item) throws DataListOverFlowException;
	public T pop() throws DataListOverFlowException;
	public void print();
}
