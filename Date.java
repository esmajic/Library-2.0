

public class Date {

	private String dateOfBorrow;

	Date(String dateOfBorrow) {
		this.dateOfBorrow = dateOfBorrow;
	}

	public String getDateOfBorrow() {
		return dateOfBorrow;
	}

	public void setDateOfBorrow(String dateOfBorrow) {
		this.dateOfBorrow = dateOfBorrow;
	}

	@Override
	public String toString() {
		return "Date [dateOfBorrow=" + dateOfBorrow + "]";
	}

}
