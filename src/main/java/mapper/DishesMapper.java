package mapper;

import po.Dish;

import java.net.InetAddress;
import java.util.List;

/**
 * Created by p on 2017/5/5.
 */
public interface DishesMapper {

    void addOne(Dish dish)throws Exception;

    List<Dish> findProductorDish(Integer id)throws Exception;

    void update(Dish dish)throws Exception;

    Dish findById(Integer id)throws Exception;

    void deleteOne(Integer id)throws Exception;

}
