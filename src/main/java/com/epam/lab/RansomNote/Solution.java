package com.epam.lab.RansomNote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    private Map<String, Integer> magazineMap;

    private final String magazine;
    private final String note;

    public Solution(String magazine, String note) {
        this.magazine = magazine;
        this.note = note;
    }

    private void initMaps() {
        magazineMap = new HashMap<>();
        fillData(magazine, magazineMap);
    }

    private void fillData(String str, Map<String, Integer> map) {
        for (String word : str.split(" ")) {
            final Integer val = map.remove(word);
            if (val == null) {
                map.put(word, 1);
            } else {
                final Integer newVal = val + 1;
                map.put(word, newVal);
            }
        }
    }

    public boolean solve() {
        initMaps();
        for (String word : note.split(" ")) {
            if (magazineMap.containsKey(word)) {
                final Integer freq = magazineMap.get(word);
                if (freq.compareTo(0) == 0) {
                    return false;
                } else {
                    magazineMap.replace(word, freq, freq - 1);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int m = scanner.nextInt();
        final int n = scanner.nextInt();
        if (n < 1 || n > 30_000) {
            throw new IllegalArgumentException();
        }
        if (m < 1 || m > 30_000) {
            throw new IllegalArgumentException();
        }
        // Eat whitespace to beginning of next line
        scanner.nextLine();

        final Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");
    }
}
