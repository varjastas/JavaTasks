package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        var path1 = Path.of(str1);
        var path2 = Path.of(str2);
        try {
            var resolveFirst = path1.relativize(path2);
            System.out.println(resolveFirst);

        } catch (Exception e){

        }
    }
}

