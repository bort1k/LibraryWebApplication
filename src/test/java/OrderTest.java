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
        List<Order> orders1 = orderService.getAllOrders();
        List<Order> orders2 = orderService.getAllOrders();
        List<Order> orders3 = orderService.getAllOrders();
        List<Order> orders4 = orderService.getAllOrders();
        List<Order> orders5 = orderService.getAllOrders();
        List<Order> orders6 = orderService.getAllOrders();
        List<Order> orders7 = orderService.getAllOrders();
        List<Order> orders8 = orderService.getAllOrders();
        List<Order> orders9 = orderService.getAllOrders();
        List<Order> orders10 = orderService.getAllOrders();
        System.out.println(orders10);
        System.out.println(orders9);
        System.out.println(orders8);
        System.out.println(orders7);
        System.out.println(orders6);
        System.out.println(orders5);
        System.out.println(orders4);
        System.out.println(orders3);
        System.out.println(orders2);
        System.out.println(orders1);
        System.out.println(orders);

    }
}
