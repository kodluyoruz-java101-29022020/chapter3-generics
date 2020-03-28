package chapter3.generics;

import java.util.ArrayList;
import java.util.List;

import chapter3.generics.datalist.DataListOverFlowException;
import chapter3.generics.model.Book;
import chapter3.generics.model.Car;
import chapter3.generics.model.ElectricCar;
import chapter3.generics.model.Vehicle;
import chapter3.generics.queue.BookQueue;
import chapter3.generics.queue.Queue;
import chapter3.generics.stack.BookStack;
import chapter3.generics.stack.Stack;

public class Main {

	public static void main(String[] args) throws DataListOverFlowException {
		
		runGenericStack();
		
		System.out.println("-------------------------");
		
		runGenericQueue();
		
		System.out.println("-------------------------");
		
		runBookStack();
		
		System.out.println("-------------------------");
		
		runBookQueue();
		
		
		runGenericMethod();
		
		runJokerWildCard();
		
		runGenericSuperLowerBound();
	}
	
	public static void runGenericStack() throws DataListOverFlowException {
		
		
		Stack<Integer> intStack = new Stack<Integer>(10);
		intStack.push(10);
		intStack.push(50);
		intStack.push(100);
		intStack.push(160);
		
		System.out.println("Int Stack from: " + intStack.pop());
		System.out.println("Int Stack from: " + intStack.pop());
		System.out.println("Int Stack from: " + intStack.pop());
		System.out.println("Int Stack from: " + intStack.pop());

		intStack.push(200);
		
		// Stack sınıfının tipini daha kodu yazarken Integer olarak verdiğimiz için,
		// String tipte bir değer ekleyemiyoruz. Daha derleme aşamasında bu hatayı alıyoruz.
		// Böylece, çalışma zamanında ortaya çıkacak hatayı önlemiş oluyoruz.
		
		// intStack.push("200");
		
		
		
		
		Stack<String> stringStack = new Stack<String>(10);
		stringStack.push("Merhaba,");
		stringStack.push("yazılımın");
		stringStack.push("yıldızları!");
		
		System.out.println(stringStack.pop() + stringStack.pop() + stringStack.pop());
		
		
		
		
		Book javaBook = new Book("Java101 Kodluyoruz", 100);
		Book pythonBook = new Book("Python Kitabı", 200);
		
		Stack<Book> bookStack = new Stack<Book>(2);
		bookStack.push(javaBook);
		bookStack.push(pythonBook);
		
		System.out.println(bookStack.pop());
		System.out.println(bookStack.pop());
		
		
		// ilkel (primitive) veri tipleri Generic olarak kullanılamaz!
		// Stack<double> doubleStack = new Stack<double>(5); 
		
	}
	
	public static void runGenericQueue() throws DataListOverFlowException {
		
		Queue<Integer> intQueue = new Queue<Integer>(10);
		intQueue.push(100);
		intQueue.push(200);
		intQueue.push(300);
		intQueue.push(400);
		intQueue.push(500);
		
		intQueue.print();
		
		intQueue.pop();
		
		intQueue.print();
		
		intQueue.push(600);
		intQueue.push(700);
		
		intQueue.print();
		
		intQueue.pop();
		
		intQueue.print();
		
		intQueue.push(800);
		intQueue.push(900);
		intQueue.push(1000);
		intQueue.push(1100);
		intQueue.push(1200);
		
		intQueue.print();
		
		intQueue.pop();
		intQueue.push(1300);
		
		intQueue.print();
		
		intQueue.pop();
		intQueue.push(1400);
		
		intQueue.print();
		
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		intQueue.pop();
		
		intQueue.print();
		
		intQueue.push(1500);
		
		intQueue.print();
		
		intQueue.pop();
		
		intQueue.print();
	}
	
	
	public static void runBookStack() throws DataListOverFlowException {
		
		BookStack<Book> onlyBookStack = new BookStack<Book>(10);
		onlyBookStack.push(new Book("ABC", 100));
		onlyBookStack.push(new Book("X Kitabı", 100));
		onlyBookStack.push(new Book("Y Kitabı", 80));
		onlyBookStack.push(new Book("Z Kitabı", 90));
		
		onlyBookStack.print();
		
		onlyBookStack.pop();
		
		onlyBookStack.print();
		
		// BookStack'e Book tipi dışında başka bir tip gönderemezseniz.
		// BookStack<String> onlyBookStack2 = new BookStack<String>(10);

	}
	
	public static void runBookQueue() throws DataListOverFlowException {
		
		BookQueue<Book> onlyBookQueue = new BookQueue<Book>(10);
		onlyBookQueue.push(new Book("ABC", 100));
		onlyBookQueue.push(new Book("X Kitabı", 100));
		onlyBookQueue.push(new Book("Y Kitabı", 80));
		onlyBookQueue.push(new Book("Z Kitabı", 90));
		
		onlyBookQueue.print();
		
		onlyBookQueue.pop();
		
		onlyBookQueue.print();
		
	}
	
	public static void runGenericMethod() {
		
		String[] words = { "Batuhan", "Mehmet", "Beril", "Batuhan", "Berkehan", "Sevil", "Sevinç", "Sevil" };
		
		int repeatedItemCount1 = RepeatItemCounter.countAllRepeatedItems(words, "Sevil");
		int repeatedItemCount2 = RepeatItemCounter.countAllRepeatedItems(words, "Batuhan");
		
		System.out.println("Sevil count: " + repeatedItemCount1);
		System.out.println("Batuhan count: " + repeatedItemCount2);
		
		
		// ilkel veri tiplerini Generic tip olarak kullanamayız :)
		// int[] numbers = { 4, 45, 54, 3, 4, 100, 100, 90, 91, 90};
		// int repeatedItemCount3 = RepeatItemCounter.countAllRepeatedItems(numbers, 4);
		// int repeatedItemCount4 = RepeatItemCounter.countAllRepeatedItems(numbers, 100);
		
		
		Integer[] numbers = { 4, 45, 54, 3, 4, 100, 100, 90, 91, 90};
		int repeatedItemCount3 = RepeatItemCounter.countAllRepeatedItems(numbers, 4);
		int repeatedItemCount4 = RepeatItemCounter.countAllRepeatedItems(numbers, 100);
		
		System.out.println("4 count: " + repeatedItemCount3);
		System.out.println("100 count: " + repeatedItemCount4);
	}
	
	public static void runJokerWildCard() {
		
		List<String> stringList = new ArrayList<String>(); 
		stringList.add("A");
		stringList.add("B");
		stringList.add("C");
		stringList.add("D");
		
		printAll(stringList);
		
		
		List<Long> longList = new ArrayList<Long>(); 
		longList.add(5L);
		longList.add(15L);
		longList.add(25L);
		longList.add(35L);
		
		
		printAll(longList);
	}
	
	public static void printAll(List<?> items) {
		
		for(Object item : items) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	
	public static void runGenericSuperLowerBound() {
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.iterator();
		vehicles.add(new Vehicle((short)6));
		
		showVehicleItems(vehicles);
		
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(new Car("BMW", "34 AL 377"));
		cars.add(new Car("Mercedes", "35 Aa 547"));
		
		showVehicleItems(cars);
		
		
		List<ElectricCar> electricalCars = new ArrayList<ElectricCar>();
		electricalCars.add(new ElectricCar("BMW", "34 AL 377", 100));
		electricalCars.add(new ElectricCar("Mercedes", "35 Aa 547", 200));
		
		showVehicleItems(electricalCars);
	}
	
	public static <T> void showVehicleItems(List<? super ElectricCar> vehicles) {
		
		for(Object vehicle : vehicles) {
			
			((Vehicle)vehicle).showInfo();
			System.out.println();
		}
		System.out.println();
	}

}
