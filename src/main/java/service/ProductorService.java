package service;

import org.springframework.web.multipart.MultipartFile;
import po.Productor;

import java.util.List;

/**
 * Created by p on 2017/5/3.
 */
public interface ProductorService {

    void addProductor(Productor productor)throws Exception;

    List<Productor> showAll()throws Exception;

    List<Productor> showAllPagely() throws Exception;

    void deleteOne(Integer id)throws Exception;

    Productor authenticate(String email, String pwd)throws Exception;

    Productor findById(Integer id) throws Exception;

    Productor updateBaseInfo(Productor productor, MultipartFile photo_file)throws Exception;


}
