package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 2;

    public static void main(String[] args) throws InterruptedException {
        int temp = numSeconds;
        RacingClock clock = new RacingClock();

        Thread.sleep(3500);
        clock.interrupt();
        if (temp > 3){
            System.out.printf("Прервано!\n");
        }
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            Thread current = Thread.currentThread();

            while (!current.isInterrupted()){
              try {
                  if (numSeconds != 0) {

                      System.out.printf("%s ", numSeconds);
                      numSeconds--;

                  } else {
                      System.out.printf("Марш!\n");
                      current.interrupt();
                  }
                  Thread.sleep(1000);
              } catch (InterruptedException e){
                  current.interrupt();
              }
            }
        }
    }
}
