package chapter16;
//date

public class Sub3c {

	int day, month, year;

	public Sub3c(int newDay, int newMonth, int newYear) {
		day = newDay;
		month = newMonth;
		year = newYear;
	}

	protected void setDate(int newDay, int newMonth, int newYear) {
		day = newDay;
		month = newMonth;
		year = newYear;
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}

}
