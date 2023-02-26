package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        String fileName;
        while (true){
            fileName = i.nextLine();
            try (FileInputStream fileInputStream = new FileInputStream(fileName)){

            } catch (FileNotFoundException e){
                System.out.println(fileName);
                break;
            } catch (Exception e){

            }
        }
    }
}
