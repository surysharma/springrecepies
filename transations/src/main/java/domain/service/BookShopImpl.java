package domain.service;

import domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static junit.framework.Assert.assertNotNull;

@Service(value = "bookShop")
public class BookShopImpl extends JdbcDaoSupport implements BookShop {

    @Autowired
    public BookShopImpl(JdbcTemplate jdbcTemplate) {
        super();
        setJdbcTemplate(jdbcTemplate);
    }

    @Override
    public void purchase(Book... books) {
        List<Book> bookList = getJdbcTemplate().query("select * from book", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                String isbn = rs.getString("isbn");
                String bookName = rs.getString("bookname");
                int price = rs.getInt("price");
                return new Book(isbn, bookName, price);
            }
        });

        assertNotNull(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}
