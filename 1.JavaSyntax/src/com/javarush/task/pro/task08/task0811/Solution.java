package com.javarush.task.pro.task08.task0811;

/* 
Побитовые операции
*/

public class Solution {

    public static void main(String[] args) {
        int x = 7;// 111
        //x = x & 25;// 11001
        x = x & 5;//101
        //x = x & 3;//11
        x = x & 12;//1100
        x = x | 1;//1
        System.out.println(x);
    }
}
