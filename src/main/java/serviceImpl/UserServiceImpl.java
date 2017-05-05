package serviceImpl;

import mailer.ActiveAcountMailer;
import mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.Custom.UserCustom;
import po.User;
import service.UserService;
import tools.MD5Util;
import tools.RandomUtil;

/**
 * Created by p on 2017/5/5.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ActiveAcountMailer activeAcountMailer;

    public int addOne(String email, String pwd) throws Exception {
        UserCustom userCustom = new UserCustom();
        userCustom.setEmail(email);
        String mdPwd = MD5Util.getMD5hash(pwd);// 对密码加密
        userCustom.setPwd(mdPwd);
        //生成随机数并加密成activeDigest
        String random = RandomUtil.RandomString(22);
        String activeDigest = MD5Util.getMD5hash(random);
        userCustom.setActiveDigest(activeDigest);
        int id = usersMapper.addOne(userCustom);
        System.out.println(id);
        activeAcountMailer.send(email, random);//发送激活邮件
        return id;
    }

    public UserCustom authenticateActive(String email, String token) throws Exception {
        UserCustom user = usersMapper.findByEmail(email);
        if(user != null){
            String hasedToken = MD5Util.getMD5hash(token);
            if(hasedToken.equals(user.getActiveDigest())){
                usersMapper.setActivited(user.getId());
                return user;
            }
        }
        return null;
    }

    public UserCustom authenticateLogin(String email, String pwd) throws Exception {
        UserCustom user = usersMapper.findByEmail(email);
        if(user == null || !user.isActivited()){
            return null;
        }else{
            String hashedPwd = MD5Util.getMD5hash(pwd);
            if(user.getPwd().equals(hashedPwd))
                return user;
        }
        return null;
    }
}
