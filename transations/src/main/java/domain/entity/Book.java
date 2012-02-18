package domain.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Book {


    private String isbn;
    private String bookName;
    private int price;

    public Book(String isbn, String bookName) {
        this.isbn = isbn;
        this.bookName = bookName;
    }
    public Book(String isbn, String bookName, int price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
    }

    public String getId() {
        return isbn;
    }

    public void setId(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, new String[]{"id"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"id"});
    }

    @Override
    public String toString() {
        return "BookInfo[ISBN:"+isbn+", BookName:" + bookName+ ", Price:" + price+"]";
    }
}
