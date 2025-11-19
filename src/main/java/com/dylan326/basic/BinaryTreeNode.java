package com.dylan326.basic;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    // 默认构造函数
    public BinaryTreeNode() {
    }

    // 带值的构造函数
    public BinaryTreeNode(int val) {
        this.val = val;
    }

    // 带值和左右子节点的构造函数
    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "val=" + val +
                ", left=" + (left != null ? left.val : "null") +
                ", right=" + (right != null ? right.val : "null") +
                '}';
    }
}