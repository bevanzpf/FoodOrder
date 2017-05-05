package tools;

import java.util.Random;

/**
 * Created by p on 2017/3/10.
 */
public class RandomUtil {
    public static String RandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
        int num = random.nextInt(62);
        buf.append(str.charAt(num));
        }
        return buf.toString();
        }
}