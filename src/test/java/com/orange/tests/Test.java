package com.orange.tests;

public class Test {
    public static void main(String[] args) {
        String input="Welcome to java";

        int countA = 0, countE = 0, countI = 0, countO = 0, countU = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'a') {
                countA++;
            } else if (ch == 'e') {
                countE++;
            } else if (ch == 'i') {
                countI++;
            } else if (ch == 'o') {
                countO++;
            } else if (ch == 'u') {
                countU++;
            }
        }

        int totalCount = countA + countE + countI + countO + countU;

        System.out.println("Number of vowels: " + totalCount);
        System.out.println("Number of 'a's: " + countA);
        System.out.println("Number of 'e's: " + countE);
        System.out.println("Number of 'i's: " + countI);
        System.out.println("Number of 'o's: " + countO);
        System.out.println("Number of 'u's: " + countU);
    }
}

