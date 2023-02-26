package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/* 
Самый богатый
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
            double max = Double.MIN_VALUE;
            for (double i:
                 map.values()) {
                if (Double.compare(max, i) < 0){
                    max = i;
                }
            }
            for (Map.Entry<String, Double> i:
                 map.entrySet()) {
                if (i.getValue() == max){
                    System.out.println(i.getKey());
                }
            }
        } catch (Exception e){
            System.out.println("Exception " + e);
        }
    }

}
