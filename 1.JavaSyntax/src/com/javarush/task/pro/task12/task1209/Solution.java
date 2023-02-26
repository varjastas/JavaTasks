package com.javarush.task.pro.task12.task1209;

import java.util.ArrayList;

/* 
Бухгалтерия
*/

public class Solution {
    public static ArrayList<String> waitingEmployees = new ArrayList<>();
    public static ArrayList<String> alreadyGotSalaryEmployees = new ArrayList<>();

    public static void initEmployees() {
        waitingEmployees.add("Гвинно");
        waitingEmployees.add("Гунигерд");
        waitingEmployees.add("Боргелейф");
        waitingEmployees.add("Нифрод");
        waitingEmployees.add("Альбиуф");
        waitingEmployees.add("Иногрим");
        waitingEmployees.add("Фриле");
    }

    public static void main(String[] args) {
        initEmployees();

    }

    public static void paySalary(String name) {
       if (name == null){
           return;
       } if (waitingEmployees.contains(name)){
            alreadyGotSalaryEmployees.add(name);
            int counter = 0;
            for (String i:
                    waitingEmployees) {
                counter += 1;
                if (i == name){
                    waitingEmployees.set(counter-1, null);
                }
            }
        }

    }
}
