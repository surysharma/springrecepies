import domain.service.BookShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static junit.framework.Assert.assertNotNull;

public class transactionsExample {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("transations/applicationContext.xml");
        assertNotNull(context);

        BookShop bookShop = (BookShop) context.getBean("bookShop");
        assertNotNull(bookShop);

        bookShop.purchase("user1", "1");
    }
}
