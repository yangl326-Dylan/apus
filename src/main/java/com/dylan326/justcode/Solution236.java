package com.dylan326.justcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> tmp1 = new ArrayList<TreeNode>();
        List<TreeNode> tmp2 = new ArrayList<TreeNode>();
        findN(root, p, tmp1);
        findN(root, q, tmp2);
        int n = Math.min(tmp1.size(), tmp2.size());
        TreeNode result = null;
        for (int i = 0; i < n; i++) {
            if (tmp1.get(i) == tmp2.get(i)) {
                result = tmp1.get(i);
            } else {
                break;
            }
        }
        return result;
    }

    private static Stack findN(TreeNode root, TreeNode target, List<TreeNode> list) {
        Stack<TreeNode> result = new Stack<TreeNode>();
        result.push(root);
        while (result.size() != 0) {
            TreeNode tmp = result.pop();
            list.add(tmp);
            if (tmp == target) {
                break;
            }
            if (tmp.right != null) {
                result.push(tmp.right);
            }
            if (tmp.left != null) {
                result.push(tmp.left);
            }
            if (tmp.left == null && tmp.right == null) {
                list.remove(tmp);
            }
        }
        return result;
    }

    public static void main(String[] strs) {

    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
