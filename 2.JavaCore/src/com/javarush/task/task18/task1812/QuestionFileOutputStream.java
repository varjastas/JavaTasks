package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream orig;

    public QuestionFileOutputStream(AmigoOutputStream orig) {
        this.orig = orig;
    }

    @Override
    public void flush() throws IOException {
        orig.flush();
    }

    @Override
    public void write(int b) throws IOException {
        orig.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        orig.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        orig.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        try (Scanner console = new Scanner(System.in)){
            System.out.println("Вы действительно хотите закрыть поток? Д/Н");
            if (console.nextLine().equals("Д")){
                orig.close();
            }
        }
    }
}

