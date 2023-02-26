package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Solution {

    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {

        MULTIPLICATION_TABLE = new int[10][10];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                MULTIPLICATION_TABLE[i-1][j-1] = j*i;
            }
        }
        String temp = "";
        for (int i = 0; i < 10; i++) {
            temp = "";
            for (int j = 0; j < 10; j++) {
                temp = temp + " " + MULTIPLICATION_TABLE[i][j];
            }
            System.out.println(temp);
        }


    }
}
