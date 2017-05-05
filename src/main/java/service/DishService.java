package service;

import org.springframework.web.multipart.MultipartFile;
import po.Dish;

import java.util.List;

/**
 * Created by p on 2017/5/5.
 */
public interface DishService {

     void addOne(Dish dish, MultipartFile photo_file)throws Exception;

     List<Dish> findProductorsDishes(Integer id)throws Exception;

     void update(Integer id , Dish dish, MultipartFile photo_file)throws Exception;

     Dish findById(Integer id)throws Exception;

     void deleteOne(Integer id)throws Exception;

}
