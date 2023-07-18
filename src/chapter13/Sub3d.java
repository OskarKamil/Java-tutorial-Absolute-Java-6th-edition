package chapter13;
//nested public classes

public class Sub3d {
	public class Sub3dInner {
		public class Sub3dInnerInner {
		}
	}

	public static void main(String[] args) {
		Sub3d outerObject = new Sub3d();
		Sub3d.Sub3dInner innerObject = outerObject.new Sub3dInner();
		Sub3d.Sub3dInner.Sub3dInnerInner innerInnerObject = innerObject.new Sub3dInnerInner();
		/*
		 * You don't have to limit yourself with only 2 levels of classes: outer and
		 * inner class. You can have them as nested as you wish. In here you have 3
		 * levels of classes. Let's analyze the code:
		 * 
		 * 1. Standard creation of an object. In left reference or right type and
		 * constructor.
		 * 
		 * 2. Standard creation of an object of inner class. On the left you have type
		 * of the object, which is outerClassName.currentClassName and on the right side
		 * you have name of the outer object that will be connected for this inner
		 * object, then new, then constructor. If you think about it, that's why you
		 * need outObjectName.new. This is non static class so inner object must be
		 * connected to the outer object.
		 * 
		 * 3. Similar like 2nd line. On the left you have reference of the object, which
		 * is outerClass.outerClass.currentClassName nameOfObject, and on the right side
		 * you have name of the object that will be connected to the new object you are
		 * creating, here it is innerObject.new which was created one line above, and
		 * then constructor name.
		 */

	}
}
