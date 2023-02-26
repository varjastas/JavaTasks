package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;
import java.lang.Math;
/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[20];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        int first_part;
        if (array.length % 2 == 0){
            first_part = array.length / 2;

        } else{
            first_part = (int) (array.length / 2) + 1;
        }
        Arrays.fill(array, 0, first_part,  valueStart);
        Arrays.fill(array, first_part, array.length,  valueEnd);
        System.out.println(Arrays.toString(array));
    }
}
