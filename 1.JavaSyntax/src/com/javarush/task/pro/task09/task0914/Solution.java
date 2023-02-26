package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        int timer = 0;
        int first_kos = 0;
        int second_kos = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/'){
                timer += 1;

            }
            if (timer == 2){
                first_kos = i;
            } if (timer == 3){
                second_kos = i;
            }
        }
        String s = path.replace(path.substring(first_kos+2, second_kos+1), jdk);
        return s;
    }
}
