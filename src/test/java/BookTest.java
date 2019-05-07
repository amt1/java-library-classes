import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void before(){
        book = new Book("Jurassic Park", "Michael Crichton", "Thriller");
    }

    @Test
    public void hasTitle(){
        assertEquals("Jurassic Park", book.getTitle());
    }

    @Test
    public void hasAuthor() {
        assertEquals("Michael Crichton", book.getAuthor());
    }

    @Test
    public void hasGenre() {
        assertEquals("Thriller", book.getGenre());
    }
}
