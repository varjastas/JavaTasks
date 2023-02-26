package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date();;

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String[] days = new String[] {"воскресенье","понедельник", "вторник", "среда", "четверг", "пятница", "суббота"};

        return days[date.getDay()];
    }
}
