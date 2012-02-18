package domain.service;

import domain.entity.Account;
import domain.entity.Book;
import domain.entity.BookStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service(value = "bookShop")

public class BookShopImpl extends JdbcDaoSupport implements BookShop {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookShopImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        setJdbcTemplate(jdbcTemplate);
    }

    @Override
    @Transactional
    public void purchase(String userName, String isbn) {
        Account account = getAccount(userName);
        Book book = getBook(isbn);
        updateStock(isbn);
        deductAmountFromAccount(account, book.getPrice());
        Account updatedAccount = getAccount(userName);
        System.out.println(updatedAccount);
    }

    private void deductAmountFromAccount(Account account, int price) {
        int reducedBalance = account.getBalence() - price;
        if (reducedBalance < 0) throw new RuntimeException("Balance dropped to less than 0, cannot proceed!!!");
        
        jdbcTemplate.update("update account set balance=? where username=?", new Object[]{reducedBalance, account.getUserName()});
    }

    private Account getAccount(String userName) {
        return jdbcTemplate.query("select * from account", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                String userName = rs.getString("username");
                int price = rs.getInt("balance");
                Account account = new Account(userName);
                account.setBalence(price);
                return account;
            }
        }).get(0);
    }

    private void updateStock(String isbn) {
        BookStock bookStock = getBookStock(isbn);
        int reducedStock = bookStock.getStock() - 1;
        jdbcTemplate.update("update book_stock set stock=? where isbn=?", new Object[]{reducedStock, isbn});
    }

    private BookStock getBookStock(String isbn) {
        return jdbcTemplate.query("select * from book_stock where isbn=?", new Object[]{isbn}, new RowMapper<BookStock>() {
            @Override
            public BookStock mapRow(ResultSet rs, int rowNum) throws SQLException {
                String isbn = rs.getString("isbn");
                int stock = rs.getInt("stock");
                return new BookStock(isbn, stock);
            }
        }).get(0);
    }

    private Book getBook(String isbn) {

        return jdbcTemplate.query("select * from book where isbn = ?", new Object[]{isbn}, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                String isbn = rs.getString("isbn");
                String bookName = rs.getString("bookname");
                int price = rs.getInt("price");
                return new Book(isbn, bookName, price);
            }
        }).get(0);
    }
}
