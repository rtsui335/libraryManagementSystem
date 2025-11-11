package project.project4;
import java.util.HashSet;
public class Member {
    private String name;
    private String membershipNumber;
    private HashSet<String> borrowedBooks;

    public Member(String name, String membershipNumber){
        this.name = name;
        this.membershipNumber = membershipNumber;
        this.borrowedBooks = new HashSet<>();
    }
    public boolean hasBorrowed(String bookTitle){
        return borrowedBooks.contains(bookTitle);
    }

    public void borrow(String bookTitle){
        borrowedBooks.add(bookTitle); //adds borrowed book to the hash set
    }

    public void returnedBook(String bookTitle){
        borrowedBooks.remove(bookTitle); //removes borrowed book from the hash set
    }

    public HashSet<String> getBorrowedBooks(){
        return borrowedBooks;
    }

    public String getMembershipNumber(){
        return membershipNumber;
    }

    public String getName(){
        return name;
    }




}
