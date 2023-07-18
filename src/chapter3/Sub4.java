package chapter3;

public class Sub4 {
	public static void main(String[] args) {
		
		int n = 10;
		int sum = 10;
		while (n > 1)
		{
		//trace
		System.out.println("At the beginning of the loop: n = " + n);
		//trace
		System.out.println("At the beginning of the loop: sum = " + sum);
		sum = sum + n;
		n--;
		//trace
		System.out.println("At the end of the loop: n = " + n);
		//trace
		System.out.println("At the end of the loop: sum = " + sum);
		}
		System.out.println("The sum of the integers 1 to 10 is " + sum);
		/* It's good to use console as a little debugger. Here it will display values of the variables, and you can trace their values through the running of the program. */
		
		int num = 0;
		int numsum = 0;
		assert (num == 0) && (numsum == 0);
		while (num < 100)
		{
		num++;
		numsum = numsum + num;
		//numsum == 1 + 2 + 3 + ... + n
		}
		//numsum == 1 + 2 + 3 + ... + 100
		/* Assert is a tool that will simply check whether a statement is true. If it's true it means that program is running correctly, however if the statement is false, the program will end with error code. */
		
		/* It's a good practise to code bit by bit. After making major changes, check if the program is still working properly making small changes before making more changes. Also don't try to fix something by guessing because you may fix it, but actually the fix is only temporary, and later it will cause more bugs. */
	}
}
