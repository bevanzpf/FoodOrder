package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Admin;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/3.
 */
@Controller
public class AdminLoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/man/login")
    public String get(){
        return "/admin/login";
    }

    @RequestMapping("/man/login.action")
    public String create(Model model, String email,
                         HttpSession session, String pwd) throws Exception {
        Admin admin = adminService.authenticate(email, pwd);
        if(admin == null){
            session.setAttribute("loginMessage","用户密码或账户错误");
            return "redirect:/man/login";
        }else{
            session.setAttribute("admin", admin);
            session.setAttribute("user", admin);
        }
        return "redirect:/admin";
    }

    @RequestMapping("/man/logout")
    public String delete(HttpSession session,
                         HttpServletResponse res){

        session.removeAttribute("user");
        session.removeAttribute("admin");
        return "redirect:/man/login";

    }

}
