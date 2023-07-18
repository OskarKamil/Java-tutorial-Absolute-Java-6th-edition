package chapter14;

public class Sub2b {
	public static void main(String[] args) {
		/*
		 * Read Sub2c to understand this code first if you need.
		 */

		Sub2c<String> secretPair = new Sub2c<String>("Lucky", "Shot");
		Sub2c<String> guessPair = new Sub2c<String>("Good", "Morning");
		System.out.println("Did you guess? " + guessPair.equals(secretPair));
		/*
		 * Sub2c has constructor with 2 parameters. Here is shown how to use equals()
		 * method, but this is nothing new, same way you use equals even if it is not
		 * generic class.
		 */

		guessPair = new Sub2c<String>("Good", "Night");
		System.out.println("Did you guess? " + guessPair.equals(secretPair));

		guessPair.setFirst("Lucky");
		guessPair.setSecond("Shot");
		System.out.println("Did you guess? " + guessPair.equals(secretPair));

		Sub2c<Integer> intSecretPair = new Sub2c<Integer>(5, 10);
		/*
		 * Generics, first was String, this can be Integer, and equals method is in
		 * Integer class definition.
		 */

	}
}
