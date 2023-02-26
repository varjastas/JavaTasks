package com.javarush.task.pro.task16.task1614;

import java.time.Instant;
import java.time.LocalDate;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {


        return Instant.ofEpochMilli(Long.MAX_VALUE);
    }

    static Instant getMaxFromSeconds() {


        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
    }

    static Instant getMaxFromSecondsAndNanos() {
        //напишите тут ваш код

        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond(), 999999999);
    }
}
