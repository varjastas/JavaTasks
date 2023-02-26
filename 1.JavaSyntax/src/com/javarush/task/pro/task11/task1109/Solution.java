package com.javarush.task.pro.task11.task1109;

/* 
Объекты внутренних и вложенных классов
*/

public class Solution {
    public static void main(String[] args) {
        Outer.Nested a = new Outer.Nested();
        Outer c = new Outer();
        Outer.Inner b = c.new Inner();
    }
}
