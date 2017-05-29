package serviceImpl;

import mapper.ProductorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import po.Productor;
import service.Service;

import java.util.List;

/**
 * Created by p on 2017/5/29.
 */
public class ServerImpl implements Service{
    @Autowired
    private ProductorMapper productorMapper;
    public List<Productor> findAllProductors() throws Exception {
        List<Productor> productors = productorMapper.selectAll();
        return productors;
    }
}
