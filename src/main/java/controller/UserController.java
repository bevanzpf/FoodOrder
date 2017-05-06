package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import po.Custom.UserCustom;
import po.User;
import service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/5.
 */
@Controller
public class UserController {

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

    @RequestMapping("/u/edit")
    public String edit(){
        return "/user/edit";
    }

    @RequestMapping("/u/edit.action")
    public String update(User user, MultipartFile photo_file,
                         HttpSession session) throws Exception {
        System.out.println(user);
        User oldUser = (User) session.getAttribute("user");
        int id = oldUser.getId();
        user.setId(id);
        User newUser = userService.updateBasedInfo(user, photo_file);
        session.setAttribute("user", newUser);
        return "redirect:/u/edit";
    }

    @RequestMapping("/u/show")
    public String show(){
        return "/user/show";
    }
}
