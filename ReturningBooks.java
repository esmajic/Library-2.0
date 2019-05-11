

import java.util.ArrayList;

public class ReturningBooks {

	private int bookNumber;
	private int accountNumber;

	public ReturningBooks(int bookNumber, int accountNumber) {
		this.bookNumber = bookNumber;
		this.accountNumber = accountNumber;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void returnBook(ArrayList<BorrowingBooks> borrowed, ArrayList<Account> accounts, ArrayList<Book> books, int accountNumber, int bookNumber) throws Exception {
		if (isAccountNumber(accountNumber, accounts)) {
			System.out.println("\nAccount does not exist in our accounts data base! Please, try again.");

		} else if (isBookNumber(bookNumber, books)) {
			System.out.println("\nBook number does not exist in our books data base! Please, try again.");

		} else {
			books.get(getBookNumberIndex(bookNumber, books)).setBookStatus(true);
			accounts.get(getAccountNumberIndex(accountNumber, accounts)).setAmountOfBorrowedBooks(
					accounts.get(getAccountNumberIndex(accountNumber, accounts)).getAmountOfBorrowedBooks() - 1);
			System.out.println("\nBook with number " + bookNumber + " is successfully returned to Library");
			
			borrowed.remove(getBookNumberIndex(bookNumber, books));

		}
	}

	public static boolean isBookNumber(int bookNumber, ArrayList<Book> books) {
		for (int i = 0; i < books.size(); i++) {
			while (books.get(i).getBookNumber() == bookNumber) {
				return false;
			}
		}
		return true;
	}

	public static int getBookNumberIndex(int bookNumber, ArrayList<Book> books) {
		int i;
		for (i = 0; i < books.size(); i++) {
			if (books.get(i).getBookNumber() == bookNumber) {
				return i;
			}
		}
		return i;
	}

	public static void listAllBooks(ArrayList<Book> books) {
		if (books.size() > 0) {
			for (int i = 0; i < books.size(); i++) {
				System.out.println("* " + books.get(i).getBookNumber() + ", " + books.get(i).getBookTitle() + ", "
						+ books.get(i).isBookStatus() + " *");
			}
		} else {
			System.out.println("\nThere are no books registered in data base.");
		}

	}

	public static boolean isBookAvailable(int bookNumber, ArrayList<Book> books) {
		while (books.get(getBookNumberIndex(bookNumber, books)).isBookStatus()) {
			return false;
		}
		return true;

	}

	public boolean isAccountNoUnique(int accountNumber, ArrayList<Account> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			while (accounts.get(i).getAccountNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAccountNumber(int accountNumber, ArrayList<Account> accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return false;
			}
		}
		return true;
	}

	public static int getAccountNumberIndex(int accountNumber, ArrayList<Account> accounts) {
		int i;
		for (i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return i;
			}
		}
		return i;
	}

}
