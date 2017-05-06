package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by p on 2017/5/6.
 */
@Controller
public class UserPwdResetController {
    @Autowired
    private UserService userService;

    @RequestMapping("/pwd/forget")
    public String get(){
        return "/user/pwd/emailForForget";
    }

    @RequestMapping("/pwd/forget.action")
    public String create(String email, HttpSession session) throws Exception {
        boolean success = userService.solvePwdForgetRequest(email);
        if(success)
            return "/user/pwd/SuccessSendForForget";
        session.setAttribute("message", "账户不存在");
        return "redirect:/pwd/forget";
    }

    @RequestMapping("/pwd/forgetLink.action")
    public String solveForgetLink(String email, String token) throws Exception {
        boolean isValidated = userService.solvePwdForgetLink(email, token);
        if(isValidated){
            return "redirect:/pwd/reset?email="+email+"&token="+token;
        }else{
            return "/user/pwd/linkfailure";
        }
    }

    @RequestMapping("/pwd/reset")
    public String get(String email, String token, Model model){
        model.addAttribute("email", email);
        model.addAttribute("token", token);
        return "/user/pwd/resetForm";
    }

    @RequestMapping("/pwd/reset.action")
    public String update(String token, String email, HttpSession session,
                         String newPwd, String newPwdConfirm) throws Exception {
        boolean success = userService.solveResetForm(email, token,newPwd);
        if(success){
            session.setAttribute("message", "重置成功");
            return "redirect:/login";
        }else{
            session.setAttribute("message", "重置失败");
            return "redirect:/pwd/reset";
        }
    }
}
