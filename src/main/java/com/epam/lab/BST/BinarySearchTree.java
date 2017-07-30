package com.epam.lab.BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    private static class Node {

        private final int data;
        private Node left;
        private Node right;

        private Node(int data) {
            if (data > 10000){
                throw new IllegalArgumentException();
            }
            this.data = data;
        }
    }

    public boolean checkBST(Node root) {
        final List<Integer> list = new ArrayList<>();
        final List<Integer> list1 = treeToList(root, list);
        if (list1.isEmpty()){
            return false;
        }
        for (int i = 1; i < list1.size(); i++) {
            if (list1.get(i).compareTo(list1.get(i - 1)) <= 0){
                return false;
            }
        }
        return true;
    }

    private List<Integer> treeToList(Node root, List<Integer> list){
        if (root == null){
            return Collections.emptyList();
        }
        treeToList(root.left, list);
        list.add(root.data);
        treeToList(root.right, list);
        return list;
    }
}
