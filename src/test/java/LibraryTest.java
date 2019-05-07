import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Book book;
    Book book2;
    Library library;

    @Before
    public void before() {
        book = new Book("Jurassic Park", "Michael Crichton", "Thriller");
        book2 = new Book("The Shining", "Stephen King", "Horror");

        library = new Library(5);
    }

    @Test
    public void hasCapacity() {
        assertEquals(5, library.getCapacity());
    }

    @Test
    public void canAddBook() {
        library.addBook(book);
        assertEquals(book, library.checkBookAtIndex(0));
    }

    @Test
    public void canAddAnotherBook() {
        library.addBook(book);
        library.addBook(book2);
        assertEquals(book2, library.checkBookAtIndex(1));
        // ok so that add method won't work as it doesn't push the rest along
    }

    @Test
    public void canIGetTheBookCount() {
        assertEquals(0, library.getBookCount());
        library.addBook(book);
        assertEquals(1, library.getBookCount());
        library.addBook(book2);
        assertEquals(2, library.getBookCount());
        // no it is always the array size for this type of array: use a counter
    }

    @Test
    public void cantAddStockIfFull() {
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book);
        library.addBook(book2);
        assertEquals(true, library.addBook(book));
        assertEquals(false, library.addBook(book2));
    }
}

