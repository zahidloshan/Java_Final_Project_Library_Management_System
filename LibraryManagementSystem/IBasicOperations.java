package LibraryManagementSystem;

public interface IBasicOperations {

    void borrow(Patron p, Book b);

    void returnBook(Patron p, Book b);

    void fine(Patron p, double amount);

}
