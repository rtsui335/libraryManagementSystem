package project.project4;
import java.util.*;
public class LibraryManagementSystem {
    private static HashMap<String, Member> members;
    private static HashMap<String, Book> books;
    private static int memberCounter = 1;
    private static final Scanner input = new Scanner(System.in);

    private LibraryManagementSystem() {
        books = new HashMap<>();
        members = new HashMap<>();
    }

    public static void main(String[] args) {
        //A new book can be added to the library by specifying its title, ISBN, author, and the number of copies
        //searching book by title, ISBN, or author
        //book cannot be issues if no copies avalible
        //A new member can be added to the system by providing name
        libraryManagementSystem library = new libraryManagementSystem();
        while(true) {
            System.out.println("Welcome to the Library Management System!");

            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. List Borrowed Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int userChoice = libraryManagementSystem.input.nextInt();
            input.nextLine();

            switch (userChoice){
                case 1:
                    libraryManagementSystem.addBook();
                    break;
                case 2:
                    libraryManagementSystem.addMember();
                    break;
                case 3:
                    libraryManagementSystem.searchBook();
                    break;
                case 4:
                    libraryManagementSystem.issueBook();
                    break;
                case 5:
                    libraryManagementSystem.returnBook();
                    break;
                case 6:
                    libraryManagementSystem.listBorrowedBook();
                    break;
                case 7:
                    libraryManagementSystem.exit();
                    break;
            }
        }
    }
    private static void addBook() {
        System.out.println("Enter book title: ");
        String title = input.nextLine();

        System.out.println("Enter book author: ");
        String author = input.nextLine();

        System.out.println("Enter book ISBN number: ");
        String isbn = input.nextLine();

        System.out.println("Copies available for borrowing: ");
        int copies = input.nextInt();
        input.nextLine();

        //checks the hash map if the book contains has title to check duplicates
        if(books.containsKey(title)){
            Book existing = books.get(title);
            existing.addCopies(copies);
            System.out.println("Book already exists. Updated the number of copies in the library. Copies\n" + "available for borrowing: " + existing);
        } else {
            Book book = new Book(title, author, isbn, copies);
            books.put(title, book);
            System.out.println("Book added to library.");
        }
    }

    private static void addMember() {
        System.out.println("Enter member name: ");
        String name = input.nextLine();

        String memberID = "M" + memberCounter++;
        members.put(memberID, new Member(name, memberID));
        System.out.println("Member added: " + name + " (Member ID: " + memberID + ")");
    }

    public static void searchBook(){
        System.out.println("Search book by: ");
        System.out.println("1. Title ");
        System.out.println("2. ISBN ");
        System.out.println("3. Author ");
        System.out.println("Choose an option: ");
        int searchBy = input.nextInt();
        input.nextLine();

        switch(searchBy){
            case 1:
                System.out.println("Enter book title: ");
                String title = input.nextLine().trim().toLowerCase();
                if(books.containsKey(title)){
                    System.out.println("Book found: " + books.get(title));
                } else {
                    System.out.println("Book not found.");
                }
                break;
            case 2:
                System.out.println("Enter book ISBN: ");
                String isbn = input.nextLine().trim().toLowerCase();

                boolean isFound = false;
                for(Book book : books.values()) {
                    if (book.getISBN().toLowerCase().equals(isbn)) {
                        System.out.println("Book found: " + books);
                        isFound = true;
                        break;
                    }
                }
                if(!isFound){
                    System.out.println("Book not found.");
                }
                break;
            case 3:
                System.out.println("Enter book author: ");
                String author = input.nextLine();

                boolean found = false;
                for(Book book : books.values()) {
                    if (book.getAuthor().equals(author)){
                        System.out.println(book);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("Book not found.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    public static void issueBook(){
        System.out.println("Enter member ID: ");
        String memberID = input.nextLine();

        if(!members.containsKey(memberID)){
            System.out.println("Member not found");
            return;
        }

        System.out.println("Enter book title: ");
        String bookTitle = input.nextLine();

        if(!books.containsKey(bookTitle)){
            System.out.println("Book not found");
            return;
        }

        Book book = books.get(bookTitle);
        Member member = members.get(memberID);

        if (member.hasBorrowed(bookTitle)){
            System.out.println(memberID + " already has borrowed " + bookTitle);
            return;
        }

        if(!book.borrowBook()){
            System.out.println("This book is currently unavailable.");
            return;
        }

        member.borrow(bookTitle);
        System.out.println("Book issued " + bookTitle + " to " + memberID);
        }

    public static void returnBook(){
        System.out.println("Enter member ID: ");
        String memberBorrowedBooks = input.nextLine();

        if(!members.containsKey(memberBorrowedBooks)){
            System.out.println("Member not found");
            return;
        }

        System.out.println("Enter book title to return: ");
        String bookTitle = input.nextLine();

        if(!books.containsKey(bookTitle)){
            System.out.println("Book not found");
            return;
        }

        Book book = books.get(bookTitle);
        Member member = members.get(memberBorrowedBooks);

        if (!member.hasBorrowed(bookTitle)){
            System.out.println(memberBorrowedBooks + " has not borrowed this book: " + bookTitle + " by " + book.getAuthor());
            return;
        }

        member.returnedBook(bookTitle);
        book.returnBook();
        System.out.println("Book returned: " + bookTitle + " by " + book.getAuthor() + " from " + memberBorrowedBooks);
    }

    public static void listBorrowedBook(){
        System.out.println("Enter member ID to list borrowed books: ");
        String memberID = input.nextLine();

        if(!members.containsKey(memberID)){
            System.out.println("Member not found");
            return;
        }

        Member member = members.get(memberID);
        HashSet<String> borrowedBooks = member.getBorrowedBooks();

        if(borrowedBooks.isEmpty()){
            System.out.println(memberID + " has not borrowed any books");
            return;
        }

        System.out.println(memberID + " has borrowed the following books: ");
        for(String bookTitle : borrowedBooks){
            Book book = books.get(bookTitle);
            if (book != null){
                System.out.println(book.getTitle() + ", ISBN: " + book.getISBN() + ", by " + book.getAuthor());
            } else {
                System.out.println(bookTitle);
            }
        }
    }

    public static void exit(){
        System.out.println("Thank you for using the Library Management System!");
        input.close();
        System.exit(0);
    }
}
