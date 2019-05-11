

public class Accounts {

	private int accountNumber;
	private String name;
	private int amountOfBorrowedBooks;

	Accounts(int accountNumber, String name, int amountOfBorrowedBooks) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.amountOfBorrowedBooks = amountOfBorrowedBooks;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmountOfBorrowedBooks() {
		return amountOfBorrowedBooks;
	}

	public void setAmountOfBorrowedBooks(int amountOfBorrowedBooks) throws Exception {
		if (amountOfBorrowedBooks < 0) {
			throw new Exception("Value for amount of borrowed books cannot be negative");
		} else {
			this.amountOfBorrowedBooks = amountOfBorrowedBooks;
		}
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", amountOfBorrowedBooks="
				+ amountOfBorrowedBooks + "]";
	}

}
