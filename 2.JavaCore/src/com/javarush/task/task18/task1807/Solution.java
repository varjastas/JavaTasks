package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner i = new Scanner(System.in);
            FileInputStream fileInputStream = new FileInputStream(i.nextLine())){
            int count = 0;
            while (fileInputStream.available() > 0){
                if (fileInputStream.read() == 44){
                    count += 1;
                }
            }
            System.out.println(count);
        } catch (Exception e){

        }
    }
}
