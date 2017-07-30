package com.epam.lab.BalancedBrackets;

import java.util.Scanner;
import java.util.Stack;

public class Solution {


    public static boolean isBalanced(String expression) {
        final Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            final Character bracket = expression.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                brackets.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (brackets.empty()) {
                    return false;
                } else {
                    brackets.push(bracket);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        if (expression.length() % 2 == 0) {
            for (int i = 0; i < expression.length() / 2; i++) {
                final Character openBracket = expression.charAt(i);
                final Character closeBracket = brackets.pop();
                if (!isPair(openBracket, closeBracket)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    private static boolean isPair(Character openBracket, Character closeBracket) {
        if (openBracket == '(' && closeBracket == ')') {
            return true;
        } else if (openBracket == '{' && closeBracket == '}') {
            return true;
        } else if (openBracket == '[' && closeBracket == ']') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        if (n < 1 || n > 1_000) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < n; i++) {
            final String expression = in.next();
            if (expression.length() < 1 || expression.length() > 1_000) {
                throw new IllegalArgumentException();
            }
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
