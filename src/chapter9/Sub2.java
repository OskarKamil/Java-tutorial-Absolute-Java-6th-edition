package chapter9;

public class Sub2{
	
	static double fiveBy(double number) throws Exception {
		/* throws keyword means that this method has "throw" keyword in the definition, and it means that in some cases (and maybe in all cases) this method can throw an exception. But this method doesn't catch an exception. Properly designed methods don't catch exceptions. Method should only throw an exception, and if they do, the types of the exception should be in the title of the method definition called throws clause. */
		
		double result = 0;
		
		if(number == 0)
			throw new Exception("Division by zero prohibited!");
		/* Here a method throws an exception if the number input is 0 thus resulting in division by zero. If throw happens, the method is terminated and catch block outside the method is run as usual with Exception object snipped into probably e parameter. */
		
		result = 5/number;
		
		return result;
	}
	
	static double getNumber(double number) {
		double result = number;
		
		//result = fiveBy(number) * number;
		/* Now. If a method has invocation of another method which throws an exception (this is, has throws clause), you have 2 options.
		 * 1. Add "throws" clause to this method. This way, when that invocation of a method throws an exception, this means that this method doesn't catch an exception, this is, is not responsible for handling an exception. In that case this method invocation must be wrapped in try and catch case.
		 * static double getNumber(double number) throws Exception {//code}
		 * 
		 * 2. Wrap invocation of the method that throws an exception in try and catch blocks. This will mean that this method is responsible for catching that exception.
		 * try{result = fiveBy(number) * number;}catch(Exception e){//possible code} 
		 * 
		 * In other words. When method has "throws" clause means that this method is not responsible if there is an exception thrown and outside the method should be try and catch block. */
		
		return result;
	}
	
	
	public static void main(String[] args) {

		try {
			System.out.println(fiveBy(0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
//		 System.out.println(fiveBy(4));
		/* Even though this method invocation doesn't throw an exception, compiler makes you wrap this method into try and catch block because this method is marked as "throws" and when it is marked this way, each invocation of this method must be wrapped in try and catch block. Sometimes a method takes input from user, and you never know when a method may throw an exception so if method is marked throws, you always must take into account that an exception may be thrown.
		 * 
		 * Also, if you want few lines of code to be comments, select them and press [Ctrl]+[/] to either turn lines of code into comment and so, or press extra [Shift] to make them multi lines comments. */
		 
		System.out.println(getNumber(0));
		/* If this method had invocation of another method with throws clause and this method (getNumber()) didn't catch that exception, this line of code would have had to be wrapped in try and catch blocks. */
	}
}

/* You can also add throws Exception clause to the public static main void method. This will mean that this method does not handle an exception. This will mean that actually nothing handles exception in this program and program will just end with error message when exception is thrown. */