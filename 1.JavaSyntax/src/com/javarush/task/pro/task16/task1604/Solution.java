package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar();

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        String[] days = new String[] {"воскресенье","понедельник", "вторник", "среда", "четверг", "пятница", "суббота"};

        return days[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }
}
