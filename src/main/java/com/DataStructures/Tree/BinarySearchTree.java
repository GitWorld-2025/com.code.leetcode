package com.DataStructures.Tree;

import com.DataStructures.Structures.TreeNode;

public class BinarySearchTree {
    public static void main(String... args) {
    }

    static void ValidateBinarySearchTree() {

    }

    static boolean isValidBSTUsingRangeMinMax(TreeNode node, int min, int max){
        /// ValidateBinarySearchTree
        if(node == null) return true;
        if(node.data > max || node.data < min) return false;
        return isValidBSTUsingRangeMinMax(node.left, min , node.data-1) && isValidBSTUsingRangeMinMax(node.right,node.data+1,max);
    }
}
