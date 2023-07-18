package chapter16;
//employee

public class Sub2a {
	String name;
	Sub2b dob;
	Sub2b startDate;

	public Sub2a(String newName, Sub2b newDob, Sub2b newStartDate) {
		name = newName;
		dob = newDob;
		startDate = newStartDate;
	}

	public int hashCode() {
		return this.toString().hashCode();
	}

	public String toString() {
		return name + " " + dob.toString() + " " + startDate.toString();
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj == this)
			return true;

		if (obj.getClass() != this.getClass())
			return false;
		else {
			Sub2a other = (Sub2a) obj;
			return (this.name == other.name && this.dob.equals(other.dob) && this.startDate.equals(other.startDate));
		}
	}

}
