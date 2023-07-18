package chapter7;

public class Sub3a extends Sub3 {

	protected int yearsInCountry;
	
	private void showInfo() {
		System.out.println("Name: " + super.name + "\nAge: " + age + "\nYears in country: " + yearsInCountry);
		/* You can use super when referring to variable or a method in base class. (as long as you have access to it - not private). In this case using super.name and name is exactly the same. */
	}	
	
	public boolean equals(Object otherObject) {		
		if (otherObject == null)
			return false;
		
		if (!(otherObject instanceof Sub3a))
			return false;
		/* object instanceof anotherObject - is similar to getClass() with one difference. instanceof not only checks if the class is the same, but also checks if object1 is a child of object2. The point of equals methods is to check if 2 objects are the same. obj.equals(obj2) should return same result as obj2.equals(obj1). However when using instanceof it will not work. If we used instanceof instruction in our equals method in both class definitions the results would be different depending on which object do we invoke the method with.
		 * If we invoked with object of type Sub3. It would return true because it is not null. It would return true because Sub3a object is a child of Sub3. Then it would go to comparing base variables value. It would return true if all variables in base parent classes would be equal. It is not good because that object derived class has also yearInCountry variable which would never be compared to the parent object (which would have not had anyway).
		 * If we invoked with object of type Sub3a. It would return true because it s not null. It would return false because it would check if parent type object is a child of a child type object which is obviously false.
		 * This is not a good practise when equals method returns various results depending on order of parameter and calling object.
		 * To remember simply, translate instanceof as "is itself or a child". instance of simply checks if obj1 is a not a base class of obj2. If it is not a parent, then it must be a child of self. */
		
		Sub3a other = (Sub3a)otherObject;
		return (name.equals(other.name) && age == other.age && yearsInCountry == other.yearsInCountry);
	}
	
	
}
