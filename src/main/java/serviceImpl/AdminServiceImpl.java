package serviceImpl;

import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.Admin;
import service.AdminService;

/**
 * Created by p on 2017/5/3.
 */
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    public Admin authenticate(String email, String pwd) throws Exception {

        Admin admin = adminMapper.findAdminByEmail(email);
        if(admin !=null){
            String pwdtrue = admin.getPwd();
            if(pwd.equals(pwdtrue)){
                admin.setPwd(null);
                return admin;
            }
        }
        return null;
    }
}
