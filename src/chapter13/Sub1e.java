package chapter13;

public class Sub1e implements Sub1f {
	public static void main(String[] args) {
		System.out.println(JANUARY);
		/*
		 * Since this class implements Sub1f. All constants from Sub1f are visible here.
		 * And if this class had any derived classes, those classes would inherit the
		 * interface.
		 * 
		 * If this class also implemented some other interface, like Sub1z which would
		 * have same constant names as Sub1f, there would be a conflict of names. Sub1f
		 * has contant "JANUARY" whose value is 1, and Sub1z would have the same
		 * contant, running this code would result in an error (exception) (but only if
		 * you try to access them. If you never intend to use those constants, no error
		 * will happen, but when you try to read those contants, that's when the
		 * exception will take place. There are two contants with the same name. Similar
		 * with methods. If one interface has method heading "showInfo" and other
		 * interface has the same method heading but different return type. If one is
		 * int and the other one is String, it is also an error, you cannot overload
		 * methods depending on return type. This will result in an error, but only when
		 * you invoke those method. (funny thing is, compiler will force you to define
		 * those methods, but forbid you from using them due to name conflict). Compiler
		 * will not know which one to run and it will result in an error.
		 */
	}
}
