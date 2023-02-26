package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        try (var directoryStream = Files.newDirectoryStream(sourceDirectory)){
            for (var i:
                 directoryStream) {
                if (Files.isRegularFile(i)) {
                    //System.out.println(i);
                    var targetPath =  targetDirectory.resolve(i.getFileName());
                    System.out.println(targetPath);
                    Files.copy(i, targetPath);
                }
            }
        }
    }
}

