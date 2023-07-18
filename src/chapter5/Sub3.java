package chapter5;

public class Sub3 {
	
	private final String name;
	private final Sub3a born;
	private final Sub3a died;
	
	public Sub3(String name, Sub3a born, Sub3a died) {
		this.name = name;
		
		if(born == null)
			System.exit(0);
		this.born = new Sub3a(born);
		
		if(died == null)
			System.exit(0);
		this.died = new Sub3a(died);
	}
	/* We should always check if object is null. If it is, we should close the program, if we try to assign new Sub3a(born) which may be null, then we will have an error. First check if it's null, and if it is not. Then continue the program. */
	
	public Sub3(Sub3 other) {
		if(other == null)
			System.exit(0);
		this.name = other.name;
		
		if(other.born == null)
			System.exit(0);
		born = new Sub3a(other.born);
		
		if(other.died == null)
			System.exit(0);
		died = new Sub3a(other.born);
	}
	/* Same here. Using copy constructor we copy different object of the same type. We check if it is not null. And if it is not, then we assign new value. Note that born doesn't just get other.born. It needs to create new instance of Sub3 object to pass the value, otherwise it will pass the memory address which will lead to a leak. */
	
	public String toString() {
		return ("Name: " + name + "\nDate of birth: " + born.toString() + "\nDate of death: " + died.toString());
	}
	
	public Sub3a getBD() {
		return new Sub3a(born);
	}
	/* Here we return the new instance of Sub3a. Not the memory address. Otherwise it would lead to a leak. And for example creating new object of Sub3a using the wrong method. Changing value of that new object would also change value of this object. Which is not what should be happening. */
	
	public static void main(String[] args) {
		
		Sub3 pet1 = new Sub3("Sisi", new Sub3a(3,2,2005), new Sub3a(1,1,2010));
		System.out.println(pet1);
		/* In constructor of Sub3, one of arguments is different data type than primitive. If it was primitive, for example int, double or string, we would just enter 3, 2.6 or "Sisi". However with data types, we need to create new instance. Using keyword new, we create are using an constructor of that class type and inside the method definition. If that data was some object of itself. Let's say we create new Sub3a and call it date01. And then using Sub3 constructor add date01, and then we would use method inside Sub3 to set the new value. Setting new value to that date, would also change date01 which is a data. That's why we create new Sub3a, which is using it's own constructor.
		 * 
		 *  If born and died objects were public, we could use their methods like usual. pet1.died.setdate. If this program would be checking if death date is not before born date, this data leak would allow to input valid date, but not logical as death date would always have to be after born date.
		 *  
		 *  This class is immutable class because there is no mutator. There is only constructor but there are no other mutable methods. The class Sub4a is mutable class because it has method setDate. Privacy leak happens when you return a memory address of a mutable class. That returned address can be altered and can leak data. You should always return a value of a mutable class by using constructor and keyword new. This way it can still be mutated, but will not affect the original object that returned it. This is called a deep copy when you copy all data. A shallow copy is when you copy a memory address. */
		
	}
}