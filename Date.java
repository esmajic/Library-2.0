

public class Date {

	private String dateBorrowedBook;
	private String dateReturnedBook;
	
	public Date(String dateBorrowedBook, String dateReturnedBook) {
		this.dateBorrowedBook = dateBorrowedBook;
		this.dateReturnedBook = dateReturnedBook;
	}

	public String getDateBorrowedBook() {
		return dateBorrowedBook;
	}

	public void setDateBorrowedBook(String dateBorrowedBook) {
		this.dateBorrowedBook = dateBorrowedBook;
	}

	public String getDateReturnedBook() {
		return dateReturnedBook;
	}

	public void setDateReturnedBook(String dateReturnedBook) {
		this.dateReturnedBook = dateReturnedBook;
	}

	@Override
	public String toString() {
		return "Date [dateBorrowedBook=" + dateBorrowedBook + ", dateReturnedBook=" + dateReturnedBook + "]";
	}
	
	
	

}
