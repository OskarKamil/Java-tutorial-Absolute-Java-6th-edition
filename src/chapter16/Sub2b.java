package chapter16;
//date

public class Sub2b {
	int month;
	int year;

	public Sub2b(int newMonth, int newYear) {
		month = newMonth;
		year = newYear;
	}

	public int hashCode() {
		return this.toString().hashCode();
	}

	public String toString() {
		return month + " " + year;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj == this)
			return true;

		if (obj.getClass() != this.getClass())
			return false;
		else {
			Sub2b other = (Sub2b) obj;
			return (this.month == other.month && this.year == other.year);
		}
	}
}
