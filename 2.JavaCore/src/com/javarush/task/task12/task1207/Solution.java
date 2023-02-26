package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        Solution.print(Integer.valueOf(2));
        Solution.print(3);
    }

    public static void print(int a){
        System.out.println(a);
    }
    public static void print(Integer a){
        System.out.println(a);
    }
}
