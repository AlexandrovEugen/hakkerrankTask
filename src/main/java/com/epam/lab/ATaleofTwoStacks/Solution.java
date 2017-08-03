package com.epam.lab.ATaleofTwoStacks;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<>();
        Stack<T> stackOldestOnTop = new Stack<>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            T val;
            if (stackNewestOnTop.empty() && stackOldestOnTop.empty()) {
                throw new StackOverflowError();
            }
            if (stackOldestOnTop.empty()) {
                while (!stackNewestOnTop.empty()) {
                    val = stackNewestOnTop.pop();
                    stackOldestOnTop.push(val);
                }
            }
            val = stackOldestOnTop.peek();
            return val;
        }

        public T dequeue() {
            T val;
            if (stackNewestOnTop.empty() && stackOldestOnTop.empty()) {
                throw new StackOverflowError();
            }
            if (stackOldestOnTop.empty()) {
                while (!stackNewestOnTop.empty()) {
                    val = stackNewestOnTop.pop();
                    stackOldestOnTop.push(val);
                }
            }
            val = stackOldestOnTop.pop();
            return val;
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}