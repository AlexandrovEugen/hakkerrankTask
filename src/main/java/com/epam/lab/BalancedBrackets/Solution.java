package com.epam.lab.BalancedBrackets;

import java.util.Scanner;
import java.util.Stack;

public class Solution {


    public static boolean isBalanced(String expression) {
        final Stack<Character> brackets = new Stack<>();
        if (expression.length() % 2 == 0) {
            for (int i = 0; i < expression.length(); i++) {
                final Character bracket = expression.charAt(i);
                if (bracket == '(' || bracket == '[' || bracket == '{') {
                    brackets.push(bracket);
                } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                    if (brackets.empty()) {
                        return false;
                    } else if (!isPair(brackets.pop(), expression.charAt(i))){
                        return false;
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            if (brackets.empty()){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
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
