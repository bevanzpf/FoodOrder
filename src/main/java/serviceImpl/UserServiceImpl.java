package serviceImpl;

import mailer.ActiveAcountMailer;
import mailer.ResetPwdMailer;
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
    @Autowired
    private ResetPwdMailer resetPwdMailer;

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

    public boolean changPwd(String email, String oldPwd, String newPwd) throws Exception {
        UserCustom user = authenticateLogin(email, oldPwd);
        if(user != null){
            user.setPwd(MD5Util.getMD5hash(newPwd));
            usersMapper.updatePwd(user);
            return true;
        }else{
            return false;
        }
    }

    public boolean solvePwdForgetRequest(String email) throws Exception {
        User user = usersMapper.findByEmail(email);
        if(user == null){
            return false;
        }else{
            String resetToken = RandomUtil.RandomString(22);
            String resetDigest = MD5Util.getMD5hash(resetToken);
            user.setResetDigest(resetDigest);
            usersMapper.setResetDigest(user);
            resetPwdMailer.send(email,resetToken);
            return true;
        }
    }

    public boolean solvePwdForgetLink(String email, String token) throws Exception {
        User user = usersMapper.findByEmail(email);
        String resetDigest = user.getResetDigest();
        if(resetDigest == null || email == null){
            return false;
        }
        String hashedToken = MD5Util.getMD5hash(token);
        if(resetDigest.equals(hashedToken))
            return true;
        return false;
    }

    public boolean solveResetForm(String email, String token, String newPwd) throws Exception {
        boolean isValidated = solvePwdForgetLink(email, token);
        if(!isValidated){
            return false;
        }else{
            User user = usersMapper.findByEmail(email);
            user.setPwd(MD5Util.getMD5hash(newPwd));
            user.setResetDigest(null);
            usersMapper.updatePwdAndResetDigest(user);
            return true;
        }
    }

}
