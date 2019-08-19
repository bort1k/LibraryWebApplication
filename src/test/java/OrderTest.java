import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.OrderDao;
import com.bortni.model.entities.Order;
import com.bortni.service.OrderService;
import org.junit.Test;

import java.util.List;

public class OrderTest {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private OrderDao orderDao = daoFactory.createOrderDao();
    private OrderService orderService = new OrderService();

    @Test
    public void getAll(){
        List<Order> orders = orderService.getAllOrders();
        System.out.println(orders);
    }
}
