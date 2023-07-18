package chapter3;

public class Sub2{
	public static void main(String[] args) {
		
	boolean validResult;
	boolean passed;
	
	int minPoints = 0;
	int maxPoints = 100;
	int passPoints = 70;
	int receivedPoints = 75; //or any other number
	
	validResult = (receivedPoints >= minPoints) && (receivedPoints <= maxPoints);
	passed = (validResult == true) && (receivedPoints >= passPoints);
	/* Same as c++. Same precedence rules as c++. && both need to be true to return true, || needs only one.
	 * Java uses short-curcuit evaluation. It means that if at least one side needs to return true, java doesn't check the other side because result of the other side will not affect the overall result. Similar with &&, it needs two side to return true, if first one return false, java doesn't evaluate the other one because the result will still be false. If you want you may need to use complete evaluation. To do that, you need to use & for both and | for only one. */
	
	/* As string as objects of String class, they have their own methods to compare string whether they are equal or not. */
	
	System.out.println("Valid results? " + validResult + "\nPassed the test? " + passed);

	}
}

/*
PRECEDENCE
ASSOCIATIVITY
From highest at top to lowest at bottom. Operators in the same group
have equal precedence.
Dot operator, array indexing, and method invocation: .,[ ],()
Left to right
++ (postfix, as in x++), -- (postfix)
Right to left
The unary operators: +, -, ++ (prefix, as in ++x), -- (prefix),
!, ~ (bitwise complement)1
Right to left
new and type casts (Type)
Right to left
The binary operators *, /, %
Left to right
The binary operators +, -
Left to right
The binary operators <<, >>, >>> (shift operators)1
Left to right
The binary operators <, >, <=, >=, instanceof
Left to right
The binary operators ==, !=
Left to right
The binary operator &
Left to right
The binary operator ^ (exclusive or)1
Left to right
The binary operator |
Left to right
The binary operator &&
Left to right
The binary operator ||
Left to right
The ternary operator (conditional operator) ?:
Right to left
The assignment operators =, *=, /=, %=, +=, -=, &=, |=, ^=, <<=, >>=, >>>=
Right to left
 */