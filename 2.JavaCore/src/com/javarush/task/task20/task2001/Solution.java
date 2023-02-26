package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("ssss.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov");
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            if (somePerson.equals(ivanov)){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            outputStream.write((this.name + "\n").getBytes());
            if (assets != null) {
                for (Asset i :
                        assets) {
                    outputStream.write((i.getName() + ":" + i.getPrice() + "\n").getBytes());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                StringBuilder fileData = new StringBuilder();
                while (bufferedInputStream.available() > 0) {
                    fileData.append((char) bufferedInputStream.read());
                }
                System.out.println(fileData.toString());
                String[] lines = fileData.toString().split("\n");
                this.name = lines[0];
                if (lines.length > 1) {
                    for (int i = 1; i < lines.length; i++) {
                        String[] data = lines[i].split(":");
                        Asset asset = new Asset(data[0], Double.parseDouble(data[1]));
                        this.assets.add(asset);
                    }
                } else {

                }
            } catch (Exception e){

            }

        }
    }
}
