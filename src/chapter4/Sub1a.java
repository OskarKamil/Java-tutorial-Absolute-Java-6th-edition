package chapter4;

import java.util.Scanner;

public class Sub1a {
	
	private String firstName;
	private String lastName;
	private int dob, mob, yob; //day/month/year of birth
	/* Instance variables are best to set private, and change their value through a method (function inside a class). When a member of a class (whether it's a method-function or an instance variable) is private, it cannot be accessed in another class directly. That's why we create public method to assign values to the instance variables. */
	
	public void addStudent() {
		System.out.println("Please fill in following details of a student.");
		/* enter sysout and then press ctrl + space, to enter println faster. */
		Scanner keyboard = new Scanner(System.in);
		/* the keyboard scanner is available only in the scope of this method. If you want to input data from keyboard in the other method, you'd need to define new Scanner class. And you wouldn't be able to use keyboard name. */
		System.out.print("First name: "); firstName = keyboard.next();
		System.out.print("Last name: "); lastName = keyboard.next();
		do {
		System.out.print("Day of birth: "); dob = keyboard.nextInt();
		System.out.print("Month of birth: "); mob = keyboard.nextInt();
		System.out.print("Year of birth: "); yob = keyboard.nextInt();
		}while(!(checkDate(dob, mob, yob)));
	}
	/* public void means that this method returns no value. Method can either return a value and do thing, or just do thing. This one only do thing. It is public so you can invoke (invoke - run the method) in the main class.*/ 
	
	public void printStudent() {
		System.out.println("Info about a student:");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Date of birth: " + dob + "/" + mob + "/" + yob);
	}
	/* Another public class. You can invoke it in main class. */
	
	public void changeDate(int dob, int mob, int yob) {
		this.dob = dob;
		this.mob = mob;
		this.yob = yob;
	}
	/* The word this. It specififes which variable you mean. By default, this function always refers to the parameters in the title. So if you invoke the method with some number, eg: 28, 8, 2010. Then this method does this: 28 = 28, 8 = 8, 2010 = 2010; You can simply change the name of the variable instance, or just add this. specifier. This means that this.dob refers to the variable outside of this method, defined before at the beginning of the class. */
	
	private Boolean checkDate(int dob, int mob, int yob) {
		if(dob>0 && dob<32)
			;
		else
			return false;
		
		if(mob>0 && mob<13)
			;
		else
			return false;

        return yob > 1900 && yob < 2021;
	}
	/* this is a private method. So this means you cannot use it out of the main method in your main program. Instead, this method can be invoked inside a public method. This method is invoked in addStudent() method just to check the date. */
	
	public String toString() {
		return firstName + lastName + dob + mob + yob;
	}
	/* This is a special method. It should be inside of every class to help us easily display values of the members of the class. It returns as a string all values of all variables. This way we can easily see what data it stores. */
	
	public Boolean equals(Sub1a other) {
		/* remember that when you create a class, your class is basically a type. And as a parameter, you want to give another object of the same class. For example you have student023 and student027, both belong to the same class, so they have the same type. That's why you enter Sub1a, this is a type, just like string, int, double etc. */
		
		if((this.firstName).equals(other.firstName))
			;
		else
			return false;
		
		if((this.lastName).equals(other.lastName))
			;
		else
			return false;
		/* Why not using ==? Because this is a string. Remember from previous lessons. String cannot be compared with == because they are not number. String class have their own methods for thier objects. For example toUpperCase, toLowerCase, lenght, indexOf etc, including equals(). The name of this method is equals, and the name of the method of String class is also equals. However compiler knows what you talk about String method. */
		
		if(this.dob == other.dob)
			;
		else
			return false;

		if(this.mob == other.mob)
			;
		else
			return false;

        return this.yob == other.yob;
	
	/* Another special class. Same as toString, it should be inside of every class. It simply compares two objects of the same class. Let's assume you have many objects of this class, and those are student data. And you wanna check for duplicates. You simply run this method and compare one object of this class to another object of this class.
	 * 
	 * It may be tempting to compare two objects with toString() method, anyway, toString displays all the values and that's what we are checking. It may seem so, however String takes up more space than numeral variables. For speed efficiency, String takes up more space and more time to compare. Plus Strings are compared character by character. Always compare by value if possible. */

	}
}
