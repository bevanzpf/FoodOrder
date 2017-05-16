package service;

import po.Car;
import po.Custom.OrderCustom;
import po.Order;
import vo.OrderVo;

import java.util.List;

/**
 * Created by p on 2017/5/10.
 */
public interface OrderService {

    void addBatch(List<Order> orders)throws Exception;

    OrderVo unloadCar2order(Car car)throws Exception;

    List<OrderCustom> findAllUserOrder(Integer userId)throws Exception;

    void cancelOne(Integer orderId)throws Exception;

    void finishedOne(Integer orderId) throws Exception;

    void rejectOne(Integer orderId)throws Exception;

    List<OrderCustom> findAllProductOrder(Integer ProductorId)throws Exception;

    Order findById(Integer id)throws Exception;
}
