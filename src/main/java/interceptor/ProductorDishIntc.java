package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import po.Dish;
import po.Productor;
import service.DishService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/5.
 */
public class ProductorDishIntc implements HandlerInterceptor {
    @Autowired
    private DishService dishService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        int dishId = Integer.parseInt(httpServletRequest.getParameter("id"));
        Productor  productor = (Productor) session.getAttribute("productor");
        if(productor == null){
            httpServletResponse.sendRedirect("/productor/login");
        }else{
            if(dishId!=0){
                Dish dish = dishService.findById(dishId);
                if(dish.getProductorId()!=productor.getId())//商户操作是否为自己的
                    httpServletResponse.sendRedirect("/");
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
