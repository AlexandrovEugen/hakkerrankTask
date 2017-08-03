package com.epam.lab.FibonacciNumbers;

import java.util.Scanner;

public class Solution {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        if (n < 0 || n > 40) {
            throw new IllegalArgumentException();
        }
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

