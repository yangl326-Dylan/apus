package com.dylan326.justcode;

import java.util.Stack;

/**
 * Created by dylan on 2023/11/8.
 */
public class Solution112FindTargetSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static boolean hasPathSumRecursive(TreeNode root, int target) {
        TreeNode current = root;
        if (current == null && target != 0) {
            return false;
        }

        if (current == null && target == 0) {
            return true;
        }

        if (current.left == null && current.right == null && current.val == target) {
            return true;
        }
        return hasPathSumRecursive(current.left, target - current.val) || hasPathSumRecursive(current.right, target - current.val);

    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null || stack.size() != 0) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                if (tmp.right == null || pre == tmp.right) {
                    if (tmp.left == tmp.right && tmp.left == null && sumStack(stack) == target - tmp.val) {
                        return true;
                    }
                    current = null;
                    pre = tmp;

                } else {
                    stack.push(tmp);
                    current = tmp.right;
                }
            }
        }
        return false;
    }

    private static int sumStack(Stack<TreeNode> stack) {
        int sum = 0;
        for (TreeNode node : stack) {
            sum += node.val;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t5= new TreeNode(5);
        TreeNode t4= new TreeNode(4);
        TreeNode t11= new TreeNode(11);
        TreeNode t2= new TreeNode(2);
        TreeNode t7= new TreeNode(7);
        t5.left = t4;
        t4.left = t11;
        t11.left = t7;
        t11.right = t2;

        System.out.println(hasPathSumRecursive(t5,21));
        System.out.println(hasPathSum(t5,21));

    }
}
