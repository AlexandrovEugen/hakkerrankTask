package com.epam.lab.IceCreamParlor;

import java.util.Arrays;
import java.util.Scanner;


class IceCream implements Comparable<IceCream> {
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
        this.flavor = flavor;
        this.index = index;
    }

    public int compareInt(int o) {
        return (this.flavor - o);

    }

    @Override
    public int compareTo(IceCream o) {
        return (this.flavor - o.flavor);

    }

    @Override
    public boolean equals(Object o) {
        return (this.flavor == (int) o);

    }

}

public class Solution {

    public static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid].equals(search)) return arr[mid].index;
            if (arr[mid].compareInt(search) > 0) {
                return binarySearch(first, mid - 1, arr, search);
            } else return binarySearch(mid + 1, last, arr, search);
        } else return -1;

    }

    public static void main(String[] args) {

        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for (int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);
            for (int i = 0; i < n - 1; i++) {
                int search = m - arr[i].flavor;
                if (search >= arr[i].flavor) {
                    int index = binarySearch(i + 1, n - 1, arr, search);
                    if (index != -1) {
                        System.out.println(Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            }

        }

    }

}