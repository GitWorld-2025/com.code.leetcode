package com.DataStructures.Tree;

import com.DataStructures.Structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {
    public static void main(String... args) {
        //BFSUsingRecursionCaller();
        //BFSUsingLinkedList();
        DFSCaller();
    }

    static void DFSCaller() {
        TreeNode root = createTree();
        DFSInorder(root);
    }

    static void DFSInorder(TreeNode node) {
        if (node == null) return;
        DFSInorder(node.left);
        System.out.println(node.data);
        DFSInorder(node.right);
    }

    static void BFSUsingLinkedList() {
        TreeNode root = createTree();
        List<List<Integer>> result = new ArrayList<>();

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelLength = q.size();
            if (result.size() <= level) result.add(new ArrayList<>());
            for (int i = 0; i < levelLength; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    result.get(level).add(node.data);
                    if (node.left != null) q.offer(node.left);
                    if (node.right != null) q.offer(node.right);
                }
            }
            level++;
        }

        for (List<Integer> ls : result) {
            for (int num : ls) {
                System.out.print(num + " : ");
            }
            System.out.println("");
        }
    }

    static void BFSUsingRecursionCaller() {
        TreeNode root = createTree();
        List<List<Integer>> result = new ArrayList<>();
        BFSUsingRecursion(root, result, 0);
        for (List<Integer> ls : result) {
            for (int num : ls) {
                System.out.print(num + " : ");
            }
            System.out.println("");
        }
    }

    static void BFSUsingRecursion(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() <= level) result.add(new ArrayList<>());

        result.get(level).add(node.data);
        BFSUsingRecursion(node.left, result, level + 1);
        BFSUsingRecursion(node.right, result, level + 1);
    }

    static TreeNode createTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(14);

        root.right.right = new TreeNode(2);

        root.left.left.left = new TreeNode(17);
        root.left.left.right = new TreeNode(23);

        root.left.right.left = new TreeNode(27);
        root.left.right.right = new TreeNode(3);

        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(11);
        return root;
    }
}
