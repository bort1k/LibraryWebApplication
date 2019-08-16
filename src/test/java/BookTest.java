import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.implementation.DaoFactoryImpl;
import com.bortni.model.entities.Book;
import com.bortni.service.BookService;
import com.bortni.service.OrderService;
import org.junit.Test;

import java.util.List;

public class BookTest {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private BookDao bookDao = daoFactory.createBookDao();
    private BookService bookService = new BookService();

    @Test
    public void getAllAvail(){
        List<Book> books9 = bookService.getAllBooks();
        List<Book> books8 = bookService.getAllBooks();
        List<Book> books7 = bookService.getAllBooks();
        List<Book> books6 = bookService.getAllBooks();
        List<Book> books5 = bookService.getAllBooks();
        List<Book> books4 = bookService.getAllBooks();
        List<Book> books3 = bookService.getAllBooks();
        List<Book> books2 = bookService.getAllBooks();
        List<Book> books1 = bookService.getAllBooks();
        List<Book> books10 = bookService.getAllBooks();
        List<Book> books11 = bookService.getAllBooks();
        List<Book> books12 = bookService.getAllBooks();
        List<Book> books13 = bookService.getAllBooks();
        List<Book> books14 = bookService.getAllBooks();
        List<Book> books15 = bookService.getAllBooks();
        System.out.println(books1);
        System.out.println(books2);
        System.out.println(books3);
        System.out.println(books4);
        System.out.println(books5);
        System.out.println(books6);
        System.out.println(books7);
        System.out.println(books8);
        System.out.println(books9);
        System.out.println(books10);
        System.out.println(books11);
        System.out.println(books12);
        System.out.println(books13);
        System.out.println(books14);
        System.out.println(books15);
    }

    @Test
    public void getById(){
        int id = 2;
        System.out.println(bookDao.getById(id));
    }

    @Test
    public void getBooksSearchByParam(){
        String param = "fantasy";
        System.out.println(bookDao.searchByParam(param));
    }
}
