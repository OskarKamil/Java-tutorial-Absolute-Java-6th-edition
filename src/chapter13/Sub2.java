package chapter13;

public class Sub2 {
	private class Sub2InnerClass {
		private int pounds;
		private int pennies;
		/*
		 * This is an inner class definition. This inner class is inside outer class
		 * Sub2. This inner class has 2 instance variables of type int.
		 */

		public Sub2InnerClass(String stringAmount) {
			pounds = Integer.parseInt(stringAmount.substring(0, stringAmount.length() - 3));
			pennies = Integer.parseInt(stringAmount.substring(stringAmount.length() - 2));
		}
		/*
		 * This method has the same name as the inner class, so it must be a
		 * constructor. This constructor takes one String as an argument. And then using
		 * Integer.parseInt() method we are trying to get a pound and penny value of the
		 * String. The String must be in currency format for example 11.99. So 11 is
		 * parsed into pounds and 99 is parsed into pennies.
		 */

		public String getAmount() {
			if (pennies > 9)
				return (pounds + "." + pennies);
			else
				return (pounds + ".0" + pennies);
		}
		/*
		 * Just a method that returns in proper readable way of value.
		 */

		public void addIn(Sub2InnerClass secondAmount) {
			int newpennies = (pennies + secondAmount.pennies) % 100;
			int carry = (pennies + secondAmount.pennies) / 100;
			pennies = newpennies;
			pounds = pounds + secondAmount.pounds + carry;
		}
		/*
		 * A method that will add 2 values together. The argument to this method is
		 * another object of inner class. So this method will allow us only to add a
		 * value of another existing object.
		 */
	}
	/*
	 * If you look here. The parentheses are closed. The definition of inner class
	 * is over. But we are still inside the body of an outer class. Now we will
	 * finish defining the outer class.
	 */

	private final Sub2InnerClass balance;

	public Sub2() {
		balance = new Sub2InnerClass("0.00");
	}
	/*
	 * We created an instance variable of an inner class. An object. And here is
	 * Sub2(), it is a constructor of Sub2, who will create a balance object of
	 * Sub2InnerClass class using inner class constructor.
	 */

	public String getBalance() {
		return balance.getAmount();
	}

	public static void main(String[] args) {
		Sub2 obj1 = new Sub2();
		System.out.println(obj1.getBalance());
		System.out.println(obj1.balance.getAmount());
		/*
		 * Here we created an object of Sub2 class. You can invoke method getBalance,
		 * and this method will invoke another method of the inner class. Or if you
		 * want, you can invoke the method getAmount by saying of which that method to
		 * be invoked of.
		 *
		 * The inner class is private here so it means that it is a helping class. This
		 * class is used only in here and will not be able to be used on any other
		 * class. Also you cannot invoke method getAmount of the inner class from
		 * somewhere else.
		 *
		 * However inner class methods and variables are private, the outer class can
		 * see this, and other way around too. If outer class had private
		 * methods/variables, the inner class can see them too. To use non static method
		 * of inner class first you need to create an object of the inner class.
		 */
	}
}
