package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileInputStream = new BufferedReader(new FileReader(bufferedReader.readLine()));
             BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(bufferedReader.readLine()))) {

            String res = fileInputStream.lines().collect(Collectors.joining(" "));

            res = Arrays.stream(res.split(" ")).filter(x1 -> x1.matches("\\d+")).collect(Collectors.joining(" "));

            fileOutputStream.write(res);

        } catch (Exception e) {

        }
    }
}
