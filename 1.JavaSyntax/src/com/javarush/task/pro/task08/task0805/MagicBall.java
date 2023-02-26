package com.javarush.task.pro.task08.task0805;

import java.util.Deque;
import java.util.Random;
import java.util.TreeMap;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        Random random = new Random();
        int choice = random.nextInt( 8);
        if (choice == 1) {
            return DEFINITELY;
        }
        if (choice == 2) {
            return MOST_LIKELY;
        }
        if (choice == 3) {
            return OUTLOOK_GOOD;
        }
        if (choice == 4) {
            return ASK_AGAIN_LATER;
        }
        if (choice == 5) {
            return TRY_AGAIN;
        }
        if (choice == 6) {
            return NO;
        }
        if (choice == 7) {
            return VERY_DOUBTFUL;
        }
        if (choice == 0) {
            return CERTAIN;
        }
        return null;
    }

}
