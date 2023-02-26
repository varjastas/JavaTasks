package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    abstract public static class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet{
        @Override
        public Pet getChild() {
            return new Cat();
        }

        @Override
        public String getName() {
            return "sd";
        }
    }

    public static class Dog extends Pet {
        @Override
        public Pet getChild() {
            return new Dog();
        }

        @Override
        public String getName() {
            return "sd";
        }
    }

}
