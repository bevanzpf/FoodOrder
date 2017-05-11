package controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import po.Car;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by p on 2017/5/9.
 */
@Controller
public class CarController {

    @RequestMapping("/addDish2Car.action")
    public void addDish(@RequestParam(value = "id")String dishId,
            @CookieValue(required = false, value = "carCookie") String carCookieStr,
            HttpServletResponse response,
            Car car){

        if(carCookieStr ==null){
            HashMap<String, String> carRecord = new HashMap<String, String>();
            carRecord.put(dishId,"1");
            car.setCarRecord(carRecord);
        }else {
            JSONObject jsonCar = JSONObject.fromObject(carCookieStr);
            car = (Car) JSONObject.toBean(jsonCar, Car.class);
            HashMap<String, String> carRecord = car.getCarRecord();
                if (carRecord.containsKey(dishId)) {
                    int originalValue = Integer.valueOf(carRecord.get(dishId));
                    carRecord.put(dishId, String.valueOf(originalValue + 1));
                } else {
                    carRecord.put(dishId, "1");
                }
            car.setCarRecord(carRecord);
        }
        String carCookie = JSONObject.fromObject(car).toString();//Cart转换成对象Json
        Cookie cookie = new Cookie("carCookie",carCookie);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*7);//保留7天
        response.addCookie(cookie);

    }
    @RequestMapping("/car/item/plus")
    public String plusUpdate(String dishId,
                             @CookieValue(value = "carCookie", required = true) String carCookieStr,
                             HttpServletResponse response,
                             Car car
                             )throws Exception{
        if(carCookieStr != null){
            JSONObject jsonCar = JSONObject.fromObject(carCookieStr);
            car = (Car) JSONObject.toBean(jsonCar, Car.class);
            HashMap<String,String> carRecord = car.getCarRecord();
            if(carRecord.containsKey(dishId)){
                Integer originalVal = Integer.valueOf(carRecord.get(dishId));
                carRecord.put(dishId, String.valueOf(originalVal+1));
            }
            String carCookie = JSONObject.fromObject(car).toString();//Cart转换成对象Json
            Cookie cookie = new Cookie("carCookie",carCookie);
            cookie.setMaxAge(60*60*24*7);//保留7天
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        return "redirect:/order/edit";

    }

    @RequestMapping("/car/item/minus")
    public String minusUpdate(String dishId,
                              @CookieValue(value = "carCookie", required = true) String carCookieStr,
                              HttpServletResponse response,
                              Car car
                              )throws Exception{
        if(carCookieStr != null){
            JSONObject jsonCar = JSONObject.fromObject(carCookieStr);
            car = (Car) JSONObject.toBean(jsonCar, Car.class);
            HashMap<String,String> carRecord = car.getCarRecord();
            if(carRecord.containsKey(dishId)){
                Integer originalVal = Integer.valueOf(carRecord.get(dishId));
                Integer newVal = originalVal -1;
                if(newVal <= 0){
                    carRecord.remove(dishId);
                }else {
                    carRecord.put(dishId, String.valueOf(newVal));
                }
            }
            String carCookie = JSONObject.fromObject(car).toString();//Cart转换成对象Json
            Cookie cookie = new Cookie("carCookie",carCookie);
            cookie.setMaxAge(60*60*24*7);//保留7天
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return "redirect:/order/edit";

    }
//
//    @RequestMapping("/car/item/delete")
//    public String deleteUpdate(Integer dishId){
//
//    }

}
