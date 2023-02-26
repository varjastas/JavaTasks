package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner console = new Scanner(System.in);
            FileInputStream fileInputStream = new FileInputStream(console.nextLine())){
            int max = Integer.MIN_VALUE;
            while (fileInputStream.available() != 0){
                int value = fileInputStream.read();
                if (value > max){
                    max = value;
                }
            }
            System.out.println(max);
        }

    }
}
