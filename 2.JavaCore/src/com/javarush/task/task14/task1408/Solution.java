package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }
    static class HenFactory {
        static Hen getHen(String country) {
            if (country == Country.BELARUS){
                return new BelarusianHen();
            } else if (country == Country.MOLDOVA) {
                return new MoldovanHen();
            } else if (country == Country.RUSSIA) {
                return new RussianHen();
            } else if (country == Country.UKRAINE) {
                return new UkrainianHen();
            }

            return null;
        }
    }
}
