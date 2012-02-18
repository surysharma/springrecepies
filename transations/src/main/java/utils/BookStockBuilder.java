package utils;

import com.google.common.collect.Lists;
import domain.entity.Book;
import domain.entity.BookStock;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sureshsharma
 * Date: 15/01/2012
 * Time: 11:39
 * To change this template use File | Settings | File Templates.
 */
public class BookStockBuilder {
    private List<Book> books;
    private BookStock stock;

    public static BookStockBuilder bookStock() {
        return new BookStockBuilder();  //To change body of created methods use File | Settings | File Templates.
    }

    public BookStockBuilder withBooks(Book ...books ) {
        List<Book> bookList = Lists.asList(books[0], books);
        this.books = bookList;
        return this;
    }

    public BookStock getStock() {
        BookStock bookStock = new BookStock();
        bookStock.setBooks(books);
        return bookStock;
    }
}
