package chapter13;

public interface Sub1f {

	int JANUARY = 1, FEBRUARY = 2, MARCH = 3, APRIL = 4, MAY = 5, JUNE = 6;
	int JULY = 7, AUGUST = 8, SEPTEMER = 9, OCTOBER = 10, NOVEMBER = 11, DECEMBER = 12;
}
/*
 * Apart from interfaces containing headings of methods, they can also contain
 * constants. Note that first 6 constants are public, static and final. They are
 * constants. Note that the next six ones are just int. Variables in interfaces
 * MUST BE public, static and final. If you do not include keyword public, they
 * will be public automatically. It is forbidden for them to be any other. They
 * also must be final and static. If you do not include those keywords, they
 * will automaticallly be static and final. Generally speaking. You can omit
 * those keywords, those 12 variables are all constants, are all final and are
 * all static.
 */

/*
 * If you remember in chapter 10. We used interface Serializable. We used it to
 * save and load objects into binary files. We used binary file because they are
 * very fast to read from and save to. Usually an interface has method headings
 * and constants. However serializable doesn't have any of that. It may seem
 * pointless to have that serializable interface in the first place. However
 * this interface is special. It doesn't do anything expect one thing. It gives
 * permission for this class objects to be saved into a binary file. Nothing
 * else, just gives permission.
 */