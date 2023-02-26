package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String readString;
        while (!(readString = reader.nextLine()).equals("exit")) {
            new com.javarush.task.task18.task1823.Solution.ReadThread(readString).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run(){
            try {
                byte[] bytesCount = new byte[256];
                try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
                    while (fileInputStream.available() > 0) {
                        int aByte = fileInputStream.read();
                        bytesCount[aByte]++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int max = Integer.MIN_VALUE;
                for (int i:
                        bytesCount) {
                    if (i > max){
                        max = i;
                    }
                }
                ArrayList<Integer> maxBytes = new ArrayList<>();
                for (int i = 0; i < 256; i++) {
                    if (bytesCount[i] == max){
                        maxBytes.add(i);
                    }
                }
                synchronized (Solution.resultMap) {
                    Solution.resultMap.put(fileName, maxBytes.stream().min(Integer::compare).get());
                    System.out.println(resultMap.size());
                }
            } catch (Exception e){

            }

        }
    }
}
