package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int count = console.nextInt();
        int[] sp = new int[count];
        if (count != 0) {

            for (int i = 0; i < count; i++) {
                sp[i] = console.nextInt();
            }
        }
            for (int i = 0; i < sp.length; i++) {
                if (count % 2 != 0){
                    System.out.println(sp[i]);
                } else{
                    System.out.println(sp[sp.length-i]);
                }
            }


    }
}
