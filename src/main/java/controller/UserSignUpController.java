package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Custom.UserCustom;
import service.UserService;

/**
 * Created by p on 2017/5/5.
 */
@Controller
public class UserSignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping("/signUp")
    public String get(){
        return "/user/signUpForm";
    }

    @RequestMapping("/singUp.action")
    public String create(String email, String pwd) throws Exception {
        userService.addOne(email,pwd);
        return "/user/signUpSuccess";
    }

    @RequestMapping("/active")
    public String active(String email, String token) throws Exception {
        UserCustom user = userService.authenticateActive(email, token);
        if(user!= null){
            System.out.println(user);
            return "redirect:/login";
        }
        return "/user/activeError";
    }
}
