package cc.selfdem.cookbook.datetimes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class DateTimeSample {

    /**
     * date为主体的操作
     */
    @Test
    public void dateTest() {
        //获取当前日期
        LocalDate date = LocalDate.now();
        System.out.println(date);

        //通过年月日，创建日期
        date = LocalDate.of(2017, 10, 24);
        System.out.println(date);

        //通过字符串，创建日期
        date = LocalDate.parse("2017-10-24", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);

        //日期的增减
        System.out.println(date.plusDays(2));//加两天
        System.out.println(date.plusMonths(1));//加一个月
        System.out.println(date.plusWeeks(1));//加一周
        System.out.println(date.plusYears(1));//加一年

        //日期的比较
        System.out.println(date.isBefore(date.plusDays(1)));
        System.out.println(date.isAfter(date.plusDays(1)));
    }


    /**
     * time为主体的操作
     */
    @Test
    public void timeTest() {
        //获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //通过时分秒创建
        time = LocalTime.of(10, 10, 10);
        System.out.println(time);

        //通过字符串创建
        time = LocalTime.parse("10:10:10", DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(time);

        //时间的增减
        System.out.println(time.plusHours(1));//增加1小时
        System.out.println(time.plusMinutes(10));//增加10分钟
        System.out.println(time.plusSeconds(10));//增加10秒

        //时间的比较
        System.out.println(time.isBefore(time.plusSeconds(1)));
        System.out.println(time.isAfter(time.plusSeconds(1)));
    }

    /**
     * datetime为主体的操作
     */
    @Test
    public void datetimeTest() {
        //获取当前日期时间
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        //通过年月日时分秒创建
        dateTime = LocalDateTime.of(2017, 10, 24, 10, 10, 10);
        System.out.println(dateTime);

        //通过字符串创建
        dateTime = LocalDateTime.parse("2017-10-24 10:10:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime);

        //datetime的增减
        System.out.println(dateTime.plusYears(1));//加一年
        System.out.println(dateTime.plusMonths(1));//加一月
        System.out.println(dateTime.plusDays(1));//加一日
        System.out.println(dateTime.plusWeeks(1));//加一周
        System.out.println(dateTime.plusHours(1));//加一小时
        System.out.println(dateTime.plusMinutes(1));//加一分钟
        System.out.println(dateTime.plusSeconds(1));//加一秒

        //datetime的比较
        System.out.println(dateTime.isBefore(dateTime.plusSeconds(1)));
        System.out.println(dateTime.isAfter(dateTime.plusSeconds(1)));
    }
}
