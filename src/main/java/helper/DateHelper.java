package helper;

import java.sql.Date;

/**
 * Created by DELL on 2017-08-18.
 */
public class DateHelper {
    public static Date getOutDate(int day){
        return new Date(new java.util.Date().getTime() + day * 24 * 60 * 60 * 1000);
    }
}
