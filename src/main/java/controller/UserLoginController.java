package controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import po.Custom.UserCustom;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
                         HttpSession session,
                         String checked,
                         HttpServletResponse response) throws Exception {
        UserCustom user = userService.authenticateLogin(email, pwd);
        if(user != null){
            session.setAttribute("user", user);
            if(checked != null){
                String token = userService.rememberUser(user);
                int maxAge = 30*3600*24;
                addCookie("com.fo.id", String.valueOf(user.getId()),response,maxAge);
                addCookie("com.fo.rt",token,response,maxAge);
            }
            return "redirect:/u/show";
        }else{
            session.setAttribute("message","密码出错或账户未激活");
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String delete(HttpSession session, HttpServletResponse response,
                         HttpServletRequest request){
        session.removeAttribute("user");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("com.fo.id")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if(cookie.getName().equals("com.fo.rt")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);

                }
            }
        }

        return "redirect:/login";
    }

    private void addCookie(String id,String value, HttpServletResponse response,
                           int maxAge) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(id, URLEncoder.encode(value,"UTF-8"));
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        //return cookie;
    }

}
