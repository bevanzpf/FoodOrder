package serviceImpl;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by p on 2017/5/7.
 */
public class PicUpLoadHelper {

    private static String physicalPath;

    public void setPhysicalPath(String physicalPath) {
        PicUpLoadHelper.physicalPath = physicalPath;
    }
    public void init(){
        physicalPath = this.physicalPath;
    }

    private static String getYMDPath(){
        //文件物理根路径
        String path = physicalPath;
        Calendar now = Calendar.getInstance();
        String year = String.valueOf(now.get(Calendar.YEAR));
        String month = String.valueOf(now.get(Calendar.MONTH));
        String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        //根据日期设置分级
        String ymdPath = "\\"+year+"\\"+month+"\\"+day+"\\";
        String soreDir= path +ymdPath;
        File dir = new File(soreDir);
        if(!dir.exists())
            dir.mkdirs();
        return ymdPath; //返回年月日的路径
    }

    public static String upload(MultipartFile photo_file) throws IOException {

        String orignialFileName = photo_file.getOriginalFilename();
        //获取源文件后追名
        String newFileName = UUID.randomUUID()+ orignialFileName.substring(orignialFileName.lastIndexOf("."));
        String ymdPath= getYMDPath();
        File newFile = new File(physicalPath+ymdPath+newFileName);
        photo_file.transferTo(newFile);
        return ymdPath + newFileName;
    }
}
