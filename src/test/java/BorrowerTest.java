import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Book book;
    Book book2;
    Book book3;
    Book book4;

    Library library;
    Borrower borrower;

    @Before
    public void before() {
        book = new Book("Jurassic Park", "Michael Crichton", "Thriller");
        book2 = new Book("The Shining", "Stephen King", "Horror");
        book3 = new Book("The Dead Zone", "Stephen King", "Horror");
        book4 = new Book("Bimbos of the Death Sun", "Sharyn McCrumb", "Humour");

        library = new Library(5);
        borrower = new Borrower("Freddy");
    }

    @Test
    public void hasName(){
        assertEquals("Freddy", borrower.getName());
    }

    @Test
    public void canBorrowBookByIndexNumber() {
        library.addBook(book);
        library.addBook(book2);

        assertEquals(book, borrower.borrowBookByIndex(library, 0));
        assertEquals(book2, borrower.borrowBookByIndex(library, 0));

    }

    @Test
    public void canAddBookToBorrowedBooks() {
        library.addBook(book);
        library.addBook(book2);
        borrower.addToBooksBorrowed(borrower.borrowBookByIndex(library, 1));
        assertEquals(book2, borrower.checkIfBookBorrowed(0));
    }

    @Test
    public void hasNumberOfBooksBorrowed() {
        library.addBook(book);
        library.addBook(book2);
        borrower.addToBooksBorrowed(borrower.borrowBookByIndex(library, 1));
        borrower.addToBooksBorrowed(borrower.borrowBookByIndex(library, 0));
        assertEquals(2, borrower.countBooksBorrowed());
    }

    @Test
    public void canReturnAllBooks() {
        library.addBook(book);
        library.addBook(book2);
        borrower.addToBooksBorrowed(borrower.borrowBookByIndex(library, 1));
        borrower.addToBooksBorrowed(borrower.borrowBookByIndex(library, 0));
        assertEquals(true, borrower.returnAllBooks());
        assertEquals(0, borrower.countBooksBorrowed());

    }

    @Test
    public void canBorrowABookAtRandom(){
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        borrower.borrowRandomBook(library, library.getBookCount());
        assertEquals(1, borrower.countBooksBorrowed());
        // one of these should pass but I can't tell. Not a good way to check
//        assertEquals(book, borrower.checkIfBookBorrowed(0));
//        assertEquals(book2, borrower.checkIfBookBorrowed(0));
//        assertEquals(book3, borrower.checkIfBookBorrowed(0));
//        assertEquals(book4, borrower.checkIfBookBorrowed(0));


    }

}
