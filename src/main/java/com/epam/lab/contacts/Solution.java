package com.epam.lab.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        if (n < 1 || n > 100_000){
            throw new IllegalArgumentException();
        }
        final List<String> contacts = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            final String op = in.next();
            final String contact = in.next();
            switch (op) {
                case "add":
                    if (contact.length() < 1 || contact.length() > 21) {
                        throw new IllegalArgumentException();
                    } else {
                        contacts.add(contact);
                    }
                    break;
                case "find":
                    if (contact.length() < 1 || contact.length() > 21) {
                        throw new IllegalArgumentException();
                    }
                    final int count = findPartialCount(contact, contacts);
                    System.out.println(count);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private static int findPartialCount(String partial, List<String> contacts) {
        int count = 0;
        if (contacts.isEmpty()){
            return 0;
        }
        else {
            for (String contact: contacts) {
                if (partial.length() <= contact.length()){
                    if (contact.startsWith(partial)){
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }
}
