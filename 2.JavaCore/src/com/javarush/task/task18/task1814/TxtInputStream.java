package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, FileNotFoundException {
        super(fileName);

        String[] fileString = fileName.split("\\.");
        if (!fileString[fileString.length - 1].equals("txt")) {
            try {
                super.close();
            } catch (IOException e){

            }

            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {


    }
}

