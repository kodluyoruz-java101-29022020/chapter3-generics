package chapter3.generics.stack;

import chapter3.generics.datalist.DataList;
import chapter3.generics.datalist.DataListOverFlowException;

// T tipine kısıtlama getirmediğimiz için varsayılan olarak "Object" alt tipini alıyor.

public class Stack <T> implements DataList<T> {

	private int topIndex;
	private int size;
	private T[] values;
	
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		// Alttaki satırı yapamazsınız.
		// this.values = new T[1000];
		this.size = size;
		this.values = (T[]) new Object[this.size];
		this.topIndex = -1;
	}
	
	@Override
	public void push(T item) throws DataListOverFlowException {
		
		if(this.topIndex >= this.values.length) {
			throw new DataListOverFlowException("Yığın kapasite hatası, üst limiti aştınız!");
		}
		
		this.topIndex++;
		this.values[this.topIndex] = item;
	}
	
	@Override
	public T pop() throws DataListOverFlowException {
		
		if(this.topIndex < 0) {
			throw new DataListOverFlowException("Yığın kapasite hatası, alt limiti aştınız!");
		}
		
		T value = this.values[this.topIndex];
		this.values[this.topIndex] = null;
		this.topIndex--;
		
		return value;
	}
	
	@Override
	public void print() {
		
		for(T value : values) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
	public T[] getValues() {
		
		return this.values;
	}
	
}
