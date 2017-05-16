package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Custom.OrderCustom;
import po.Productor;
import service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by p on 2017/5/16.
 */
@Controller
public class ProductorOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/productor/order/index")
    public String get(Model model,
                      HttpSession session) throws Exception {
        Productor productor = (Productor) session.getAttribute("productor");
        int  proId = productor.getId();
        List<OrderCustom> orderCustoms = orderService.findAllProductOrder(proId);
        model.addAttribute("orderCustoms", orderCustoms);

        return "/productor/order/index";
    }

    @RequestMapping("/productor/order/reject")
    public String reject(Integer id) throws Exception {
        orderService.rejectOne(id);

        return "redirect:/productor/order/index";
    }

    @RequestMapping("/productor/order/finish")
    public String finish(Integer id)throws Exception{
        orderService.finishedOne(id);

        return "redirect:/productor/order/index";
    }

}
