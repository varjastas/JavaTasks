package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {
    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());

    }
    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){

            }
        }


    }

    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (Exception e){

                }
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        private boolean interrupted = false;
        @Override
        public void run() {
            while (!interrupted){

            }
        }

        @Override
        public void showWarning() {
            this.interrupted = true;
        }
    }
    public static class Thread5 extends Thread{
        @Override
        public void run() {
            int sum = 0;

            try (Scanner console = new Scanner(System.in)){
                while (true){
                    if (console.hasNextInt()){
                        sum += console.nextInt();
                    } if (console.hasNextLine() & console.nextLine().equals("N")){
                        System.out.println(sum);
                        break;
                    }
                }
            }

        }


    }
}