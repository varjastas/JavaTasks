package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Прайсы 2
*/

public class Solution {

    public static class Product{
        private int id;
        private String productName;
        private String price;
        private String quantity;

        public Product(int id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }



    }

    public static void main(String[] args) {
        String method = args[0];
        int id = Integer.parseInt(args[1]);
        String fileName = new Scanner(System.in).nextLine();
        List<String> lines = new ArrayList<>();

        int askedProductLineId = 0;
        int counter = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            lines = bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e){
            System.out.println("Exception " + e);
        }

        for (String line: lines) {
            Product product = Solution.getProduct(line);
            if (product.getId() == id){
                askedProductLineId = counter;
            }
            counter++;

        }

        switch (method){
            case "-d":{
                lines.remove(askedProductLineId);
                break;
            } case "-u":{
                String quantity = args[args.length - 1];
                String price = args[args.length - 2];
                ArrayList<String> productName = new ArrayList<>();
                for (int i = 2; i < args.length - 2 ; i++) {
                    productName.add(args[i]);
                }
                lines.set(askedProductLineId, String.format("%-8d%-30s%-8s%-4s", id, productName.stream().collect(Collectors.joining(" ")), price, quantity));

            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            bufferedWriter.write(lines.stream().collect(Collectors.joining("\n")));
        } catch (Exception e){

        }
    }

    public static Product getProduct(String line){
        int id = Integer.parseInt(line.substring(0, 8).trim());
        String productName = line.substring(8, 38).trim();
        String price = line.substring(38, 46).trim();
        String quantity = line.substring(46, line.length()).trim();
        return new Product(id, productName, price, quantity);
    }
}
