package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {
    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try (Scanner console = new Scanner(System.in)){
            String key = console.nextLine();
            if (key.equals("helicopter")){
                result = new Helicopter();
            } else{
                int countPeople = console.nextInt();
                result = new Plane(countPeople);
            }
        } catch (Exception e){

        }
    }
}
