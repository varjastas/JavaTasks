package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        String fileName = args[0];

        String fileLine;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String[] argss;
            while ((fileLine = in.readLine()) != null) {
                argss = fileLine.split(" ");
                int day = Integer.parseInt(argss[argss.length - 3]);
                int month = Integer.parseInt(argss[argss.length - 2]);
                int year = Integer.parseInt(argss[argss.length - 1]);
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < argss.length - 3; i++) {
                    name.append(argss[i] + " ");
                }
                String namee = name.toString();
                PEOPLE.add(new Person(namee.substring(0, namee.length() - 1), new Date(year - 1900, month - 1, day)));
            }
        } catch (IOException ignore) {
            /* NOP */
        }

    }
}
