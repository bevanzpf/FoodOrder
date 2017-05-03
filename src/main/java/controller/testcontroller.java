package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by p on 2017/5/2.
 */
@Controller

public class testcontroller {

    @RequestMapping("/hello")
    public static String hello(){
        return "hello";
    }
}
