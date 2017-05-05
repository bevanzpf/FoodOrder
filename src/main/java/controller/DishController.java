package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import po.Dish;
import po.Productor;
import service.DishService;
import service.ProductorService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by p on 2017/5/5.
 */
@Controller
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private ProductorService productorService;

    @RequestMapping("/productor/m/dishes/add")
    public String get(Integer id, Model model) throws Exception {
        Productor productor = productorService.findById(id);
        model.addAttribute("productor", productor);
        return "/dish/add";
    }

    @RequestMapping("/productor/m/dishes/add.action")
    public String create(Integer id, Dish dish, MultipartFile photo_file) throws Exception {
        dish.setProductorId(id);
        dishService.addOne(dish, photo_file);
        return "redirect:/productor/m/dishes/add?id="+id;
    }

    @RequestMapping("/productor/m/dishes/index")
    public String index(Integer id, Model model) throws Exception {
        List<Dish> dishes = dishService.findProductorsDishes(id);
        model.addAttribute("dishes",dishes);
        return "/dish/index";
    }

    @RequestMapping("/productor/dishes/edit")
    public String edit(Integer id, Model model)throws Exception{
        Dish dish = dishService.findById(id);
        model.addAttribute("dish", dish);
        return "/dish/edit";
    }

    @RequestMapping("/productor/dishes/edit.action")
    public String update(Integer id, Dish dish, MultipartFile photo_file) throws Exception {
        dishService.update(id, dish, photo_file);
        return "redirect:/productor/dishes/edit?id="+id;
    }

    @RequestMapping("/productor/dishes/delete")
    public String delete(Integer id, HttpSession session) throws Exception {
        dishService.deleteOne(id);
        Productor productor = (Productor) session.getAttribute("productor");
        return "redirect:/productor/m/dishes/index?id="+productor.getId();
    }

}
