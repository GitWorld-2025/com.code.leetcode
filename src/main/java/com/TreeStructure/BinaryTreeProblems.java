package com.TreeStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeProblems {
    public static void main(String... args){
        isSymmetricCaller();
    }
    /// Symetric Tree Start
    public static void isSymmetricCaller(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        if(isSymmetric(root)) System.out.println("Tree is Symmetric");
        else System.out.println("Tree is not Symmetric");
    }
    public static boolean isSymmetric(TreeNode root) {
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp != null){
                    if(temp.left != null) list.add(temp.left);
                    if(temp.right != null) list.add(temp.right);
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
            level *= 2;
            flag = checkPalindrom(list,level);
        }
        return flag;
    }

    public static boolean checkPalindrom(List<TreeNode> list, int level){
        if(list.isEmpty()) return true;
        if(level != list.size()) return false;
        int i = 0;
        int j = list.size() -1;
        while(i<j){
            if(list.get(i).val != list.get(j).val){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    /// Symetric Tree End

    /// DFS Caller Start
    public static void DFSCaller(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int level = 0;
        System.out.println("Final level : " + DFS(root, level));
    }
    public static int DFS(TreeNode node, int level){
        if(node == null) return level;
        level++;
        System.out.println("Level : " + level);
        System.out.println("Node value : "+ node.val);
        int temp1 =  DFS(node.left, level);
        int temp2 = DFS(node.right, level);
        return Math.max(temp1,temp2);
    }
    /// DFS Caller End
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
