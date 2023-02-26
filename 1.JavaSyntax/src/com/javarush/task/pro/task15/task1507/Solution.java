package com.javarush.task.pro.task15.task1507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(var console = new Scanner(System.in))
        {
            var lines = Files.readAllLines(Paths.get(console.nextLine()));
            int counter = 0;
            for (var i:
                 lines) {
                if (counter % 2 == 0){
                    System.out.println(i);
                }
                counter += 1;
            }
        }
    }
}

