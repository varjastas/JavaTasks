package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        HashSet<Integer> byteCountArray  = new HashSet<>();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                byteCountArray.add(fileInputStream.read());
            }
        }
        System.out.println(byteCountArray.stream().sorted().map(n -> n.toString()).collect(Collectors.joining(" ")));

    }
}
