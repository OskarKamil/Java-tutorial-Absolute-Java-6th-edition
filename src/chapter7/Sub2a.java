package chapter7;

public class Sub2a {

}

/*

package one;
public class B
{
protected int n;
...
}

package two;
import one.B;
public class D extends B
{
...
}

Then the following is a legitimate method that can appear in the definition of class D:
public void demo()
{
n = 42; //n is inherited from B.
}

The following is also a legitimate method definition for the derived class D:
public void demo2()
{
D object = new D();
object.n = 42; //n is inherited from B.
}

However, the following is not allowed as a method of D:
public void demo3()
{
B object = new B();
object.n = 42;//Error
}
The compiler will give an error message saying that n is protected in B.

Explained.
First method. You can access n anc change it because it is your n. You are D, and you are a child of B. And n instance variable is your instance variable, and you can change it however you want because it is protected, and you meet the criteria.

Second method. You create a new object of type D which is your type. You can change the value of n because n belongs to D thanks to inheritance, and thanks to protected access, object D is allowed to change the value of the variable.

Third method. You create a new object of type B. B is not your direct type. Your type is D, you cannot change your parent. You have no access to that variable. In this case, object B is standalone object, and you cannot change it because it is protected. You are a child of this class type, but not of this specific object. This object has no child classes, so you cannot change the parent.

*/