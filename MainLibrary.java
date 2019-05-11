

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainLibrary {

	public static ArrayList<Account> numbers = new ArrayList<>();
	public static ArrayList<Book> bookNumbers = new ArrayList<>();
	public static ArrayList<BorrowingBooks> borrowed = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		int accountNo, bookNumber;
		int amountBorrowedBooks;
		String name, bookTitle;
		boolean bookStatus;
		Scanner input = new Scanner(System.in);
		int option;
		do {

			System.out.println("=====================================");
			System.out.println("=        Welcome to Library         =");
			System.out.println("=====================================");
			System.out.println();

			System.out.println("Select 1 to create new account ");
			System.out.println("Select 2 to register book");
			System.out.println("Select 3 to borrow book");
			System.out.println("Select 4 to return a book");
			System.out.println("Select 5 to list all accounts");
			System.out.println("Select 6 to list all book titles");
			System.out.println("Select 7 to list borrowed books");
			System.out.println("Select 0 to exit");
			System.out.println("\nPlease, choose desired option:  ");
			option = input.nextInt();

			if (option == 1) {
				int x = 1;
				do {
					try {
						System.out.println("\nCreating account...");
						System.out.println();
						accountNo = (int) (Math.random() * 1000) + 1;
						while (BorrowingBooks.accountsWithSameNumber(accountNo, numbers)) {
							accountNo = input.nextInt();
						}
						input.nextLine();
						System.out.println("Enter account's owner name:  ");
						name = input.nextLine();

						System.out.println("Enter number of borrowed books:  ");

						amountBorrowedBooks = input.nextInt();

						Account accounts = new Account(accountNo, name, amountBorrowedBooks);

						accounts.setAmountOfBorrowedBooks(amountBorrowedBooks);

						numbers.add(accounts);

						System.out.println("Account with the account number " + accountNo
								+ " has been successfully entered in our data base!");
						System.out.println();
						x = 2;
					} catch (Exception e) {
						System.out.println(e);
					}
				} while (x == 1);

			} else if (option == 2) {
				int x = 1;
				do {
					try {
						System.out.println("\nCreating book number...");
						System.out.println();

						bookNumber = (int) (Math.random() * 10000) + 1;
						if (BorrowingBooks.booksWithSameNumber(bookNumber, bookNumbers)) {
							bookNumber = input.nextInt();
						}
						input.nextLine();
						System.out.println("Enter book title:  ");
						bookTitle = input.nextLine();
						System.out.println("Is book available in library?:  ");
						bookStatus = input.nextBoolean();

						Book books = new Book(bookNumber, bookTitle, bookStatus);

						books.setBookStatus(bookStatus);
						bookNumbers.add(books);

						System.out.println("\nBook with the book number " + bookNumber
								+ " has been successfully entered in our data base!");
						System.out.println();
						x = 2;
					} catch (InputMismatchException ex) {
						System.out.println("Wrong entry detected. Please, enter boolean value for variable!");

					}
				} while (x == 1);

			} else if (option == 3) {

				System.out.println("\nBorrowing a book...  ");
				System.out.println("Enter book number: ");
				bookNumber = input.nextInt();
				System.out.println("Enter account number: ");
				accountNo = input.nextInt();
				input.nextLine();
				System.out.println("Enter date (dd-MM-yyyy):");
				String date = input.nextLine();
				System.out.println();

				BorrowingBooks borrow = new BorrowingBooks(bookNumber, accountNo, date);
				borrowed.add(borrow);

				borrow.borrowBooks(numbers, bookNumbers, accountNo, bookNumber, date);
				System.out.println();

			} else if (option == 4) {

				System.out.println("\nReturning a book...  ");
				System.out.println("Enter book number: ");
				bookNumber = input.nextInt();
				System.out.println("Enter account number: ");
				int accountNumber = input.nextInt();
				input.nextLine();
				System.out.println("Enter date (dd-MM-yyyy):");
				String date = input.nextLine();
				System.out.println();

				ReturningBooks returnBook = new ReturningBooks(bookNumber, accountNumber);

				returnBook.returnBook(borrowed, numbers, bookNumbers, accountNumber, bookNumber);

				BorrowingBooks ret = new BorrowingBooks(bookNumber, accountNumber, date);
				borrowed.remove(ret);

			} else if (option == 5) {
				System.out.println("List of registered accounts:");
				BorrowingBooks.listAllAccounts(numbers);
				System.out.println();

			} else if (option == 6) {
				System.out.println("List of registered book titles:");
				BorrowingBooks.listAllBooks(bookNumbers);
				System.out.println();

			} else if (option == 7) {
				System.out.println("List of all borrowed titles:");
				BorrowingBooks.listAllBorrowedBooks(borrowed);
				System.out.println();
			}

		} while (option != 0);

		System.out.println("Selected option for Exit. Thank you for using our services.");

		input.close();
	}

}
