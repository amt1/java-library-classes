import java.util.ArrayList;
import java.util.Random;

public class Borrower {
    private String name;
    private ArrayList<Book> booksBorrowed;

    public Borrower(String name){
        this.name = name;
        this.booksBorrowed = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public Book borrowBookByIndex(Library library, int index){
        return library.lendBookByIndex(index);
    }

    public boolean addToBooksBorrowed(Book book) {
        String msg = new String();
        boolean success = false;
        if (book != null) {
            booksBorrowed.add(book);
            msg = String.format("Just borrowed %s", book.getTitle());
            success = true;
        } else {
            msg = "Book not found";
        }
        System.out.println(msg);
        return success;
    }

    public Book checkIfBookBorrowed(int index) {
        return booksBorrowed.get(index);
    }

    public int countBooksBorrowed(){
        return booksBorrowed.size();
    }

    public boolean returnAllBooks(){
        booksBorrowed.clear();
        if (countBooksBorrowed() > 0) return false;
        return true;
    }

    public boolean borrowRandomBook(Library library, int currentBookCount) {
        Random rand = new Random();
        String msg = "";
        boolean success = false;
        int index = rand.nextInt(currentBookCount);
        success = addToBooksBorrowed(borrowBookByIndex(library, index));
        return success;
    }
}
