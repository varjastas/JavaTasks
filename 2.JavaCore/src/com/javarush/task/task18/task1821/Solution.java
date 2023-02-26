package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        HashMap<Character, Integer> count = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String content = bufferedReader.lines().collect(Collectors.joining("\n"));
            for (char i :
                    content.toCharArray()) {
                if (count.keySet().contains(i)) {
                    count.put(i, count.get(i) + 1);
                } else {
                    count.put(i, 1);
                }
            }

            TreeMap<Character, Integer> sorted = new TreeMap<>(count);

            // Display the TreeMap which is naturally sorted
            for (Map.Entry<Character, Integer> entry :
                    sorted.entrySet())
                System.out.println(entry.getKey() + " " + entry.getValue());


        } catch (Exception e){
            System.out.println("Exception " + e);
        }

    }
}
