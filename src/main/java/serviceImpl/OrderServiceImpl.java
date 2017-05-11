package serviceImpl;

import mapper.DishesMapper;
import mapper.OrdersMapper;
import mapper.ProductorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.Car;
import po.Custom.OrderCustom;
import po.Dish;
import po.Order;
import po.Productor;
import service.OrderService;
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
}
