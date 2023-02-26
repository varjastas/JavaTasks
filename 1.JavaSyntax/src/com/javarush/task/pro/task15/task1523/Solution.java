package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        var connection = url.openConnection();


        connection.setDoOutput(true);
        try (var outputStream = connection.getOutputStream()){
            outputStream.write("Some thing".getBytes());
        }
        connection.setDoOutput(false);
        try (var inputStream = connection.getInputStream()){
            System.out.println(new String(inputStream.readAllBytes()));
        }
    }
}

