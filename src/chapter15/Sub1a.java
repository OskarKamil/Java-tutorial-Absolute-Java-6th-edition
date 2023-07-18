package chapter15;

public class Sub1a {
	// linked list

	private Sub1 head;
	/*
	 * This class will be used as our linked list. A linked list is a list that
	 * consists of nodes and each node points at next node. First node is a head and
	 * last node is a tail. More explained below.
	 */

	public Sub1a() {
		head = null;
	}
	/*
	 * Empty constructor, and if constructor is empty then a linked list will be
	 * empty too. Thus head of type Sub1 (type of a node) will be empty, and each
	 * Sub1 have a next variable that points at next node. Since head is first and
	 * it doesn't point to anything, head is also the last. If head is first, and
	 * last, and all it's values are null or empty, this means that this linked list
	 * is empty as well.
	 */

	public void addToStart(String newName, int newQua) {
		head = new Sub1(newName, newQua, head);
	}
	/*
	 * A method that adds a new node to the front of the linked list, namely,
	 * creates a new head node. It takes String and int as argument. And same
	 * arguments are passed to Sub1 (node class) constructor as well as head
	 * variable.
	 * 
	 * This part may seem tricky, let's analyze it: head = new Sub1(newName, newQua,
	 * head); First, we pass the value of newName and newQua to the Sub1
	 * constructor, this part seems easy. And then we pass value of head. head
	 * variable here is a first node. But, what happens in the constructor in Sub1?
	 * head variable here is passed to next variable in Sub1. Namely, this method,
	 * takes current head (first node) and stores it as next. And then this new
	 * created node is saved as head. What is the result. The current head is the
	 * one that is created with this method so head is now newName, newQua and next
	 * points to the old head. The old head is now second node in the list. And same
	 * thing will happen if we run this method again. Reference to the head will be
	 * passed to the head, so the new head will have next variable pointing to the
	 * old head, and old head to the older head and so on.
	 */

	public boolean deleteHeadNode() {
		if (head != null) {
			head = head.getNext();
			return true;
		} else
			return false;
	}
	/*
	 * This is a very smart solution. This method removes the head. What does it
	 * mean? This means that it deletes the first node in the linked list, so the
	 * first node will be our second node. How to achieve that? In here first we
	 * check if head is null. If head is null then it means that it doesn't have a
	 * next variable and if we wanted to access it, we would have an error, so we
	 * must check if it is not null first. If it is not null, then we simply assign
	 * new reference. Our head now will be head.getNext(). Method getNext() returns
	 * a Sub1 object. And our head now points to the new head which was our 2nd node
	 * in the list. One point to take:
	 * 
	 * -this all may seem complex and difficult to make everytime. All of this is a
	 * part of standard java library and all of this is already implemented. Here we
	 * are building everything from square one because it is good to understand how
	 * it works. In reality, you never write this code, you only use methods
	 * provided.
	 * 
	 * One more thing. Remember what is reference? It is a shallow copy. When we
	 * learned about copying objects we learned that using shallow copy is bad and
	 * we should use deep copy unless shallow copy is intended. In here, it is. We
	 * use shallow copy as a reference. It simply points to the next node in the
	 * list.
	 */

	public int size() {
		int count = 0;
		Sub1 position = head;
		while (position != null) {
			count++;
			position = position.getNext();
		}
		return count;
	}
	/*
	 * One more smart method. It return size of the linked list. First it sets
	 * position to head. Then it checks if it is null. If it is null it means that
	 * the head is empty and so is the linked list, if it is not, then it proceeds
	 * to the loop. It increases count and changes position to position.getNext().
	 * Basically the position is of Sub1 and getNext() also returns Sub1, it returns
	 * a reference. And the loop starts again. Is the new position null? Basically,
	 * did the node point to another node or was the pointer null? If the points was
	 * null so is the position, etc. Then it returns count which will represent
	 * number of iterations of this loop. Once again, do not worry about
	 * implementation of this method. All those methods are part of java library and
	 * you do not need to know how they are implemented. Just read these notes to
	 * practise your skills.
	 */

	public boolean containts(String item) {
		return (find(item) != null);
	}

	private Sub1 find(String target) {
		Sub1 position = head;
		String itemAtPosition;
		while (position != null) {
			itemAtPosition = position.getItem();
			if (itemAtPosition.equals(target))
				return position;
			position = position.getNext();
		}
		return null;
	}
	/*
	 * Another method. The loop traverses through whole list. Once more, you do not
	 * need to create this method.
	 */

	public void outputList() {
		Sub1 position = head;
		while(position!= null) {
			System.out.println(position.getQua() + "x " + position.getItem());
			position = position.getNext();
		}
	}
}
