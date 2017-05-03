package service;

import po.Admin;

/**
 * Created by p on 2017/5/3.
 */
public interface AdminService {

    //use for admin login
    public Admin authenticate(String email, String pwd)throws Exception;


}
