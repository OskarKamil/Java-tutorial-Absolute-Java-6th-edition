package chapter15;
// linked lists

public class Sub1 {
	// node

	private String productName;
	private int productQuantity;
	private Sub1 next;
	/*
	 * Here we are creating a linked list of products to buy, basically, a shopping
	 * list. Each node holds a name of a product to buy and quantity of that product
	 * needed to buy. There is also variable named next that will store a reference
	 * to next node. More explained below.
	 */

	public Sub1() {
		productName = null;
		productQuantity = 0;
		next = null;
	}
	/*
	 * Just default constructor that initializes all variables to null/0.
	 */

	public Sub1(String newProd, int newQua, Sub1 nextNode) {
		productName = newProd;
		productQuantity = newQua;
		next = nextNode;
	}
	/*
	 * A constructor that creates new valid node that will hold name of product,
	 * quantity and link to next node. This is just an example program, in reality
	 * we would check if quantity is more than 0 because there is no point to store
	 * negative numbers in shopping list, you cannot buy -2 breads or buy 0 eggs.
	 */

	public void setData(String newName, int newQua) {
		productName = newName;
		productQuantity = newQua;
	}
	/*
	 * Just standard value setter.
	 * 
	 */

	public String getItem() {
		return productName;
	}

	public int getQua() {
		return productQuantity;
	}

	public void setNext(Sub1 newNext) {
		next = newNext;
	}
	/*
	 * A method that will set a next node reference.
	 */

	public Sub1 getNext() {
		return next;
	}

}
