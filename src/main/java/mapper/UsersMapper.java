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
}
