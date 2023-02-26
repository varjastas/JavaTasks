package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("a", 1.0);
        grades.put("e", 1.0);
        grades.put("d", 1.0);
        grades.put("c", 1.0);
        grades.put("b", 1.0);
    }
}
