package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Productor;
import service.ProductorService;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Service;

/**
 * Created by p on 2017/5/3.
 */
@Controller
@RequestMapping("/productor")
public class ProductorLoginController {

    @Autowired
    private ProductorService productorService;
    @RequestMapping("/login")
    public String get(){
        return "/productor/login";
    }

    @RequestMapping("/login.action")
    public String create(String email, String pwd,
                         HttpSession session, Model model) throws Exception {
        Productor productor = productorService.authenticate(email, pwd);
        if(productor == null){
            model.addAttribute("loginMessage", "密码或账户错误");
            return "/productor/login";
        }else{
            session.setAttribute("productor", productor);
        }
        return "redirect:/productor?id="+productor.getId();
    }

    @RequestMapping("logout")
    public String delete(HttpSession session){
        session.removeAttribute("productor");
        return "redirect:/productor/login";
    }
}
