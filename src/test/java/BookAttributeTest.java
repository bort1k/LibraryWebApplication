import com.bortni.model.dao.BookAttributeDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.implementation.DaoFactoryImpl;
import com.bortni.model.entities.BookAttribute;
import org.junit.Test;

public class BookAttributeTest {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private BookAttributeDao bookAttributeDao = daoFactory.createBookAttributeDao();

    @Test
    public void getAllByBookId(){
        int id = 2;
        System.out.println(bookAttributeDao.getAttributesByBookId(id));
    }
}
