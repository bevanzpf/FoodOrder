package mapper;

import po.Custom.UserCustom;
import po.User;

/**
 * Created by p on 2017/5/5.
 */
public interface UsersMapper {
    int addOne(UserCustom userCustom)throws Exception;

    UserCustom findByEmail(String email)throws Exception;

    void setActivited(Integer id) throws Exception;

    void updatePwd(User user)throws Exception;

    void setResetDigest(User user) throws Exception;

    void updatePwdAndResetDigest(User user) throws Exception;

    void updateBasedInfo(User user)throws Exception;

    User findById(Integer id)throws Exception;

}
