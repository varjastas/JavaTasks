package com.javarush.task.task13.task1304;

/* 
Selectable и Updatable
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh();
    }

    public class Screen implements Updatable, Selectable{
        @Override
        public void refresh() {

        }

        @Override
        public void onSelect() {

        }
    }
}
