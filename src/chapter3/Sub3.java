package chapter3;

public class Sub3{
	public static void main(String[] args) {
		
		int counter = 3;
		
		while(counter > 0){
			System.out.println("Hello there!");
			counter -= 1;
		}
		/* While loop repats itself when boolean statement in brackets is true. */		
		
		do {
			System.out.println("Hello here!");
			counter -= 1;
		}while(counter > 0);
		/* do while repeats itself at least once, then it checks boolean statement. */
		
		for(int i = 1; i<=10; i++) {
			System.out.println("Iteration #" + i);
		}
		/* Same as c++. There may be ',' in brackets meaning that more than one integer is initialized, or more than one update is executed. Update is the last part of 'for' bracket statement eg. i++. However it's better to include this in the body of the loop, and extra variable before loop to increade readibility. Also there may be loops inside loops. */
		
		loopInt:
		for(int i = 1; i<=10; i++) {
			System.out.println("Iteration #" + i);
			while(i>3 && i<7) {
				System.out.println("Inside loop");
				break loopInt;
			}
		}
		/* Example of naming a loop.
		 break; - exits intermost loop;
		 continue; - end iteration of a loop and starts loop again (if inside for, goes to update instruction)
		 break [labelname] - exits the loop with that label name. Basically goes to the closing parenthes } and continues from there.
		 
		 Break label doesn't need to be a label of a loop. You can label any statement. However some say it shouldn't be used. It's better to use good organised code than using labels. */
		
	}
}