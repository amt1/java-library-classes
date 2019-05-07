public class Library {
    private int capacity;
    private Book[] libraryStock;
    private int bookCounter;

    public Library(int capacity){
        this.capacity = capacity;
        this.libraryStock = new Book[capacity];
        this.bookCounter = 0;
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
        bookCounter++;
        return true;
    }

    public Book checkBookAtIndex(int index) {
        return libraryStock[index];
    }
}
