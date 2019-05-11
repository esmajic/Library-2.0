

import java.util.ArrayList;

public class BorrowingBooks {

	private int bookNumber;
	private int accountNumber;
	private String date;

	public BorrowingBooks(int bookNumber, int accountNumber, String date) {
		this.bookNumber = bookNumber;
		this.accountNumber = accountNumber;
		this.date = date;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getDate() {
		return date;
	}

	public void borrowBooks(ArrayList<Accounts> accounts, ArrayList<Books> books, int accountNumber, int bookNumber,
			String date) throws Exception {
		if (isAccountNumber(accountNumber, accounts)) {
			System.out.println("\nAccount does not exist in our accounts data base! Please, try again.");

		} else if (isBookNumber(bookNumber, books)) {
			System.out.println("\nBook number does not exist in our books data base! Please, try again.");

		} else if (isBookAvailable(bookNumber, books)) {
			System.out.println("\nPresently, book is not available. Please, try another book.");

		} else if (accounts.get(getAccountNumberIndex(accountNumber, accounts)).getAmountOfBorrowedBooks() >= 3) {
			System.out.println("\nThree books have already been borrowed. Limit has been reached. Return books.");

		} else {
			books.get(getBookNumberIndex(bookNumber, books)).setBookStatus(false);
			accounts.get(getAccountNumberIndex(accountNumber, accounts)).setAmountOfBorrowedBooks(
					accounts.get(getAccountNumberIndex(accountNumber, accounts)).getAmountOfBorrowedBooks() + 1);
			System.out.println("\nBook is successfully issued to member with account number " + accountNumber);

		}

	}

	public boolean isBookNoUnique(int bookNumber, ArrayList<Books> books) {
		for (int i = 0; i < books.size(); i++) {
			while (books.get(i).getBookNumber() == bookNumber) {
				return true;
			}
		}
		return false;
	}

	public static boolean isBookNumber(int bookNumber, ArrayList<Books> books) {
		for (int i = 0; i < books.size(); i++) {
			while (books.get(i).getBookNumber() == bookNumber) {
				return false;
			}
		}
		return true;
	}

	public static int getBookNumberIndex(int bookNumber, ArrayList<Books> books) {
		int i;
		for (i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNumber() == bookNumber) {
				return i;
			}
		}
		return i;
	}

	public static void listAllBooks(ArrayList<Books> books) {
		if (books.size() > 0) {
			for (int i = 0; i < books.size(); i++) {
				System.out.println("* " + books.get(i).getBookNumber() + ", " + books.get(i).getBookTitle() + ", "
						+ books.get(i).isBookStatus() + " *");
			}
		} else {
			System.out.println("\nThere are no books registered in data base.");
		}

	}

	public static boolean isBookAvailable(int bookNumber, ArrayList<Books> books) {
		while (books.get(getBookNumberIndex(bookNumber, books)).isBookStatus()) {
			return false;
		}
		return true;

	}

	public boolean isAccountNoUnique(int accountNumber, ArrayList<Accounts> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			while (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAccountNumber(int accountNumber, ArrayList<Accounts> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return false;
			}
		}
		return true;
	}

	public static int getAccountNumberIndex(int accountNumber, ArrayList<Accounts> accounts) {
		int i;
		for (i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return i;
			}
		}
		return i;
	}

	public static void listAllAccounts(ArrayList<Accounts> accounts) {
		if (accounts.size() > 0) {
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println("* " + accounts.get(i).getAccountNumber() + ", " + accounts.get(i).getName() + ", "
						+ accounts.get(i).getAmountOfBorrowedBooks() + " *");
			}
		} else {
			System.out.println("\nThere are no accounts registered in data base.");
		}

	}

	public static void listAllBorrowedBooks(ArrayList<BorrowingBooks> borrowed) {
		if (borrowed.size() > 0) {
			for (int i = 0; i < borrowed.size(); i++) {
				System.out.println("* " + borrowed.get(i).getBookNumber() + ", " + borrowed.get(i).getAccountNumber()
						+ ", " + borrowed.get(i).getDate() + " *");
			}
		} else {
			System.out.println("\nThere are no borrowed books in data base.");
		}

	}

	public static boolean booksWithSameNumber(int bookNumber, ArrayList<Books> books) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNumber() == bookNumber) {
				return true;
			}
		}
		return false;
	}

	public static boolean accountsWithSameNumber(int accountNumber, ArrayList<Accounts> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;

	}
}
