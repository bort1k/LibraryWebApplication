import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.implementation.DaoFactoryImpl;
import com.bortni.model.entities.Book;
import org.junit.Test;

import java.util.List;

public class BookTest {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private BookDao bookDao = daoFactory.createBookDao();

    @Test
    public void getAllAvail(){
        System.out.println(bookDao.getAllAvailable());
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
