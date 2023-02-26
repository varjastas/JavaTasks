package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        String filename = args[0];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            String data = Arrays.stream(bufferedReader.lines().collect(Collectors.joining()).split("")).filter(x1 -> (x1.toLowerCase().matches("[a-z]"))).collect(Collectors.joining(""));
            System.out.println(data.length());
        } catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}
