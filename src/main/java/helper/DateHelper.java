package helper;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by DELL on 2017-08-18.
 */
public class DateHelper {
    /**
     *
     * @param day 失效的日期
     * @return 返回SQLDate
     */
    public static Date getOutDate(int day){
        return new Date(new java.util.Date().getTime() + day * 24 * 60 * 60 * 1000);
    }

    /**
     *
     * @param date 判断日期是否失效
     * @return 布尔值
     */
    public static boolean isExpired(Date date){
        Calendar calendar = Calendar.getInstance();
        java.util.Date utilDate = calendar.getTime();
        //java.util.Date日期转换成转成java.sql.Date格式
        Date nowDate = new Date(utilDate.getTime());
        return nowDate.after(date);
    }
}
