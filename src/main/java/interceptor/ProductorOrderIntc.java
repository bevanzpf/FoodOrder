package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import po.Order;
import po.Productor;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/16.
 */
public class ProductorOrderIntc implements HandlerInterceptor {
    @Autowired
    private OrderService orderService;
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Productor productor = (Productor) session.getAttribute("productor");
        String id = httpServletRequest.getParameter("id");
        if(productor == null) {
            httpServletRequest.getRequestDispatcher("/productor/login").forward(httpServletRequest, httpServletResponse);
            System.out.println(productor);
            return true;
        }
        if (id != null) {
            int orderId = Integer.valueOf(id);
            Order order = orderService.findById(orderId);
            if(order.getProductorId() != productor.getId()){
                httpServletRequest.getRequestDispatcher("/").forward(httpServletRequest,httpServletResponse);
                return true;
            }

        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
