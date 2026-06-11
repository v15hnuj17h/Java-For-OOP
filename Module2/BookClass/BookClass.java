// Create a Book class with:a
// Attributes: title (String), author (String), price (double), pages (int)
// 3 constructors:
// Default: sets title="Unknown", price=0.0
// With title and author only
// With all 4 attributes
// Method displayBook() to print all details
// Method applyDiscount(double percent) to reduce price
// In main: create one book with each constructor, display all


class Book {

    String title, author;
    double price;
    int pages;

    // Default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
        pages = 0;
    }

    // Constructor with title and author
    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        this.pages = 0;
    }

    // Constructor with all attributes
    Book(String title, String author, double price, int pages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    // Method to display book details
    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Pages: " + pages);
        System.out.println("----------------------");
    }

    // Method to apply discount
    void applyDiscount(double percent) {
        price -= price * (percent / 100);
    }
}
public class BookClass {
    public static void main(String[] args) {

        // Book with default constructor
        Book b1 = new Book();

        // Book with title and author
        Book b2 = new Book("Java Basics", "John Doe");

        // Book with all attributes
        Book b3 = new Book("Advanced Java", "Jane Smith", 500.0, 350);

        // Apply discount to one book
        b3.applyDiscount(10);

        // Display all books
        b1.displayBook();
        b2.displayBook();
        b3.displayBook();
    }
}