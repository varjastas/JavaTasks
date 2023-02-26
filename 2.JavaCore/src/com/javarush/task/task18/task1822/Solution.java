package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        String id = args[0];
        String fileName = new Scanner(System.in).nextLine();
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            lines = bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e){}
        for (String i:
             lines) {
            if (i.split(" ")[0].equals(id)){
                System.out.println(i);
            }
        }
    }
}
