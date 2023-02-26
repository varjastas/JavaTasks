package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner console = new Scanner(System.in);
        while (true) {
            try {
                FileInputStream fileInputStream = new FileInputStream(console.nextLine());
                if (fileInputStream.available() < 1000) {
                    throw new DownloadException();
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
    }
    public static class DownloadException extends Exception {

    }
}
