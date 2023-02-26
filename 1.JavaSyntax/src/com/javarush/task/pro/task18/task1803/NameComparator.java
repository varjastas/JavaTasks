package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor> {
    public int compare(JavaRushMentor first, JavaRushMentor second){
        return first.getName().length() - second.getName().length();
    }
}
