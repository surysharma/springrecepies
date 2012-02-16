package utils;

import domain.Book;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 14/01/2012
 * Time: 12:20
 * To change this template use File | Settings | File Templates.
 */
public class EntityBuilder {
    private static String bookName;
    private double price;
    private String isbn;

    public static EntityBuilder book() {
        return new EntityBuilder();  //To change body of created methods use File | Settings | File Templates.
    }

    public EntityBuilder withName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public EntityBuilder withPrice(double price) {
        this.price = price;
        return this;  //To change body of created methods use File | Settings | File Templates.
    }

    public Book purchase() {
        Book book = new Book();
        book.setBookName(bookName);
        book.setPrice(BigDecimal.valueOf(price));
        book.setId(Long.valueOf(isbn));
        return book;  //To change body of created methods use File | Settings | File Templates.
    }

    public EntityBuilder withISBN(String isbn) {
        this.isbn = isbn;
        return this;  //To change body of created methods use File | Settings | File Templates.
    }

    public static EntityBuilder bookStock() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
