package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        String firstFileName = i.nextLine();
        String secondFileName = i.nextLine();
        String thirdFileName = i.nextLine();
        try (FileInputStream fileInputStreamFirst = new FileInputStream(firstFileName);
            FileOutputStream fileOutputStreamSecond = new FileOutputStream(secondFileName);
            FileOutputStream fileOutputStreamThird = new FileOutputStream(thirdFileName))
        {
            int lenFirstFileToSecond = fileInputStreamFirst.available() % 2 == 0 ? fileInputStreamFirst.available() / 2 : (int) fileInputStreamFirst.available() / 2 + 1;
            int lenFirstFileToThird = (int) Math.ceil(fileInputStreamFirst.available() / 2);

            for (int j = 0; j < lenFirstFileToSecond; j++) {
                fileOutputStreamSecond.write(fileInputStreamFirst.read());
            }
            for (int j = 0; j < lenFirstFileToThird; j++) {
                fileOutputStreamThird.write(fileInputStreamFirst.read());
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
