package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("ssss.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setCountry(User.Country.RUSSIA);
            user.setBirthDate(new Date());
            user.setLastName("lastName");
            user.setFirstName("firstName");

            javaRush.users.add(user);
            User usere = new User();
            usere.setCountry(User.Country.UKRAINE);
            usere.setBirthDate(new Date(90, 5, 30));
            usere.setLastName("lasqName");
            usere.setFirstName("firsqsdtName");

            javaRush.users.add(usere);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if (javaRush.equals(loadedObject)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method" + e);
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            StringBuilder data = new StringBuilder();

            if (users.size() > 0){
                for (User user:
                     users) {
                    data.append(String.format("%s %s %s %s %s\n", user.getFirstName(), user.getLastName(), user.getCountry().toString(), user.getBirthDate().getTime(), user.isMale()));
                }
            }
            if (data.length() > 0) {
                outputStream.write(data.toString().getBytes());
            } else {
                outputStream.write("null".getBytes());
            }

        }

        public void load(InputStream inputStream) throws Exception {
            StringBuilder data = new StringBuilder();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            while (bufferedInputStream.available() > 0){
                data.append((char) bufferedInputStream.read());
            }
            String[] lines = data.toString().split("\n");

            if (!lines[0].equals("n")){
                try {
                    for (String i: lines) {
                        String[] splitted_line = i.split(" ");
                        User user = new User();
                        user.setFirstName(splitted_line[0]);
                        user.setLastName(splitted_line[1]);
                        user.setBirthDate(new Date(Long.parseLong(splitted_line[3])));
                        user.setCountry(User.Country.valueOf(splitted_line[2]));
                        user.setMale(Boolean.parseBoolean(splitted_line[4]));
                        users.add(user);
                    }
                } catch (Exception e){
                    System.out.println("Exception " + e);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
