package chapter3.generics;

public class RepeatItemCounter {

	public static <T> int countAllRepeatedItems(T[] list, T item) {
		
		int count = 0;
		
		if (item == null) {
			for (T listItem : list)
				if (listItem == null)
					count++;
		} else {
			for (T listItem : list)
				if (item.equals(listItem))
					count++;
		}
		
		return count;
	}

}
