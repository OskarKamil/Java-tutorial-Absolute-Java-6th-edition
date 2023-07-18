package chapter5;

public class Sub3a {

	private int day;
	private int month;
	private int year;
	
	public Sub3a(int day, int month, int year) {
		setDate(day, month, year);
	}
	/* Constructor that takes 3 number and then runs method to check if the number are valid. */
	
	public Sub3a(Sub3a other) {
		if(other == null)
			System.exit(0);
		
		day = other.day;
		month = other.month;
		year = other.year;
	}
	/* This is a copy constructor. It takes other object of the same type. Checks if it is null and if not, it copies data from the other one to here. */
	
	private boolean dateOK(int day, int month, int year) {
		if(day<1 || day>31)
			return false;
		
		if(month<1 || month>12)
			return false;

        return year >= 1900 && year <= 2020;
    }
	/* Method that checks if entered date is valid. If not, it closes the program. */
	
	public void setDate(int day, int month, int year) {
		if(dateOK(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
		}
		else
			System.exit(0);
	}	
	
	public String toString() {
		return (day + "/" + month + "/" + year);
	}
	
}
