package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        String fileNameIn = args[0];
        String fileNameOut = args[1];

        String fileLine;
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileNameIn))) {
            while ((fileLine = in.readLine()) != null){
                for (String i: fileLine.split(" ")) {
                    if (i.length() > 6){
                        words.add(i);
                    }
                }
            }
        } catch (IOException ignore) {
            /* NOP */
        }

        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileNameOut))){

            out.write(words.stream().collect(Collectors.joining(",")));
        } catch (Exception e){

        }
    }
}
