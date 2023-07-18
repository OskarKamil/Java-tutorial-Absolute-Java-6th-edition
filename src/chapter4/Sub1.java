package chapter4;

public class Sub1{
	public static void main(String[] args) {
		
		Sub1a student001 = new Sub1a(),
				student002 = new Sub1a(),
				student003 = new Sub1a();
		/* Now we have 3 variables of type Sub1a. */
		
		System.out.println("*** NEW STUDENT ***");		
		student001.addStudent();
		student001.printStudent();
		student001.changeDate(24, 1, 1997);
		student001.printStudent();
		System.out.println(student001);
		
		/* We run the method addStudent(). Then we run printStudent. Then we run changeDate and add arguments, then we
		printStudent again (good practise for debugging), and then we print student001 inside a println method. Thanks
		to toString method. It is a special method that returns String value whether this object is treated as a String. */
		
		System.out.println("*** NEW STUDENT ***");		
		student002.addStudent();
		student002.printStudent();
		student002.changeDate(24, 1, 1997);
		student002.printStudent();
		System.out.println(student002);
		
		System.out.println(student001.equals(student002));
		/* Here we are using a special method equals to check whether two objects/variables of a class are equal. */
	}
}