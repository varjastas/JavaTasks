package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if (last.prev != null){
            Node lastElement = last.prev;
            Node newElement = new Node();
            newElement.next = last;
            newElement.prev = lastElement;
            newElement.value = value;
            lastElement.next = newElement;
            last.prev = newElement;
        } else {
            Node newElement = new Node();
            first.next = newElement;
            last.prev = newElement;
            newElement.prev = first;
            newElement.next = last;
            newElement.value = value;
        }

    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
