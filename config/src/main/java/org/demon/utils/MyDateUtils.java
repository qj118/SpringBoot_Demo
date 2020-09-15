package org.demon.utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class MyDateUtils {

    public static Date getFirstDayOfQuarter(){
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(2);
        if (var3 >= 0 && var3 <= 2) {
            var2.set(2, 0);
        }

        if (var3 >= 3 && var3 <= 5) {
            var2.set(2, 3);
        }

        if (var3 >= 6 && var3 <= 8) {
            var2.set(2, 6);
        }

        if (var3 >= 9 && var3 <= 11) {
            var2.set(2, 9);
        }

        var2.set(5, var2.getActualMinimum(5));
        return var2.getTime();
    }

    public static Date getLastDayOfQuarter(){
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(2);
        if (var3 >= 0 && var3 <= 2) {
            var2.set(2, 2);
        }

        if (var3 >= 3 && var3 <= 5) {
            var2.set(2, 5);
        }

        if (var3 >= 6 && var3 <= 8) {
            var2.set(2, 8);
        }

        if (var3 >= 9 && var3 <= 11) {
            var2.set(2, 11);
        }

        var2.set(5, var2.getActualMaximum(5));
        return var2.getTime();
    }


    public static Date getFirstDayOfLastYear(){
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(1) - 1;
        var2.set(1, var3);
        var2.set(2, 0);
        var2.set(5, 1);
        return var2.getTime();
    }

    public static Date getLastDayOfLastYear(){
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(1) - 1;
        var2.set(1, var3);
        var2.set(2, 11);
        var2.set(5, 31);
        return var2.getTime();
    }

    public static Date getFirstDayOfLastMonth() {
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(2) - 1;
        if(var3 == -1){
            var3 = 11;
            int var4  = var2.get(1) - 1;
            var2.set(1, var4);
        }
        var2.set(2, var3);
        var2.set(5, 1);
        return var2.getTime();
    }

    public static Date getLastDayOfLastMonth() {
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(2) - 1;
        if(var3 == -1){
            var3 = 11;
            int var4  = var2.get(1) - 1;
            var2.set(1, var4);
        }
        var2.set(2, var3);
        var2.set(5, var2.getActualMaximum(5));
        return var2.getTime();
    }

    public static Integer getNumberOfDaysMonth(){
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        return var2.getActualMaximum(5);
    }

    public static Integer getNumberOfDaysLastMonth(){
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(2) - 1;
        if(var3 == -1){
            var3 = 11;
        }
        var2.set(2, var3);
        return var2.getActualMaximum(5);
    }

    /**
     * 返回两个日期间的所有日期
     * @param start
     * @param end
     * @return
     */
    public static List<Date> getBetweenDates(Date start, Date end){
        List<Date> result = new ArrayList<>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);

        while(tempStart.before(tempEnd)){
            result.add(tempStart.getTime());
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        result.add(tempEnd.getTime());
        return result;
    }

    /**
     * key 是月第一天
     * value 是每月最后一天
     * @param thisYear 标识是今年还是去年
     * @return
     */
    public static Map<String, String> monthMap(boolean thisYear){
        Map<String, String> result = new HashMap<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        if(!thisYear){
            int var3 = var2.get(1) - 1;
            var2.set(1, var3);
        }
        for(int i = 0; i < 12; i ++){
            var2.set(2, i); // 设置月份
            var2.set(5, var2.getActualMinimum(5));
            Date var4 = var2.getTime();
            var2.set(5, var2.getActualMaximum(5));
            Date var5 = var2.getTime();
            result.put(format.format(var4), format.format(var5));
        }
        return result;
    }

    /**
     * 返回季度的三个月和月的一天和最后一天
     * @return
     */
    public static Map<Integer, Map<Date, Date>> getQuarterMonth(){
        Map<Integer, Map<Date, Date>> result = new HashMap<>();
        Date var1 = new Date();
        Calendar var2 = Calendar.getInstance();
        var2.setTime(var1);
        int var3 = var2.get(2);
        if(var3 >= 0 && var3 <= 2){
            for(int i = 0; i <= 2; i++) {
                var2.set(2,i);
                Map<Date, Date> resultMap = new HashMap<>();
                var2.set(5, var2.getActualMinimum(5));
                Date var4 = var2.getTime();
                var2.set(5, var2.getActualMaximum(5));
                Date var5 = var2.getTime();
                resultMap.put(var4,var5);
                result.put(i, resultMap);
            }
        }

        if(var3 >= 3 && var3 <= 5){
            for(int i = 3; i <= 5; i++) {
                var2.set(2,i);
                Map<Date, Date> resultMap = new HashMap<>();
                var2.set(5, var2.getActualMinimum(5));
                Date var4 = var2.getTime();
                var2.set(5, var2.getActualMaximum(5));
                Date var5 = var2.getTime();
                resultMap.put(var4,var5);
                result.put(i, resultMap);
            }
        }

        if(var3 >= 6 && var3 <= 8){
            for(int i = 6; i <= 8; i++) {
                var2.set(2,i);
                Map<Date, Date> resultMap = new HashMap<>();
                var2.set(5, var2.getActualMinimum(5));
                Date var4 = var2.getTime();
                var2.set(5, var2.getActualMaximum(5));
                Date var5 = var2.getTime();
                resultMap.put(var4,var5);
                result.put(i, resultMap);
            }
        }

        if(var3 >= 9 && var3 <= 11){
            for(int i = 9; i <= 11; i++) {
                var2.set(2,i);
                Map<Date, Date> resultMap = new HashMap<>();
                var2.set(5, var2.getActualMinimum(5));
                Date var4 = var2.getTime();
                var2.set(5, var2.getActualMaximum(5));
                Date var5 = var2.getTime();
                resultMap.put(var4,var5);
                result.put(i, resultMap);
            }
        }
        return result;
    }
}
