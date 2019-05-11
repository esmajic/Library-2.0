# Library-2.0
nova verzija Library

Create Library project.

App should offer following services:

account registration
book registration
borrowing books on certain time frame
detailed priontout of all existing accounts
Account registration When account must be registered take following parameters:

account number (int)
customer name (String)
amount of borrowed books (int) Validation:
accounts with identical number mustn't be created
prevent creation of account number with negative value
Book registration When book must be registered take following parameters:

book number(int)
book title(String)
book status(availability) (boolean) Validation:
books with identical number mustn't be created
prevent creation of book number with negative value
Borrowing a book When book must be borrowed following parameters must be used:

account number(int)
book number(int)
date (Date)
When book is borrowed app must log it, increase number of borrowed books by that user account and change book status. Oposite goes when book must be returned. Validation:

prevent borrowing when user has preveously borrowed 3 books
prevent borrowing if book is not available
prevent borrowing if user account number does not exist
prevent borrowing if book number is invalid/ does not exist
# Library-2.0
# Library-2.0
