package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Productor;
import service.ProductorService;

import java.util.List;

/**
 * Created by p on 2017/5/3.
 */
@Controller
public class ProductorController {

    @Autowired
    private ProductorService productorService;

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
        List<Productor> productors = productorService.showAll();
        model.addAttribute("productors", productors);
        return "/productor/index";
    }

    @RequestMapping("/admin/productors/delete")
    public String delete(Integer id)throws Exception{
        productorService.deleteOne(id);
        return "redirect:/admin/productors/index";
    }

    @RequestMapping("/productor")
    public String show(){
        return "/productor/show";
    }
}
