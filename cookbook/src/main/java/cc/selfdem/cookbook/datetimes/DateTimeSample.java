package cc.selfdem.cookbook.datetimes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

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
        LocalDate date2 = LocalDate.of(2016, 03, 30);
        Period period = date.until(date2);
        System.out.println(period);//得到两个日期之间的间隔

        //日期推演
        System.out.println(date.withDayOfMonth(1));//获取当月的第一天
        System.out.println(date.withDayOfYear(1));//获取当年的第一天
        System.out.println(date.withMonth(1));//修改月份为当年第一个月
        System.out.println(date.withYear(1));//修改年份为第一年，即0001
        System.out.println(date.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));//前一个周六
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
        LocalTime time2 = LocalTime.of(11, 11, 11);
        long gap = time.until(time2, ChronoUnit.SECONDS);
        System.out.println(gap);//得到两个时间之间的间隔，用秒表示

        //时间推演
        System.out.println(time.withHour(1));//修改小时数为1
        System.out.println(time.withMinute(1));//修改分钟数为1
        System.out.println(time.withSecond(1));//修改秒数为1
        System.out.println(time.withNano(1));//修改纳秒为1
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
        LocalDateTime dateTime2 = LocalDateTime.of(2016, 03, 30, 1, 1, 1);
        long gap = dateTime.until(dateTime2, ChronoUnit.SECONDS);
        System.out.println(gap);//得到两个日期时间之间的间隔

        //datetime推演
        System.out.println(dateTime.withDayOfMonth(1));//获取当月的第一天
        System.out.println(dateTime.withDayOfYear(1));//获取当年的第一天
        System.out.println(dateTime.withMonth(1));//修改月份为当年第一个月
        System.out.println(dateTime.withYear(1));//修改年份为第一年，即0001
        System.out.println(dateTime.with(TemporalAdjusters.previous(DayOfWeek.SATURDAY)));//前一个周六
    }
}
