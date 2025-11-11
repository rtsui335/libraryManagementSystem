package project.project4;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int totalCopies;
    private int availableCopies;

    public Book(String title, String author, String ISBN, int copies){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }
    public void addCopies(int copies) {
        totalCopies += copies;
        availableCopies += copies;
    }

    public boolean borrowBook(){
        if( availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    public void returnBook(){
        if(availableCopies < totalCopies) {
            availableCopies++;
        }
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public int getAvailableCopies(){
        return availableCopies;
    }

    @Override
    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nTotal Copies: " + totalCopies + "\nAvailable Copies: " + availableCopies;
    }


}
