package chapter9;

public class Sub3 {

	static void causeError(boolean makeError) throws Exception {
		System.out.println("Start of method");
		
		if(makeError)
			throw new Exception();

		System.out.println("End of method");
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("---Start of code---");
		try {
			System.out.println("Start of try block");
			causeError(true);
			System.out.println("End of try block");
		} catch (Exception e) {
			System.out.println("Inside catch");
		} finally {
			System.out.println("Inside finally");
		}
		System.out.println("---End of code---");
		
		System.out.println("\n");
		
		System.out.println("---Start of code---");
		try {
			System.out.println("Start of try block");
			causeError(false);
			System.out.println("End of try block");
		} catch (Exception e) {
			System.out.println("Inside catch");
		} finally {
			System.out.println("Inside finally");
		}
		System.out.println("---End of code---");
		/* Block finally must be put at the end of all catch blocks. Finally block is always executed, whether an exception is thrown or not. First try block happens. Then catch if the right exception is caught if any exception is thrown at all. And then finally block happens no matter what. */
	}
}
/* Try block can be nested. Try and catch can be nested inside another try. And also can be nested in another catch. Whenever exception is thrown, the method invocation is interrupted, the flow control is passed to the nearest outer catch block (if type of Exception is right).
 * 
 *  Catch block may throw some exceptions too, for example depending on the getMessage(). and then invoke other methods etc.
 *  
 *  In previous chapter 3, assert keyword with boolean expression has been discussed. And in chapter 6, out of bounds exceptions has been discussed. Usually error type of exception and runtime-exception do not need to be caught because they usually indicate that there is an error in your code and that your code needs to be fixed, not write more code to handle the error that you have written. */