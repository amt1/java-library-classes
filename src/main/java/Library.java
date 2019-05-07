import java.util.HashMap;

public class Library {
    private int capacity;
    private int bookCounter;
    private Book[] libraryStock;
    // using array not arraylist as it would be faster for a big library
    private HashMap<String, Integer> booksByGenre;

    public Library(int capacity){
        this.capacity = capacity;
        this.libraryStock = new Book[capacity];
        this.bookCounter = 0;
        this.booksByGenre = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookCount() {
        return bookCounter;
    }

    public boolean addBook(Book book) {
        if (bookCounter >= capacity) return false;
        libraryStock[bookCounter] = book;
        updateGenres(book.getGenre(), 1);
        bookCounter++;
        return true;
    }

    public Book checkBookAtIndex(int index) {
        return libraryStock[index];
    }

    public Book lendBookByIndex(int index) {
        Book bookToLend = null;
        if (index < bookCounter) {
            bookToLend = libraryStock[index];
            bookCounter--;
            if (bookCounter > 0) libraryStock[index] = libraryStock[bookCounter];
            libraryStock[bookCounter] = null;
            updateGenres(bookToLend.getGenre(), -1);
        }
        return bookToLend;
    }

    public void updateGenres(String genre, int numberChange){
        Integer count = 1;
        if (booksByGenre.containsKey(genre)) count = booksByGenre.get(genre) + numberChange;
        System.out.println("count: " + count);
        if (count <= 0 ) {
            booksByGenre.remove(genre);
        } else {
            booksByGenre.put(genre, count);
        }
    }


    public void listGenres() {
        System.out.println("listing genres");
        booksByGenre.forEach((key,value) -> System.out.println(key + " = " + value));
    }
}
