public class Library {
    private int capacity;
    private int bookCounter;
    private Book[] libraryStock;
    // using array not arraylist as it would be faster for a big library

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

    public Book lendBookByIndex(int index) {
        Book bookToLend = null;
        if (index < bookCounter) {
            bookToLend = libraryStock[index];
            bookCounter--;
            if (bookCounter > 0) libraryStock[index] = libraryStock[bookCounter];
            libraryStock[bookCounter] = null;
        }
        return bookToLend;
    // this needs some data validation / error checking
    }
}
