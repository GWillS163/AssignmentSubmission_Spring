package com.mengjq.assignmentsubmission_spring.util;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@Data
public class TimeFormat {
    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置北京时间
        return simpleDateFormat.format(new Date());
    }

    public static String verifyNull(String registerTime) {
        // if registerTime === "null" then return null
        if (registerTime.equals( "null")) return null;
        else {
            return registerTime;
        }
    }
}
