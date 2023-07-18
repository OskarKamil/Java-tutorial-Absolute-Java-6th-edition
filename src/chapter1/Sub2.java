package chapter1;

public class Sub2 {
	public static void main(String[] args) {

		int columns = 5;
		int rows = 3;
		int totalCells = columns * rows;
		/*
		 * That's how to assign values to variables. Variable names can include only
		 * capital letters, lower case letters, numbers and underscore. Good practice is
		 * to start names with lowercase. Upper case is reserved for classes.
		 */

		rows = columns = 7;
		/*
		 * Also valid. Value is copied from right to left. In effect both rows and
		 * columns are 7
		 */

		int appleNumber = 12;
		appleNumber += 8;
		appleNumber *= 1 + 1; // appleNumber = appleNumber * ( 1 + 1 )
		/*
		 * Shorter way to assign a value. a = a + 5, can be shortened by placing
		 * operation symbol such as +, -, *, /, % before =. All the expressions on the
		 * right are in parentheses, so in the second equation, 1+1 is computer first,
		 * and then is multiplied.
		 */

		double number = (1 / 2) * 3;
		System.out.println("(1/2) * 3 is equal to " + number);
		double number2 = (1 / 2.0) * 3;
		System.out.println("(1/2.0) * 3 is equal to " + number2);
		/*
		 * Two integers in the equation will result in int result. So 1 / 2 = 0. Because
		 * the reminder is removed. 1 / 2.0 will result in 0.5. If at least one operand
		 * is a type of floating number, then the result will also be a floating number.
		 */

		int numberDiv = 9;
		int numberDiv2 = 5;
		double numberResult = numberDiv / numberDiv2;
		double numberResult2 = numberDiv / (double) numberDiv2;
		/*
		 * The first result is 1.0 because two integers give integer value thus 9/5=1
		 * and then 1 is casted into double type so 1 becomes 1.0. The second result
		 * will be 1.8 because in this example we used type casting. If you want you can
		 * cast one type into another. Here int type was casted into double. 5 became
		 * 5.0, and floating number type in operation with int operand will result in
		 * floating number result.
		 */

		int n = 2;
		int valueProduced = 2 * (n++);
		System.out.println(valueProduced);
		System.out.println(n);
		/*
		 * The ++ operator increases a number by 1. -- decreases by one. ++n increments
		 * first and then uses the incremented number into the equation. n++ first takes
		 * the value of n before incrementation, and then it increments.
		 */
	}
}