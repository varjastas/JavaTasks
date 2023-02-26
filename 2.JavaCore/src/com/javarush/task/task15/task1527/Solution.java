package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        String[] parametres = url.substring(url.indexOf("?")+1).split("&");
        String name = "";
        int counter = 1;

        for (String parameter:
             parametres) {

            if (parameter.contains("obj")){
                name = parameter.split("=")[1];
            }

            System.out.printf(parameter.split("=")[0]);
            if (counter != parametres.length){
                System.out.printf(" ");
            } else {
                System.out.println();
            }
            counter += 1;
        }
        if (name != "") {
            try {
                alert(Double.parseDouble(name));
            } catch (Exception e) {
                alert(name);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
