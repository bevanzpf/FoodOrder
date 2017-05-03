package service;

import po.Productor;

import java.util.List;

/**
 * Created by p on 2017/5/3.
 */
public interface ProductorService {

    void addProductor(Productor productor)throws Exception;

    List<Productor> showAll()throws Exception;

    void deleteOne(Integer id)throws Exception;

    Productor authenticate(String email, String pwd)throws Exception;
}
