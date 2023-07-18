package chapter3;

import java.util.Random;
/* To use Random class, we need to import it first. */

public class Sub5{
	public static void main(String[] args) {
		
		Random randomnumber = new Random();
		int coin;
		String result;
		/* Creating new object of class Random, same as with Scanner. */
		
		for(int i = 1; i <= 10; i++) {
			if(randomnumber.nextInt(2) + 1 == 1)
				result = "Tails";
			else
				result = "Heads";
					
			System.out.println("Count number #" + i + ". Result: " + result);
			
		}
		/* Syntax: randomnumber.nextInt(lenght) + start. Where lenght is how many cases can be, and start is starting point, going up. Roll a dice would be: random.nextInt(6)+1, where 6 is possible cases, and 1 is starting point.
		 * in place of lenght can be put "n" which will output only non negative numbers. Leaving both spaces empty, it will output any random integer. */
		
		/* There is also randomnumber.nextDouble() * lenght + start. It works same as nextInt. lenght is how many cases and start is starting point. Foe example nextDouble() * 36.6 + 0 will output any number between 0 and 36.6 exclusive. leaving all variables empty, this will output just random double between 0 and 1 exclusive. n>=0 and n<1 */
		
	}
}