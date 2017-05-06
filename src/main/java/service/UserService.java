package service;

import po.Custom.UserCustom;

/**
 * Created by p on 2017/5/5.
 */
public interface UserService {

    int addOne(String email, String pwd)throws Exception;

    UserCustom authenticateActive(String email, String token)throws Exception;

    UserCustom authenticateLogin(String email, String pwd) throws Exception;

    boolean changPwd(String email, String oldPwd, String newPwd)throws Exception;

    boolean solvePwdForgetRequest(String email)throws Exception;

    boolean solvePwdForgetLink(String email, String token)throws Exception;

    boolean solveResetForm(String email, String token, String newPwd) throws Exception;

}
