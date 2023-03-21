package com.mengjq.assignmentsubmission_spring.util;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;


@Data
public class TimeFormat {
    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置北京时间
        return simpleDateFormat.format(new Date());
    }

    public static String verifyNull(String time) {
        // if registerTime === "null" then return null
        if (time.equals("null") || Objects.equals(time, "")) return null;
        else {
            return time;
        }
    }

    public static String verifyTimeOrDefault(String time) {
        if (verifyNull(time) == null){
            return "2099-01-01 00:00:00";}
        else {
            return time;
        }
    }
}
