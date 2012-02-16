import domain.Book;
import domain.BookStock;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import utils.BookStockBuilder;
import utils.EntityBuilder;

import java.io.File;

public class transactionsExample {

    public static void main(String[] args) {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.configure(new File("/projects/springrecepies/transations/h1ibernate.cfg.xml"));
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(BookStock.class);
        configuration.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Book book1 = EntityBuilder
                .book()
                .withISBN("21234")
                .withName("Anario")
                .withPrice(25.90)
                .purchase();


        Book book2 = EntityBuilder
                .book()
                .withISBN("21234")
                .withName("Sumaraio")
                .withPrice(240.0)
                .purchase();

        BookStock bookStock = BookStockBuilder.bookStock().withBooks(book1, book2).getStock();

//        session.save(book1);
//        session.save(book2);
        session.save(bookStock);

        session.getTransaction().commit();
    }
}
