package com.epam.lab.BubbleSort;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 2 || n > 600) {
            throw new IllegalArgumentException();
        }
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        bubbleSort(n, a);
    }

    private static void bubbleSort(int n, int[] a) {
        int totalNumOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    numberOfSwaps++;
                }
            }
            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
            totalNumOfSwaps += numberOfSwaps;
        }
        System.out.printf("Array is sorted in %d swaps.", totalNumOfSwaps);
        System.out.println();
        System.out.printf("First Element: %d", a[0]);
        System.out.println();
        System.out.printf("Last Element: %d", a[a.length - 1]);
    }
}
