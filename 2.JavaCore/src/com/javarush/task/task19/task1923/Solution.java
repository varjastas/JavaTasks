package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        String fileOutputName = args[1];



        String fileLine;
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName));
            BufferedWriter out = new BufferedWriter(new FileWriter(fileOutputName))) {

            while ((fileLine = in.readLine()) != null){
                for (String i:
                     fileLine.split(" ")) {
                    for (char q:
                         i.toCharArray()) {
                        if (Character.isDigit(q)){
                            result.add(i);
                            break;
                        }
                    }
                }
            }
            out.write(result.stream().collect(Collectors.joining(" ")));
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
