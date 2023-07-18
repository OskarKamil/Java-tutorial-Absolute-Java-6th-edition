package chapter7;

public class Sub1a extends Sub1 {
    /* Subclass, child class. extends keyword means that this class is a subclass of Sub1. All private and public variables are also available in this class and object created of this type also has those variables. Only public methods are available here, not private methods. This is called inheritance because this class inherits data from their parent class. */

    /* This is a subclass for students from Europe. */

    private final String countryOfOrigin;
    private final int yearOfArrival;

    public Sub1a() {
        super();
        /* super keyword is a reference to a parent class, base class. Just replace word super with Sub1 and everything will make sense. super() is an empty constructor. If you do not include this line, compiler will automatically invoke an empty constructor anyway in its parent class. If the parent class doesn't include an empty constructor, it will result in an error. The rule is that constructor can be invoked only in the first line of the child constructor, nowhere else. And it cannot take arguments of instance variables. It makes sense because the object is not created yet, you are creating it with a constructor, thus you cannot access the variables because virtually they don't exist yet. */
        countryOfOrigin = "[unknown]";
        yearOfArrival = 0;
    }

    public Sub1a(String name, int yob) {
        super(name, yob);
        /* Here we are creating an object, and passing two values two parent constructor. */
        countryOfOrigin = "[unknown]";
        yearOfArrival = 0;
    }

    public Sub1a(String name, int yob, String origin, int arrival) {
        super(name, yob);
        countryOfOrigin = origin;
        yearOfArrival = arrival;
    }

    public Sub1a(Sub1a original) {
        super(original);
        /* Copy constructor. Note that you pass object of type Sub1a into Sub1 copy constructor and it doesn't cause an error. It is because Sub1a is actually Sub1. All subclasses are also all of their parent classes (ancestor classes). */
        countryOfOrigin = original.countryOfOrigin;
        yearOfArrival = original.yearOfArrival;
    }

    public String showInfo() {
        return (super.showInfo() + "\nFrom: " + countryOfOrigin + "\nYear of arrival to country: " + yearOfArrival);
        /* Overridden showInfo method. Rule for overriding methods of base classes. The return type must be exactly the same. In base class the return type was String so in here must be String. If it was void, so in here must have been void. Arguments or lack thereof must be the same. Otherwise, it will be overloading. You cannot access [name] variable in this method because the variable is private, and however it belongs to parent class, it is still private and cannot be accessed. You could use public method getter like getName or getYob, or you super method and add to it.
         * However, there is one exception. If you had another class that has a method that return type is a child of some other class, you can create subclass and override that method with different type, but its parent type. */
    }

}