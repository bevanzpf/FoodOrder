package serviceImpl;

import mapper.DishesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import po.Dish;
import service.DishService;

import java.util.List;

/**
 * Created by p on 2017/5/5.
 */
public class DishServiceImpl implements DishService {

    @Autowired
    private DishesMapper dishesMapper;

    public void addOne(Dish dish, MultipartFile photo_file) throws Exception {
        if(!photo_file.isEmpty()){
            String url = PicUploadHeaper.upload(photo_file);
            dish.setPhotoUrl(url);
        }
        dishesMapper.addOne(dish);
    }

    public List<Dish> findProductorsDishes(Integer id) throws Exception {
        List<Dish> dishes = dishesMapper.findProductorDish(id);
        return dishes;
    }

    public void update(Integer id, Dish dish, MultipartFile photo_file) throws Exception {
        if(!photo_file.isEmpty()){
            String newUrl = PicUploadHeaper.upload(photo_file);
            dish.setPhotoUrl(newUrl);
        }
        dish.setId(id);
        dishesMapper.update(dish);
    }

    public Dish findById(Integer id )throws Exception{
        Dish dish = dishesMapper.findById(id);
        return dish;
    }

    public void deleteOne(Integer id) throws Exception {
        dishesMapper.deleteOne(id);
    }
}
