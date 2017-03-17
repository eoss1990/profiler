package com.dee.profiler.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangyu on 2017/3/17.
 */
public final class DateUtil {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date){
        return simpleDateFormat.format(date);
    }
}
