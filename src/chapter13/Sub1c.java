package chapter13;

public interface Sub1c extends Sub1a {

	/**
	 * This method should return true if ob1.sameName(string) is true. If both names
	 * are the same, but ingore case sensitivity.
	 */
    boolean sameName(String name);
	/*
	 * This is an interface. This interface extends another interface. We can say
	 * that this interface is a child or derived interface. While Sub1a is a
	 * parent/base interface. Similarly to classes, inheritance also takes place
	 * here. For example, you want to create a class that implements this interface,
	 * namely Sub1c. That class then will have to meet requirements of this
	 * interface and all its ancestors. This interface inherits method headings from
	 * its ancestors. Class Sub1blabla will have to define Sub1a and Sub1c methods.
	 * Unless that class would be abstract, then those responsibilities are passed
	 * down to their descendants.
	 */
}

/*
 * It is good to add documented comments to the interface. Interface lists
 * method headings and the parameters the methods take. But the definition in
 * the class that implements this interface may be a mess. This method above
 * when defined, may be transformed to randomly give true and false based on
 * random numbers or always give true if someone doesn't follow the semantics of
 * the interface. The interface tells you what this method should do.
 */
