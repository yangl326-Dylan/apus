package com.dylan326.basic;

import java.util.*;

public class BinaryTreeExample {
    
    public static void main(String[] args) {
        // 1. 创建二叉树节点的不同方式
        System.out.println("=== 创建二叉树节点 ===");
        // 方式一：默认构造函数
        BinaryTreeNode root = new BinaryTreeNode();
        
        // 方式二：带值的构造函数
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        
        // 方式三：带值和左右子节点的构造函数
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        
        // 构建一个简单的二叉树
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        root = node1;
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        
        System.out.println("构建的二叉树根节点: " + root);
        
        // 2. 二叉树遍历操作
        System.out.println("\n=== 二叉树遍历操作 ===");
        
        // 前序遍历（递归）
        System.out.print("前序遍历（递归）: ");
        preorderTraversal(root);
        System.out.println();
        
        // 中序遍历（递归）
        System.out.print("中序遍历（递归）: ");
        inorderTraversal(root);
        System.out.println();
        
        // 后序遍历（递归）
        System.out.print("后序遍历（递归）: ");
        postorderTraversal(root);
        System.out.println();
        
        // 层序遍历（广度优先遍历）
        System.out.print("层序遍历: ");
        levelOrderTraversal(root);
        System.out.println();
        
        // 前序遍历（非递归）
        System.out.print("前序遍历（非递归）: ");
        preorderTraversalIterative(root);
        System.out.println();
        
        // 中序遍历（非递归）
        System.out.print("中序遍历（非递归）: ");
        inorderTraversalIterative(root);
        System.out.println();
        
        // 后序遍历（非递归）
        System.out.print("后序遍历（非递归）: ");
        postorderTraversalIterative(root);
        System.out.println();
        
        // 3. 二叉树其他操作
        System.out.println("\n=== 二叉树其他操作 ===");
        
        // 计算二叉树的高度
        int height = getHeight(root);
        System.out.println("二叉树的高度: " + height);
        
        // 计算二叉树的节点数
        int nodeCount = getNodeCount(root);
        System.out.println("二叉树的节点数: " + nodeCount);
        
        // 查找节点
        BinaryTreeNode foundNode = searchNode(root, 5);
        System.out.println("查找节点5: " + (foundNode != null ? "找到" : "未找到"));
        
        // 判断是否为完全二叉树
        boolean isComplete = isCompleteBinaryTree(root);
        System.out.println("是否为完全二叉树: " + isComplete);
        
        // 4. 二叉树的重要特性说明
        System.out.println("\n=== 二叉树的重要特性说明 ===");
        /*
         * 二叉树的重要特性：
         * 1. 每个节点最多有两个子节点，分别为左子节点和右子节点
         * 2. 左子节点和右子节点有明确的顺序关系
         * 3. 常见类型包括：满二叉树、完全二叉树、平衡二叉树等
         * 
         * 遍历方式：
         * 1. 前序遍历（根->左->右）
         * 2. 中序遍历（左->根->右）
         * 3. 后序遍历（左->右->根）
         * 4. 层序遍历（按层级从上到下，从左到右）
         * 
         * 时间复杂度：
         * - 遍历操作时间复杂度为O(n)
         * - 查找操作（在二叉搜索树中）时间复杂度为O(log n)
         * - 插入和删除操作（在二叉搜索树中）时间复杂度为O(log n)
         * 
         * 使用场景：
         * - 表达式树
         * - 决策树
         * - 文件系统目录结构
         * - 数据库索引（B+树）
         */
    }
    
    // 前序遍历（递归）
    public static void preorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    
    // 中序遍历（递归）
    public static void inorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    
    // 后序遍历（递归）
    public static void postorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }
    
    // 层序遍历（广度优先遍历）
    public static void levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) return;
        
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.val + " ");
            
            if (node.left != null) {
                queue.offer(node.left);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
    
    // 前序遍历（非递归）
    public static void preorderTraversalIterative(BinaryTreeNode root) {
        if (root == null) return;
        
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            System.out.print(node.val + " ");
            
            // 先压入右子节点，再压入左子节点（因为栈是后进先出）
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    
    // 中序遍历（非递归）
    public static void inorderTraversalIterative(BinaryTreeNode root) {
        if (root == null) return;
        
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // 一直向左走到底
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // 处理栈顶节点
            current = stack.pop();
            System.out.print(current.val + " ");
            
            // 转向右子树
            current = current.right;
        }
    }
    
    // 后序遍历（非递归）
    public static void postorderTraversalIterative(BinaryTreeNode root) {
        if (root == null) return;
        
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        BinaryTreeNode lastVisited = null;
        
        while (current != null || !stack.isEmpty()) {
            // 一直向左走到底
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                // 查看栈顶节点
                BinaryTreeNode peekNode = stack.peek();
                
                // 如果右子节点存在且未被访问过，则转向右子树
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    // 处理栈顶节点
                    System.out.print(peekNode.val + " ");
                    lastVisited = stack.pop();
                }
            }
        }
    }
    
    // 计算二叉树的高度
    public static int getHeight(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // 计算二叉树的节点数
    public static int getNodeCount(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return getNodeCount(root.left) + getNodeCount(root.right) + 1;
    }
    
    // 查找节点
    public static BinaryTreeNode searchNode(BinaryTreeNode root, int val) {
        if (root == null) {
            return null;
        }
        
        if (root.val == val) {
            return root;
        }
        
        BinaryTreeNode leftResult = searchNode(root.left, val);
        if (leftResult != null) {
            return leftResult;
        }
        
        return searchNode(root.right, val);
    }
    
    // 判断是否为完全二叉树
    public static boolean isCompleteBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reachedEnd = false;
        
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            
            if (node == null) {
                reachedEnd = true;
            } else {
                if (reachedEnd) {
                    // 如果已经遇到了空节点，但又遇到了非空节点，则不是完全二叉树
                    return false;
                }
                
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        
        return true;
    }
}