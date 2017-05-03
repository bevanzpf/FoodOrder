package mapper;

import po.Admin;

/**
 * Created by p on 2017/5/3.
 */
public interface AdminMapper {

    //通过email找admin
    public Admin findAdminByEmail(String email)throws Exception;

}
