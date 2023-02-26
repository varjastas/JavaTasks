package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/

public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Solution solution = new Solution();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("s.txt"));
        objectOutputStream.writeObject(solution.node);
        objectOutputStream.writeObject(solution.edges);
    }
}
