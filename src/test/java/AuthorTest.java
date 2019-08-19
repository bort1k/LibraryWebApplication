import com.bortni.model.dao.AuthorDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.implementation.DaoFactoryImpl;
import org.junit.Test;

public class AuthorTest {
    private DaoFactory daoFactory = new DaoFactoryImpl();
    private AuthorDao authorDao = daoFactory.createAuthorDao();

    @Test
    public void getAll(){
        authorDao.getAll();
    }
}
