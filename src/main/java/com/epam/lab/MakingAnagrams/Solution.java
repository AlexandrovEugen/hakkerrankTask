package com.epam.lab.MakingAnagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {


    public static int numberNeeded(String first, String second) {
        int count = 0;
        final Map<Character, Integer> frequencyOfCharInStringA = new HashMap<>();
        final Map<Character, Integer> frequencyOfCharInStringB = new HashMap<>();
        fillTheMap(first, frequencyOfCharInStringA);
        fillTheMap(second, frequencyOfCharInStringB);
        for (Character character: frequencyOfCharInStringA.keySet()) {
            if (frequencyOfCharInStringB.containsKey(character)){
                final Integer bAmount = frequencyOfCharInStringB.get(character);
                final Integer aAmount = frequencyOfCharInStringA.get(character);
                count = count +  Math.abs(aAmount - bAmount);
            }
            else {
                count = count + frequencyOfCharInStringA.get(character);
            }
        }
        for (Character character : frequencyOfCharInStringB.keySet()) {
            if (!frequencyOfCharInStringA.containsKey(character)){
                count = count + frequencyOfCharInStringB.get(character);
            }
        }
        return count;

    }

    private static void fillTheMap(String str, Map<Character, Integer> frequencyOfCharInStringA) {
        for (int i = 0; i < str.length(); i++) {
            final Character character = str.charAt(i);
            final Integer val = frequencyOfCharInStringA.get(character);
            if (val != null) {
                frequencyOfCharInStringA.replace(character, val, val + 1);
            } else {
                frequencyOfCharInStringA.put(character, 1);
            }
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        if (a.length() < 1 || a.length() > 10_000){
            throw new IllegalArgumentException();
        }
        if (b.length() < 1 || b.length() > 10_000){
            throw new IllegalArgumentException();
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        System.out.println(numberNeeded(a, b));
    }
}
