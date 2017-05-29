package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Productor;
import service.Service;

import java.util.List;

/**
 * Created by p on 2017/5/29.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;
    @RequestMapping("/")
    public String index(Model model) throws Exception {
        List<Productor> productors = service.findAllProductors();
        model.addAttribute("productors", productors);
        return "index";
    }

    @RequestMapping("/links")
    public String testLink()throws Exception{
        return "links";
    }
}
