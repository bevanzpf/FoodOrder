package mapper;

import po.Productor;

import java.util.List;

/**
 * Created by p on 2017/5/3.
 */
public interface ProductorMapper {

    void addOne(Productor productor)throws Exception;

    List<Productor> selectAll() throws Exception;

    void deleteOne(Integer id)throws Exception;

    Productor findByEmail(String email) throws Exception;
}
