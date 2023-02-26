package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread thread = new TestThread();
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        public TestThread() {

        }

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    current.interrupt();
                }

            }
        }
    }
}