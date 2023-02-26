package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String firstFileName = console.nextLine();
        String secondFileName = console.nextLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFileName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(secondFileName))){

            ArrayList<String> arrayList = new ArrayList<>();
            String data = bufferedReader.lines().collect(Collectors.joining(" "));

            for (String i: data.split(" ")){
                Double ch = Double.parseDouble(i);
                if (ch < 0 & ch % 0.5 == 0){

                    ch = ch+0.5;
                }
                System.out.println(ch);
                arrayList.add(String.format("%.0f", ch));

            }
            bufferedWriter.write(arrayList.stream().collect(Collectors.joining(" ")));
        } catch(Exception e){
            System.out.println("Exception " + e);
        }
    }
}
