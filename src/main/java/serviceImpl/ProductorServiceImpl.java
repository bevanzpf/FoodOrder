package serviceImpl;

import mapper.ProductorMapper;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import po.Productor;
import service.ProductorService;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by p on 2017/5/3.
 */
public class ProductorServiceImpl implements ProductorService{

    @Autowired
    private ProductorMapper productorMapper;
    @Autowired
    private PicUpLoadHelper picUploadHelper;

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

    public Productor updateBaseInfo(Productor productor, MultipartFile photo_file) throws Exception {
        //不为空就上传图片
        if(!photo_file.isEmpty()){
            String picUrl = picUploadHelper.upload(photo_file);
            productor.setPhoto(picUrl);
        }
        productorMapper.updateBaseInfo(productor);
        Productor newProductor = productorMapper.findById(productor.getId());
        return newProductor; //返回跟新后的productor
    }
}
