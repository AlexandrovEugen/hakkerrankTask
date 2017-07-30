package com.epam.lab.contacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        final int n = in.nextInt();
        if (n < 1 || n > 100_000) {
            throw new IllegalArgumentException();
        }
        final Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            final String op = in.next();
            final String contact = in.next();
            switch (op) {
                case "add":
                    if (contact.length() < 1 || contact.length() > 21) {
                        throw new IllegalArgumentException();
                    } else {
                        trie.add(contact);
                    }
                    break;
                case "find":
                    if (contact.length() < 1 || contact.length() > 21) {
                        throw new IllegalArgumentException();
                    }
                    final int count = trie.find(contact);
                    System.out.println(count);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    static class Node {

        private final Map<Character, Node> children = new HashMap<>();
        private int size;

        private void putChildIfAbsent(char ch) {
            children.putIfAbsent(ch, new Node());
        }

        private Node getChild(char ch) {
            return children.get(ch);
        }
    }

    private static class Trie {

        final private Node root = new Node();

        private void add(String str) {
            Node curr = root;
            for (int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                curr.putChildIfAbsent(ch);
                curr = curr.getChild(ch);
                curr.size++;
            }
        }

        private int find(String partial) {
            Node curr = root;
            for (int i = 0; i < partial.length(); i++) {
                final Character ch = partial.charAt(i);
                curr = curr.getChild(ch);
                if (curr == null) {
                    return 0;
                }
            }
            return curr.size;
        }
    }
}
