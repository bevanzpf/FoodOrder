package mapper;

import org.apache.ibatis.session.RowBounds;
import po.Productor;

import java.util.List;

/**
 * Created by p on 2017/5/3.
 */
public interface ProductorMapper {

    void addOne(Productor productor)throws Exception;

    List<Productor> selectAll() throws Exception;

    List<Productor> selectAll(RowBounds rowBounds) throws Exception;

    void deleteOne(Integer id)throws Exception;

    Productor findByEmail(String email) throws Exception;

    Productor findById(Integer id) throws Exception;

    void updateBaseInfo(Productor productor)throws Exception;
}
