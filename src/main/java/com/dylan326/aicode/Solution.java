package com.dylan326.aicode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int maxDistance = 0;

    /**
     * 计算二叉树中两个距离最远的叶子节点的距离
     * @param root 二叉树根节点
     * @return 两个最远叶子节点的距离
     */
    public int maxDistanceBetweenLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return maxDistance;
    }

    /**
     * 递归计算以当前节点为根的子树的深度，并更新最大距离
     * @param node 当前节点
     * @return 当前节点的深度
     */
    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);

        // 如果当前节点有左右子节点，更新最大距离
        if (node.left != null && node.right != null) {
            maxDistance = Math.max(maxDistance, leftDepth + rightDepth);
        }

        // 返回当前节点的深度
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // 测试用例
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println("两个最远叶子节点的距离: " + solution.maxDistanceBetweenLeaves(root));
    }
}
