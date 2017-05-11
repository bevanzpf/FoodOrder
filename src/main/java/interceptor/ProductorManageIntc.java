package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import po.Productor;
import service.ProductorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/5.
 */
public class ProductorManageIntc implements HandlerInterceptor {
    @Autowired
    private ProductorService productorService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        int id = 0;
        if(httpServletRequest.getParameter("id")!=null){
            id = Integer.parseInt(httpServletRequest.getParameter("id"));
        }
        Productor productor = (Productor) session.getAttribute("productor");
        if(productor == null){
            //httpServletResponse.sendRedirect("/productor/login");
            httpServletRequest.getRequestDispatcher("/productor/login").forward(httpServletRequest,httpServletResponse);
        }else if(id!=0){
            if(productor.getId() != id)
            httpServletResponse.sendRedirect("/");
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
