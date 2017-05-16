package mapper;

import po.Order;

import java.util.List;

/**
 * Created by p on 2017/5/10.
 */
public interface OrdersMapper {

    void addOne(Order order)throws Exception;

    void addBatch(List<Order> orders)throws Exception;

    List<Order> findAllUserOrder(Integer userId)throws Exception;

    void setCancel(Integer orderid)throws Exception;

    void setReject(Integer orderId) throws Exception;

    void setFinished(Integer orderId) throws Exception;

    List<Order> findAllProductorOrder(Integer id)throws Exception;

    Order findById(Integer id)throws Exception;
}
