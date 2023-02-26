package com.javarush.task.pro.task06.task0605;

/* 
Правильный порядок
*/

public class Solution {

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        reverseArray(array);
        printArray(array);
    }

    public static void reverseArray(int[] array) {
        int[] temp = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            temp[j] = array[i];
            j = j + 1;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
