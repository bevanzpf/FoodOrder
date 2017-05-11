package controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import po.Car;
import po.Custom.OrderCustom;
import po.Order;
import po.User;
import service.OrderService;
import service.UserService;
import vo.OrderVo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by p on 2017/5/10.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/edit")
    public String edit(@CookieValue(value = "carCookie",required = false)String carCookieStr,
                       Model model,
                       Car car
                       ) throws Exception {
        if(carCookieStr != null ){
            JSONObject jsonCar = JSONObject.fromObject(carCookieStr);
            car = (Car) JSONObject.toBean(jsonCar, Car.class);
            if(car.getCarRecord() != null) {
                OrderVo orderVo = orderService.unloadCar2order(car);
                model.addAttribute("orderVo", orderVo);
            }
        }
        return "/order/edit";

    }

    @RequestMapping("/u/order/edit.action")
    public String update(@RequestParam(value = "dishId")Integer[] dishIds,
                         @RequestParam(value = "productorId")Integer[] productorIds,
                         @RequestParam(value = "acount") Integer[] acounts,
                         String address,
                         HttpSession session,
                         HttpServletResponse response,
                         Car car,
                         @CookieValue(value = "carCookie",required = false)String carCookieStr
                         ) throws Exception {
        List<Order> orders = new ArrayList<Order>();
        User user = (User) session.getAttribute("user");
        int len = dishIds.length;
        for(int i=0;i<len;i++){
            if(acounts[i] != 0){
                Order order = new Order();
                order.setUserId(user.getId());
                order.setAddress(address);
                order.setDishId(dishIds[i]);
                order.setProductorId(productorIds[i]);
                order.setAcount(acounts[i]);
                order.setState("待接单");
                orders.add(order);
            }
        }
        orderService.addBatch(orders);
        JSONObject jsonCar = JSONObject.fromObject(carCookieStr);
        car = (Car) JSONObject.toBean(jsonCar, Car.class);
        car.setCarRecord(null);
        String carCookie = JSONObject.fromObject(car).toString();//Cart转换成对象Json
        Cookie cookie = new Cookie("carCookie",carCookie);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/order/edit";
    }

    @RequestMapping("/u/order/show")
    public String show(HttpSession session,
                       Model model
                      ) throws Exception {
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        List<OrderCustom> ordercustoms = orderService.findAllUserOrder(id);
        model.addAttribute("orderCustoms",ordercustoms);
        return "/user/order/show";
    }

    @RequestMapping("/u/order/cancel")
    public String reback(Integer id
                        )throws Exception{
        orderService.cancelOne(id);
        return "redirect:/u/order/show";
    }
}
