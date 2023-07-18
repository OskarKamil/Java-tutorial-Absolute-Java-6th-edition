package chapter5;

import chapter4.Sub4a;
/* We imported a class from another package. If this package(folder) is in the main folder, we just enter name of that folder, here it is chapter4. */
//import chapter4.*; //this way we import all classes in this package. Note that if this package had subpackage(other package inside), this subpackage would not be imported.

public class Sub4 {
	public static void main(String[] args) {
		chapter4.Sub1a student01 = new chapter4.Sub1a();
		/* If a class that we want to use is in another package(folder) we can specify what package by adding its name before class type but only if we have access to that package, if it's public for example. */
		
		chapter5.Sub4a obj1 = new chapter5.Sub4a(1,2,3);
		Sub4a obj01 = new Sub4a();
		/* When you hoover a mouse you will see more info about those objects. First one refer to chapter5. When you import a class that has the same name as a class already in the same package that this class. The imported class takes first place. So whenever you use name Sub4a, it refers to the imported class. If you wanna use Sub4a that already exists in this package already, you need to specify the package. */
		}
}
/* Let's assume you need to use 2 classes. They are in two different packages but the classes have the same name. You cannot import them and use them cuz it would cause an error. Instead you can import one and use it as usual Sub4a new object. And the other one chapter3.Sub4a new object. As you can see the classes have the same name but are in different packages. You can either use package name to specify them everytime, or specify only one and the other one import. */