package work;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @description: 获取时间工具类
 * @author: zyb
 * @date: 2021/4/25 11:25
 */
public class TimeUtils {
    /**
     * 获取当前日期的前后多少天的日期开始时间
     *
     * @param num 数值为：正数"+" -> 多少天后，负数"-" -> 多少天前
     * @return 当前日期前后多少天的日期开始时间
     */
    public static Date getStartTimeOfDay(Integer num) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, num);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前日期的前后多少天的日期结束时间
     *
     * @param num 数值为：正数"+" -> 多少天后，负数"-" -> 多少天前
     * @return 当前日期前后多少天的日期结束时间
     */
    public static Date getEndTimeOfDay(Integer num) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getStartTimeOfDay(num));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        return calendar.getTime();
    }

    public static Long formatStatNum(Long number) {
        return Objects.isNull(number) ? 0 : number;
    }

    /**
     * 获取当前日期所在月份前后几个月的开始日期
     *
     * @param num num 数值为：正数"+" -> 多少月后，负数"-" -> 多少月前
     * @return 当前日期所在月份前后几个月的开始日期
     */
    public static Date getFirstDayOfMonth(Integer num) {
        return getDayOfMonth(num, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH)).getTime();
    }

    /**
     * 获取当前日期所在月份前后几个月的结束日期
     *
     * @param num num 数值为：正数"+" -> 多少月后，负数"-" -> 多少月前
     * @return 当前日期所在月份前后几个月的结束日期
     */
    public static Date getLastDayOfMonth(Integer num) {
        Calendar dayOfMonth = getDayOfMonth(num, Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));
        dayOfMonth.add(Calendar.SECOND, -1);
        dayOfMonth.add(Calendar.MONTH, 1);
        return dayOfMonth.getTime();
    }

    public static Calendar getDayOfMonth(Integer num, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, num);
        calendar.set(Calendar.DAY_OF_MONTH, value);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }

    public static Integer formatDateToMonth(Date date) {
        return Integer.valueOf(new SimpleDateFormat("yyyyMM").format(date));
    }

    /**
     * 获取当前日期月份的第一天的日期
     *
     * @param month 日期
     * @return 当前日期月份的第一天的日期
     */
    public java.util.Date getFirstDayOfMonth(java.util.Date month) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(month);
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        return cale.getTime();
    }

    /**
     * 获取当前日期月份的最后一天的日期
     *
     * @param month 日期
     * @return 当前日期月份的最后一天的日期
     */
    public java.util.Date getLastDayOfMonth(java.util.Date month) {
        Calendar cale = Calendar.getInstance();
        // 获取当前月的第一天
        cale.setTime(getFirstDayOfMonth(month));
        cale.add(Calendar.MONTH, 1);
        cale.add(Calendar.SECOND, -1);
        return cale.getTime();
    }

    /**
     * 获取一天最开始的时间
     *
     * @param day 日期
     * @return 当天最开始的时间
     */
    public static java.util.Date getBeginTimeOfDay(Date day) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(day);
        cale.set(Calendar.HOUR_OF_DAY, 0);
        cale.set(Calendar.MINUTE, 0);
        cale.set(Calendar.SECOND, 0);
        return cale.getTime();
    }

    /**
     * 获取一天最后的时间
     *
     * @param day 日期
     * @return 当天最后的时间
     */
    public static java.util.Date getEndTimeOfDay(Date day) {
        Calendar cale = Calendar.getInstance();
        // 获取一天最开始的时间
        cale.setTime(getBeginTimeOfDay(day));
        cale.add(Calendar.DAY_OF_MONTH, 1);
        cale.add(Calendar.SECOND, -1);
        return cale.getTime();
    }

    /**
     * 获取几天前/后的起始日期
     *
     * @param thisDay 当前日期
     * @param days    正数"+" -> 多少天后，负数"-" -> 多少天前
     * @return 几天前/后的起始日期
     */
    public static Date getBeginTimeAfterAddDays(Date thisDay, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(thisDay);
        cal.add(Calendar.DATE, days);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取几天前/后的当前日期
     *
     * @param thisDay 当前日期
     * @param days    正数"+" -> 多少天后，负数"-" -> 多少天前
     * @return 几天前/后的当前日期
     */
    public static Date getTimeAfterAddDays(Date thisDay, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(thisDay);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 将毫秒转为XX小时XX分钟
     *
     * @param milliseconds 毫秒值
     * @return XX小时XX分钟
     */
    public static String millisToStr(long milliseconds) {
        long hourValue = TimeUnit.MILLISECONDS.toHours(milliseconds);
        long minuteValue = TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds));
        return hourValue > 0 ? String.format("%02d小时%02d分钟", hourValue, minuteValue) : String.format("%02d分钟", minuteValue);
    }

    /**
     * Date转换成LocalDate
     *
     * @param date Date格式日期
     * @return LocalDate格式日期
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDate转换成Date
     *
     * @param localDate LocalDate格式日期
     * @return Date格式日期
     */
    public static Date localDate2Date(LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime转换成Date
     *
     * @param localDateTime localDateTime格式日期
     * @return Date格式日期
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * LocalDate格式化
     *
     * @param date Date格式日期
     * @return 指定格式字符串
     */
    public static String formatDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * LocalDateTime格式化
     *
     * @param date Date格式日期
     * @return 指定格式字符串
     */
    public static String formatDateTime(Date date) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public static void main(String[] args) {
//        Date startTimeOfDay = getStartTimeOfDay(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String startTime = dateFormat.format(startTimeOfDay);
//        Date endDate = DateUtil.endOfDay(startTimeOfDay).toJdkDate();
//        System.out.println(startTime);
//        System.out.println(dateFormat.format(endDate));
        Date date = getTimeAfterAddDays(new Date(), -1);
        System.out.println(dateFormat.format(date));
    }
}
