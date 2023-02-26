package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) {
        String fileName = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ignore) {
            /* NOP */
        }

        String fileLine;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            int counter = 0;
            while ((fileLine = in.readLine()) != null) {
                counter = 0;
                for (String i:
                     fileLine.split(" ")) {
                    for (String q:
                         words) {
                        if (q.equals(i)){
                            counter += 1;
                            break;
                        }
                    }
                    if (counter > 2){
                        break;
                    }
                }
                if (counter == 2){
                    System.out.println(fileLine);
                }

            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
