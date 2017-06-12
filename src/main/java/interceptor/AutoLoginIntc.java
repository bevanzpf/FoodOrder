package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import po.User;
import service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;

/**
 * Created by p on 2017/6/12.
 */
public class AutoLoginIntc implements HandlerInterceptor {

    @Autowired
    private UserService userService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String rememberToken = null;
        int id = 0;
        User user = null;
        HttpSession session = httpServletRequest.getSession();
        user = (User) session.getAttribute("user");
        if(user != null) {
            return true;
        }else{
            Cookie[] cookies = httpServletRequest.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("com.fo.rt"))
                        rememberToken = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    if(cookie.getName().equals("com.fo.id"))
                        id = Integer.valueOf(URLDecoder.decode(cookie.getValue(), "UTF-8"));
                }
            }
            if(rememberToken != null && id !=0){
                user = userService.authenticateRememberToken(id, rememberToken);
                if(user != null){
                    session.setAttribute("user", user);
                }

            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
