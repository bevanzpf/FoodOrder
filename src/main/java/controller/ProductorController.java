package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import po.Car;
import po.Dish;
import po.Productor;
import service.DishService;
import service.ProductorService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by p on 2017/5/3.
 */
@Controller
public class ProductorController {

    @Autowired
    private ProductorService productorService;
    @Autowired
    private DishService dishService;

    @RequestMapping("/admin/productors/add")
    public String get(){
        return "/productor/form_for_insert";
    }

    @RequestMapping("/admin/productors/add.action")
    public String create(Productor productor) throws Exception {
        System.out.println(productor);
        productorService.addProductor(productor);
        return "success";
    }

    @RequestMapping("/admin/productors/index")
    public String show(Model model) throws Exception {
        List<Productor> productors = productorService.showAllPagely();
        model.addAttribute("productors", productors);
        return "/productor/index";
    }

    @RequestMapping("/admin/productors/delete")
    public String delete(Integer id)throws Exception{
        productorService.deleteOne(id);
        return "redirect:/admin/productors/index";
    }

    @RequestMapping("/productor") //公共页面
    public String show(Integer id, Model model,
                       Car car,
                       @CookieValue(value = "carCookie", required = false)String carCookieStr) throws Exception {
        if(carCookieStr != null){
            JSONObject jsonCar = JSONObject.fromObject(carCookieStr);
            car = (Car) JSONObject.toBean(jsonCar, Car.class);
            Integer itemTotal = car.getSum();
            model.addAttribute("itemTotal", itemTotal);
        }
        Productor productor = productorService.findById(id);
        List<Dish> dishes = dishService.findProductorsDishes(id);
        model.addAttribute("productor",productor);
        model.addAttribute("dishes", dishes);
        return "/productor/show";
    }

    @RequestMapping("/productor/getpage")
    public String getDishPage(Integer productorId,
                                                Integer maxId, Model model) throws Exception {
        List<Dish> dishes = dishService.findProductorsDishesByPage(productorId, maxId);
        if(dishes.isEmpty()){
            return "redirect:/productor/getpageJson";
        }
        model.addAttribute("dishes", dishes);

        return "/productor/dishPage";
    }

    @RequestMapping("/productor/getpageJson")
    public @ResponseBody String returnEmptyJson(){
        return "0";
    }

    @RequestMapping("/productor/dish/search")
    public String searchDish(Integer productorId, String searchKey,Model model) throws Exception {
        String decodeKey = URLDecoder.decode(searchKey,"UTF-8");
        System.out.println(decodeKey);
        List<Dish> dishes = dishService.searchDish(productorId, decodeKey);
        model.addAttribute("dishes", dishes);
        return "/productor/dishPage";
    }

    @RequestMapping("/productor/m")//管理界面
    public String mshow(Integer id, Model model) throws Exception {
        Productor productor = productorService.findById(id);
        model.addAttribute("productor", productor);
        return "/productor/mshow";
    }

    @RequestMapping("/productor/m/edit")
    public String edit(Model model,Integer id) throws Exception {
        Productor productor = productorService.findById(id);
        model.addAttribute("productor", productor);
        return "/productor/edit";
    }

    @RequestMapping("/productor/m/edit.action")
    public String update(Productor productor, Integer id,
                         HttpSession session, MultipartFile photo_file) throws Exception {
        //从session原来的图片url
        Productor p = (Productor) session.getAttribute("productor");
        productor.setPhoto(p.getPhoto());
        Productor newproductor = productorService.updateBaseInfo(productor, photo_file);
        session.setAttribute("productor", newproductor); //跟新session
        return "redirect:/productor/m/edit?id="+id;
    }
}
