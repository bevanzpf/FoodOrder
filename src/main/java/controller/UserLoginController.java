package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Custom.UserCustom;
import service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/5.
 */
@Controller
public class UserLoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String get(){
        return "user/login";
    }

    @RequestMapping("/login.action")
    public String create(String email, String pwd,
                         HttpSession session) throws Exception {
        UserCustom user = userService.authenticateLogin(email, pwd);
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/u/show";
        }else{
            session.setAttribute("message","密码出错或账户未激活");
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String delete(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
