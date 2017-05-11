package po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by p on 2017/5/9.
 */
public class Car {
    private HashMap<String, String> carRecord;
    private int sum;

    public HashMap<String, String> getCarRecord() {
        return carRecord;
    }

    public void setCarRecord(HashMap<String, String> carRecord) {
        this.carRecord = carRecord;
    }

    public int getSum(){
        int sum = 0;
        if(carRecord !=null) {
            for (Map.Entry<String, String> entry : carRecord.entrySet()) {
                sum += Integer.valueOf(entry.getValue());
            }
        }
        return sum;
    }
}
