package chapter5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Sub2 {
	
	private String name;
	private int age;
	
	public Sub2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name + " " + age;
	}
	
	public boolean equals(Sub2 other) {
		return (name.equals(other.name) && (age == other.age) );
	}
	
	public void changel(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void change2(Sub2 other) {
		other.name = this.name;
		other.age = this.age;
	}
	/* Here we change value of the argument. But objects in methods don't call by value, but by address. So if we invoke a method with object as an argument, changes made to the argument are done also to the original object. */
	
	public static void change3(int num) {
		num = 10;
	}
	/* Here we change value of the argument too. But the argument is not an object, it is a primitive type. Changing value to 10 here does not affect the original variable because through parameter the value has been passed, not the reference. IT HAS TO BE STATIC if you don't want/can't use the obj name. */
	
	public static void main(String[] args) {
		Sub2 obj1 = new Sub2("Sisi", 9);
		System.out.println(obj1);
		Sub2 obj2 = new Sub2("Kaia", 7);
		System.out.println(obj2);
		
		obj2 = obj1;
		System.out.println(obj1);
		System.out.println(obj2);
		/* When using = operator with primitive types. We copy the value. When working with objects, = operator copies the memory address. obj1 references some memory address under which are value of instance variables.  obj2 = obj1, copies memory address from obj1 to obj2, in result, both variable names obj2 and obj1 refer to the same memory address which means that changing one changes the other. */
		
		obj1.changel("Ciapek", 13);
		System.out.println(obj1);
		System.out.println(obj2);
		/* We changed value of variables of obj1, but since they refer to the same memory address, they return the same value. */
		
		Sub2 obj3 = new Sub2("Reksio", 15);
		obj3.change2(obj2);
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		/* Change2() method changes value of the argument. But as you can see, it also affects the operator that was invoked in the method. That's the difference between primitive types and class types. Class types values are called by reference unlike primitive types are called by values. */
		
		int a= 20;
		System.out.println(a);
		Sub2.change3(a);
		System.out.println(a);
		/* The value is still 20 because primitive values are called by value in methods, so their value don't change out of scope of method. Class types values are changed because they are called by reference. */
		
		System.out.println(obj1.equals(obj2));
		System.out.println(obj2.equals(obj3)); // true and true
		obj2.changel("Szczeniak", 4);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj2.equals(obj3));
		/* True and false. First and second are the same because they are references so they must be equal cuz they are the name. obj3 is not equal, however they were equal, they didn't share same memory address so changes to obj3 affect only obj3. And that's why we create equals() method. There is no other way to check wherther two objects are the same. They may be the same, however their memory address may be different, that's why using equals() method is foolproof.*/
		
		System.out.println((obj1 == obj2));
		/* == operator with objects also works different that with primitive types. == checks if both variable names obj1 and obj2 refer to the same memory address. Since we used = with them befory to make obj2 reference of obj1, they both refer to the same memory address. */
		
		Sub2 obj4 = null;
		/* We use it when we don't have any value that we want to assign to this object. */
		
		System.out.println(obj4==null);
		/* Returns true because obj4 has no real value. If we tried to use toString this object, it would produce “Null Pointer Exception.” error. When you encounter this error, try to find uninitialized object of which values are tried to be computed.  */
		
		System.out.println("\n\n");
		
		if(obj2.equals(new Sub2("Szczeniak", 4)))
			System.out.println("Obj2 variable is equal to this anonymous variable");
		/* If we don't want to create new variable and waste memory, we can simply create new object inside the if statement. It is called anonymous because we don't give that obj a name, we simply create obj using class name.  */
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a name for a pet and then age. (you can put \",\" between the name and the age.");
		String inputLine = keyboard.nextLine();
		String delimiters = ", "; //Comma and blank space
		StringTokenizer numberFactory = new StringTokenizer(inputLine, delimiters);
		String string1 = null;
		String string2 = null;
		if (numberFactory.countTokens() >= 2) {
		string1 = numberFactory.nextToken();
		string2 = numberFactory.nextToken();
		}
		int age = Integer.parseInt(string2);
		
		Sub2 obj5 = new Sub2(string1, age);
		System.out.println(obj5);
		/* We input name and age in one string. Stringtokenizer divides them into 2 by using delimiters. We need to make string1 and 2 null because later in code we use values of string1 and 2 so for safety compiler makes us to give tham value (or no value null) for safety. Then we use Integer.parseInt(string). Basically this method tried to make an int out of a string. Then those value we add to constructor of a Sub2 class.
		 * Alternatively we could have improrted import static java.lang.Integer.parseInt; so our parse would look like that int age = parseInt(string2); This way we import this method to our class and we don't have to use class name specifier to access that method. Or import static java.lang.Integer.*; for all methods, not only parseInt. Same with Math class.import static java.lang.Math.PI; or import static java.lang.Math.*; to access methods and variables without Math. beginning. You can do that with static variables and methods only. */
	}
}