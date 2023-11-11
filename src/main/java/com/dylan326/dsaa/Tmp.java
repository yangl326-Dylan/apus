package com.dylan326.dsaa;

import java.util.Stack;

/**
 * Created by dylan on 2023/11/8.
 */
public class Tmp {

    public static void preorderNoRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (stack.size() != 0) {
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                System.out.println(tmp.val);
                if(tmp.right !=null){
                    stack.push(tmp.right);
                }

                if(tmp.left !=null){
                    stack.push(tmp.left);
                }
            }
        }

    }

    public static void postorderNoRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (stack.size() != 0 || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            TreeNode tmp = stack.pop();
            if (tmp.right == null || pre == tmp.right) {
                System.out.println(tmp);
                current = null;
                pre = tmp;
            } else {
                stack.push(tmp);
                current = tmp.right;
            }

        }

    }

    public static void quickSort(int[] a, int m, int n) {
        if (m < n) {
            int i = m;
            int j = n;
            int pivot = a[m]; // 选取的中枢
            while (i< j){
                while (i< j && a[j] > pivot){
                    j--;
                }
                while (i< j && a[i] <=pivot){
                    i++;
                }
                if(i < j){
                    swap(a,i,j);
                }else { // i == j
                    swap(a, m,i);
                }
            }
            quickSort(a, m, i-1);
            quickSort(a, i+1, n);

        }

    }

    private static void swap(int[] a, int m, int i) {
        int tmp  = a[m];
           a[m] = a[i];
           a[i] = tmp;
    }

    public static void inorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left);
        System.out.println(root);
        inorderRecursive(root.right);

    }

    public static void main(String[] args) {
        //      0
        //    1   4
        //  2
        //     3
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n2.right = n3;

        preorderNoRecursive(root);
//        System.out.println("---");
//        inorderRecursive(root);

    }


    private static class ListNode {
        int val;
        C11ReverseLinkedNode.ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
