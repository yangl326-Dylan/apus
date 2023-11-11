package com.dylan326.justcode;

import java.util.*;

public class Solution101SymmetricTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }
    }

    public static boolean isSymmetricTree(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);

    }

    private static boolean check(TreeNode left, TreeNode right) {
        if(left == right && left == null){
            return true;
        }
        if(left == null && right!=null ||(right == null && left !=null)){
            return false;
        }
        return left.val == right.val && check(left.left,right.right) && check(left.right, right.left);
    }

    public static void main(String[] args) {
//        System.out.println(isSymmetricTree());
        Queue q = new ArrayDeque();
        Queue p = new LinkedList();

    }
}
