package chapter5;

public class Sub1 {
	
	private static int idCount = 0;
	/* Static integer variable. Static variables can be accessed by Sub1.id = 0, if they are public. If private, they must be accessed by a method, either by static or nonstatic. Static variables are not instance variables, so they don't belong to an object of a class. They belong to class as a whole, so it can be accessed by various objects of the class and will have the same value. */
	
	public static final double RATE = 0.2;
	/* Constant. Constant should (but don't have to) be public and always static (if you think about it, if there is no point of being nonstatic, each object would have their own constant with the same value. Pointless cuz it would never change value and is always the same for other objects. */
	
	private int id = 0;
	private final String name;
	private final int age;
	private final int weight;
	private final int height;
	
	public Sub1(String name, int age, int weight, int height)
	{
		++idCount;
		id=idCount;
		name = name.toLowerCase();
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		/* Here we used .toUpperCase() static method of class Character which is a wrapper class and will be discussed later. This static method takes as a argument a value returned by a String nonstatic method charAt(). It is a nonstatic method because it needs object name to invoke. */
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	
	private static void idNow() {
		System.out.println("Last assigned ID was: " + idCount);
	}
	/*This is a static method. It can access only static variables and static methods. It could invoke and access nonstatic methods and variables if in the body it would create new object of that class: Sub1 example = new Sub1(); and then refer to that object. Otherwise, it cannot. It can be invoked in main() function here because it is in the same file as the function definition. However, this function could not be accessed in other files.
	 * 
	 *  If this function was public and available to access in other files, to invoke this function, you would need to type: Sub1.idNow(). Here you cannot put object type name, you can put just idNow() because it is inside the file it was defined to you don't have to specify to which class this method belongs to.*/
	
	private void output() {
		System.out.println("***PET ID " + id + "***");
		System.out.println("Name: " + name + 
				"\nAge: " + age +
				"\nWeight: " + weight + 
				"\nHeight: " + height + "\n");
		
	}
	/* Non-static method. It can access static methods and voids. */
	
	public static void main(String[] args) {
	/* You can put main() function inside a class definition with other methods and variables. You can do that if you don't need two files, one for main() function and one for other function with all the logic. */
		
		Sub1 firstPet = new Sub1("SISI", 9, 4, 16),
				secondPet = new Sub1("kaia", 6, 9, 20),
				thirdPet = new Sub1("RaMBo", 10, 10, 18);
	
		idNow();
		/* Usually when invoking static methods, instead as nonstatic methods you put objectname.method, here you put classname.method, but this method is defined here, you need not specify what class this method belongs to, this method belong here, to this class, so no need to repeat name of the file/class name. If definition of that static method was in other file and was public, you would enter Sub1a.idNow(). */
		
		firstPet.output();
		secondPet.output();
		thirdPet.output();
		
	}
}
	/* Example of using Math class and its method:
	  	double exact = 7.56;
		int lowEstimate = (int)Math.round(Math.floor(exact));
		int highEstimate = (int)Math.round(Math.ceil(exact));
		because floating numbers are always estimates. 7.56 may sometimes be a little less or a little more, and when you floor/ceil it, or other methods, they return floating numbers which may be not accurate, it may return 8.0 which in fact may be sometimes 7.(9) so it is got to round them after ceiling or flooring. Rounds returns long type, so you should cast into int because automatically it will produce an error because long takes more bytes than int. */