package coreservlets.function;

public class Writer extends Person {
    public enum BookType {FICTION, NO_FICTION, PROPHETIC_UTTERANCES}

    private BookType bookType = BookType.FICTION;

    public BookType getBookType() {
        return (bookType);
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
