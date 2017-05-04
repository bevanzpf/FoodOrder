package serviceImpl;

import mapper.ProductorMapper;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import po.Productor;
import service.ProductorService;

import java.util.List;

/**
 * Created by p on 2017/5/3.
 */
public class ProductorServiceImpl implements ProductorService{

    @Autowired
    private ProductorMapper productorMapper;

    public void addProductor(Productor productor) throws Exception{
        productorMapper.addOne(productor);
    }

    public List<Productor> showAll() throws Exception {
        List<Productor> productors = productorMapper.selectAll();
        return productors;
    }

    public void deleteOne(Integer id) throws Exception {
        productorMapper.deleteOne(id);
    }

    public Productor authenticate(String email, String pwd) throws Exception {
        Productor productor = productorMapper.findByEmail(email);
        System.out.println(productor);
        if(productor != null){
            String turePwd = productor.getPwd();
            if(turePwd.equals(pwd)){
                productor.setPwd(null);
                return productor;
            }
        }
        return null;
    }

    public Productor findById(Integer id) throws Exception {
        Productor productor = productorMapper.findById(id);
        return productor;
    }
}
