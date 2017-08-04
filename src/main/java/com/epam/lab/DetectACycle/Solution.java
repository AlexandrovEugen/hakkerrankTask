package com.epam.lab.DetectACycle;

public class Solution {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if (head == null){
            return false;
        }
        Node nextNode = head.next;
        while (nextNode != null){
            if (nextNode == head){
                return true;
            }
            else {
                nextNode = nextNode.next;
            }
        }
        return false;
    }

}
