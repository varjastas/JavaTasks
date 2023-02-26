package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        String next = i.nextLine();
        String finalFileName = next.split("\\.")[0] + "." + next.split("\\.")[1];
        TreeSet<String> fileNames = new TreeSet<>();
        fileNames.add(next);
        while (!(next = i.nextLine()).equals("end")){
            fileNames.add(next);
        }
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(finalFileName)) ) {

            for (String fileName : fileNames) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))){
                    byte[] buffer = new byte[bufferedInputStream.available()];
                    int real = bufferedInputStream.read(buffer, 0, buffer.length);
                    bufferedOutputStream.write(buffer, 0, real);
                } catch (Exception e){
                    System.out.println("Exception " + e);
                }

            }
        } catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}
