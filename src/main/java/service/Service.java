package service;

import po.Productor;

import java.util.List;

/**
 * Created by p on 2017/5/29.
 */
public interface Service {
    List<Productor> findAllProductors()throws Exception;
}
