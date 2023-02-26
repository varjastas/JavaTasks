package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException ignore) {
            /* NOP */
        }

        String fileLine;

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            while ((fileLine = in.readLine()) != null) {
                System.out.println(new StringBuilder(fileLine).reverse().toString());
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
