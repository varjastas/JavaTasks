package com.javarush.task.pro.task09.task0905;

import java.util.regex.Pattern;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = -1;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = -1;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        if (decimalNumber > 0) {
            int i = 0;
            int result = 0;
            while (decimalNumber != 0) {
                result = result + (decimalNumber % 8) * (int) Math.pow(10, i);
                decimalNumber = decimalNumber / 8;
                i += 1;
            }
            return result;
        } else{
            return 0;
        }
    }

    public static int toDecimal(int octalNumber) {
        if (octalNumber > 0) {
            int i = 0;
            int result = 0;
            while (octalNumber != 0) {
                result = result + (octalNumber % 10) * (int) Math.pow(8, i);
                octalNumber = octalNumber / 10;
                i += 1;
            }

            return result;
        } else{
            return 0;
        }
    }
}
