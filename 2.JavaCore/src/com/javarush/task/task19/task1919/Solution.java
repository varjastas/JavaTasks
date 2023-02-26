package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            HashMap<String, Double> map = new HashMap<>();
            for (String i:
                    lines) {
                String name = i.substring(0, i.indexOf(" "));
                Double value = Double.parseDouble(i.substring(i.indexOf(" ")));
                Double valueBefore = 0.0;
                valueBefore = map.get(name) != null ? map.get(name) : 0.0;
                map.put(name, value + valueBefore);

            }

            map.entrySet().stream().sorted((x1, x2) -> (x1.getKey().compareTo(x2.getKey()))).forEach(stringDoubleEntry -> System.out.println(stringDoubleEntry.getKey() + " " + stringDoubleEntry.getValue()));

        } catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}

