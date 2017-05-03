package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by p on 2017/5/3.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin") //管理员主页
    public String show()throws Exception{
        return "/admin/show";
    }
}
