import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Book book;
    Book book2;
    Book book3;
    Book book4;
    Library library;

    @Before
    public void before() {
        book = new Book("Jurassic Park", "Michael Crichton", "Thriller");
        book2 = new Book("The Shining", "Stephen King", "Horror");
        book3 = new Book("The Dead Zone", "Stephen King", "Horror");
        book4 = new Book("Bimbos of the Death Sun", "Sharyn McCrumb", "Humour");

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

    @Test
    public void canLendBookByIndex() {
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        assertEquals(4, library.getBookCount());

        assertEquals(book2, library.lendBookByIndex(1));
        assertEquals(3, library.getBookCount());

        assertEquals(book4, library.lendBookByIndex(1));
        assertEquals(2, library.getBookCount());

        assertEquals(book3, library.lendBookByIndex(1));
        assertEquals(1, library.getBookCount());
        System.out.println("hello");
        assertEquals(book, library.lendBookByIndex(0));
        assertEquals(0, library.getBookCount());


    }
    @Test
    public void canCountGenres() {
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book);

        library.listGenres();

        library.lendBookByIndex(4);

        library.listGenres();

        library.lendBookByIndex(3);
        library.listGenres();
        library.lendBookByIndex(2);
        library.listGenres();
        library.lendBookByIndex(1);
        library.listGenres();
        library.lendBookByIndex(0);
        System.out.println("all lent out");

        library.listGenres();
        library.listGenres();
        library.listGenres();

    }
}

