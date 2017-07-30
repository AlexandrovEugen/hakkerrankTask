package com.epam.lab.LeftRotation;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n < 1 || n > 100000){
            throw new IllegalArgumentException();
        }
        int k = in.nextInt();
        if (k < 1 || k > n){
            throw new IllegalArgumentException();
        }
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        if (n == k){
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        }
        else {
            swap(a, k);
        }
    }

    private static void swap(int[] a, int k) {
        int[] b = new int[a.length - k];
        System.arraycopy(a, k, b, 0, b.length);
        System.arraycopy(a, 0, a, a.length - k, k);
        System.arraycopy(b, 0, a,0,b.length);
        for (int anA : a) {
            System.out.print(anA + " ");
        }
    }
}

