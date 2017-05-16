package serviceImpl;

import mapper.DishesMapper;
import mapper.OrdersMapper;
import mapper.ProductorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.*;
import po.Custom.OrderCustom;
import service.OrderService;
import service.UserService;
import vo.OrderVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by p on 2017/5/10.
 */
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private DishesMapper dishesMapper;
    @Autowired
    private ProductorMapper productorMapper;

    @Autowired
    private UserService userService;
    public void addBatch(List<Order> orders) throws Exception {

        ordersMapper.addBatch(orders);

    }

    public OrderVo unloadCar2order(Car car) throws Exception {
        OrderVo orderVo = new OrderVo();
        List<OrderCustom> orderCustoms = new ArrayList<OrderCustom>();
        HashMap<String,String> carRecord = car.getCarRecord();
        double money = 0;
        if(carRecord !=null) {
            for (Map.Entry<String, String> entry : carRecord.entrySet()) {
                if(!entry.getKey().equals("0")&& !entry.getValue().equals("0")) {
                    Dish dish = dishesMapper.findById(Integer.valueOf(entry.getKey()));
                    Productor productor = productorMapper.findById(dish.getProductorId());
                    OrderCustom orderCustom = new OrderCustom();
                    orderCustom.setDish(dish);
                    orderCustom.setProductor(productor);
                    orderCustom.setAcount(Integer.valueOf(entry.getValue()));
                    orderCustoms.add(orderCustom);
                    //jijia
                    int acount = Integer.valueOf(entry.getValue());
                    double price = Integer.parseInt(dish.getPrice());
                    money += (acount * price);
                }
            }
        }
        orderVo.setMoney(money);
        orderVo.setOrderCustoms(orderCustoms);
        return orderVo;
    }

    public List<OrderCustom> findAllUserOrder(Integer userId) throws Exception {
        List<OrderCustom> orderCustoms = new ArrayList<OrderCustom>();
        List<Order> orders = ordersMapper.findAllUserOrder(userId);
        for(Order order:orders){
            OrderCustom orderCustom = new OrderCustom();
            orderCustom.setId(order.getId());
            orderCustom.setState(order.getState());
            //setDish
            Dish dish = dishesMapper.findById(order.getDishId());
            orderCustom.setDish(dish);
            // setProductor
            Productor productor = productorMapper.findById(order.getProductorId());
            orderCustom.setProductor(productor);
            orderCustoms.add(orderCustom);
        }
        return orderCustoms;
    }

    public void cancelOne(Integer orderId) throws Exception {
        ordersMapper.setCancel(orderId);
    }

    public void finishedOne(Integer orderId) throws Exception {
        ordersMapper.setFinished(orderId);
        Order order = ordersMapper.findById(orderId);
        System.out.println(order);
        Dish dish = dishesMapper.findById(order.getDishId());
        dishesMapper.updatesales(dish.getId());
    }

    public void rejectOne(Integer orderId) throws Exception {
        ordersMapper.setReject(orderId);
    }

    public List<OrderCustom> findAllProductOrder(Integer productorId) throws Exception {
        List<Order> orders = ordersMapper.findAllProductorOrder(productorId);
        List<OrderCustom> orderCustoms = new ArrayList<OrderCustom>();
        for(Order order: orders){
            OrderCustom orderCustom = new OrderCustom();
            orderCustom.setId(order.getId());
            orderCustom.setAddress(order.getAddress());
            orderCustom.setState(order.getState());
            User user = userService.findById(order.getUserId());
            orderCustom.setUser(user);
            Dish dish = dishesMapper.findById(order.getDishId());
            orderCustom.setDish(dish);
            orderCustoms.add(orderCustom);
        }
        return orderCustoms;
    }

    public Order findById(Integer id) throws Exception {
        Order order = ordersMapper.findById(id);
        return order;
    }


}
