package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import po.User;
import service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/6.
 */
@Controller
public class UserChangePwdController {

    @Autowired
    private UserService userService;

    @RequestMapping("/u/pwd/edit")
    public String edit(){
        return "/user/pwd/edit";
    }
    @RequestMapping("/u/pwd/edit.action")
    public String update(String oldPwd, String newPwd, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        boolean success = userService.changPwd(user.getEmail(), oldPwd, newPwd);
        if(success){
            session.setAttribute("message","密码重置成功");
            return "redirect:/u/show";
        }
        session.setAttribute("message","验证失败");
        return "redirect:/u/pwd/edit";
    }
}
