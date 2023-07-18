package chapter4;

public class Sub2a {

	private int day, month, year;
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	/* These are three accessors. They are used to access private variable members. Usually a class definition should have a accessor for each variable. They usually start with word get. */
	
	public boolean setDay(int day) {
		if(day>0 && day<32) {
			this.day = day;
			return true;
		}			
		else
			return false;
	}
	
	public boolean setMonth(int month) {
		if(month>0 && month<13) {
			this.month = month;
			return true;
		}			
		else
			return false;
	}
	
	public boolean setYear(int year) {
		if(year>1900 && year<2020) {
			this.year = year;
			return true;
		}			
		else
			return false;
	}
	/* These are three mutators. They are used to change value of a variables in a class. They should start with word set. They don't necessarily need to be value of boolean and return any value. They can be void and just print about the result, whether the data input was valid or not. This is why changing values of variables should be done by methods, they can be decisgned to check if the data input is correct. If we just used objectname.day = 56 and obectname.month = 15 it would create a date 56/15/2020 for example, which is very wrong. All data should be input through methods. */
	
}
