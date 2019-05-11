

public class Books {

	private int bookNumber;
	private String bookTitle;
	private boolean bookStatus;

	Books(int bookNumber, String bookTitle, boolean bookStatus) {
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
		this.bookStatus = bookStatus;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;

	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public boolean isBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;

	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + ", bookStatus=" + bookStatus + "]";
	}

}
