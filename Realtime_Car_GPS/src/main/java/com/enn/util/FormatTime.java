package com.enn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化
 * Created by yjr on 2016/8/2.
 */
public class FormatTime {

    private static FormatTime fromat;

    public static FormatTime GetFormatTime()
    {
        if (fromat == null)
        {
            fromat = new FormatTime();
        }
        return fromat;
    }

    public String timetostring(Date date)
    {
        String dates=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

        try {
            dates=format.format(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dates;
    }
    public String timetostring2(Date date)
    {
        String dates=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dates=format.format(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  dates;
    }

    public Date stringtostime(String date)
    {
        Date  dates=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            dates=format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return dates;
    }

    public Date stringtostime2(String date)
    {
        Date  dates=null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
              dates=format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return dates;
    }
}
