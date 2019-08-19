import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.LanguageDao;
import com.bortni.model.dao.implementation.DaoFactoryImpl;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.Language;
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
        List<Book> books1 = bookService.getAllBooks();
        System.out.println(books1);
    }

    @Test
    public void getById(){
        int id = 36;
        System.out.println(bookDao.getById(id));
    }

    @Test
    public void getBooksSearchByParam(){
        String param = "fantasy";
        System.out.println(bookDao.searchByParam(param));
    }

    @Test
    public void getLanguage(){
        String name = "en";
        LanguageDao languageDao = daoFactory.createLanguageDao();
        Language language = languageDao.getLanguageByLanguageName(name);
        System.out.println(bookDao.getAllAvailableByLanguage(language));
    }
}
