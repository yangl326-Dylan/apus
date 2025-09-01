package com.dylan326.dsaa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by dylan on 2023/10/19.
 * 查找最近公共祖先 / Find Lowest Common Ancestor (LCA)
 */
public class C20FindLCA {


    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a binary tree.
     * 查找二叉树中两个节点的最近公共祖先 (LCA)。
     *
     * @param root The root of the binary tree. / 二叉树的根节点
     * @param n1 The first node. / 第一个节点
     * @param n2 The second node. / 第二个节点
     * @return The LCA of n1 and n2. / n1 和 n2 的 LCA
     */
    public static Node findLCA2(Node root, Node n1, Node n2) {
        // If root is null or matches one of the nodes, it's the LCA / 如果根节点为空或与其中一个节点匹配，则它是LCA
        if (root == null || root == n1 || root == n2) {
            return root;
        }
        // Recursively search in left and right subtrees / 在左右子树中递归搜索
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);
        // If left is null, LCA is in the right subtree / 如果左侧为空，LCA在右子树中
        if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) { // If right is null, LCA is in the left subtree / 如果右侧为空，LCA在左子树中
            return left;
        } else { // Both left and right are not null, so root is the LCA / 左右都不为空，所以根节点是LCA
            return root;
        }
    }

    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes by finding their paths from the root.
     * 通过查找两个节点从根节点到它们的路径来查找最近公共祖先 (LCA)。
     *
     * @param root The root of the binary tree. / 二叉树的根节点
     * @param n1 The first node. / 第一个节点
     * @param n2 The second node. / 第二个节点
     * @return The LCA of n1 and n2. / n1 和 n2 的 LCA
     */
    public static Node findLCA(Node root, Node n1, Node n2) {
        List<Node> tmp1 = new ArrayList<>();
        List<Node> tmp2 = new ArrayList<>();
        // Find path to n1 / 查找n1的路径
        findN(root, n1, tmp1);
        // Find path to n2 / 查找n2的路径
        findN(root, n2, tmp2);

        int n = Math.min(tmp1.size(), tmp2.size());
        Node result = null;
        // Compare paths to find the common ancestor / 比较路径以查找公共祖先
        for (int i = 0; i < n; i++) {
            if (tmp1.get(i) == tmp2.get(i)) {
                result = tmp1.get(i);
            } else {
                break;
            }

        }
        return result;

    }

    /**
     * Finds the path from the root to a target node using an iterative post-order traversal.
     * 使用迭代后序遍历查找从根到目标节点的路径。
     *
     * @param root The root of the binary tree. / 二叉树的根节点
     * @param target The target node. / 目标节点
     * @param record The list to store the path. / 存储路径的列表
     */
    public static void findN(Node root, Node target, List<Node> record) {
        Stack<Node> result = new Stack<Node>();
        Node p = root;
        Node pre = null;
        while (p != null || result.size() != 0) {
            while (p != null) {
                result.push(p);
                p = p.left;
            }
            if (result.size() != 0) {
                Node tmp = result.pop();
                // If right child is null or already visited / 如果右子节点为空或已访问
                if (tmp.right == null || tmp.right == pre) {
                    pre = tmp;
                    p = null;
                    if (tmp == target) {
                        break;
                    }
                } else {
                    result.push(tmp);
                    p = tmp.right;
                }
            }

        }
        // Add all nodes from stack to record, then add the target node / 将堆栈中的所有节点添加到记录中，然后添加目标节点
        record.addAll(result);
        record.add(target);
    }

    public static void main(String[] args) {
        //      0
        //    1   4
        //  2
        //     3
        Node root = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        root.left = n1;
        root.right = n4;
        n1.left = n2;
        n2.right = n3;
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);


        System.out.println();
        System.out.println("---------");
        dfs(root);
        System.out.println();
        bfs(root);
        System.out.println();

        System.out.println("---------");
        preOrderNoRe(root);
        System.out.println();
        inOrderNoRe(root);
        System.out.println();
        postOrderNoRe(root);

        System.out.println("---------");
        System.out.println(findLCA(root, n3, n2));
        System.out.println(findLCA2(root, n3, n2));
        System.out.println(findLCA(root, n3, n3));
        System.out.println(findLCA(root, n2, n3));
        System.out.println(findLCA(root, n3, n4));

    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root + "->");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void preOrderNoRe(Node root) {
        Stack<Node> result = new Stack<Node>();
        result.push(root);
        while (result.size() != 0) {
            Node tmp = result.pop();
            if (tmp != null) {
                System.out.print(tmp + "->");
                if (tmp.right != null) {
                    result.push(tmp.right);
                }
                if (tmp.left != null) {
                    result.push(tmp.left);
                }
            }
        }
    }


    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root + "->");
            inOrder(root.right);
        }
    }

    public static void inOrderNoRe(Node root) {
        Stack<Node> result = new Stack<Node>();
        Node p = root;
        while (p != null || result.size() != 0) {
            while (p != null) {
                result.push(p);
                p = p.left;
            }
            if (result.size() != 0) {
                Node tmp = result.pop();
                System.out.print(tmp + "->");
                p = tmp.right;
            }
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root + "->");
        }
    }
    public static void postOrderNoRe(Node root) {
        Stack<Node> result = new Stack<Node>();
        Node p = root;
        Node pre = null;
        while (p != null || result.size() != 0) {
            while (p != null) {
                result.push(p);
                p = p.left;
            }
            if (result.size() != 0) {
                Node tmp = result.pop();
                if (tmp.right == null || pre == tmp.right) { // 或者右节点被访问过，才打印临时root
                    System.out.print(tmp + "->");
                    pre = tmp;
                    p = null; //
                } else {
                    result.push(tmp);
                    p = tmp.right;
                }
            }
        }
    }

    public static void dfs(Node root) {
        Stack<Node> tmp = new Stack<Node>();
        tmp.push(root);
        while (tmp.size() != 0) {
            Node tmpNode = tmp.pop();
            if (tmpNode != null) {
                System.out.print(tmpNode + "->");
                if (tmpNode.right != null) {
                    tmp.push(tmpNode.right);
                }
                if (tmpNode.left != null) {
                    tmp.push(tmpNode.left);
                }
            }
        }
    }

    public static void bfs(Node root) {
        Queue<Node> tmp = new ArrayDeque<>();
        tmp.add(root);
        while (tmp.size() != 0) {
            Node tmpNode = tmp.poll();
            if (tmpNode != null) {
                System.out.print(tmpNode + "->");
                if (tmpNode.left != null) {
                    tmp.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    tmp.add(tmpNode.right);
                }
            }
        }
    }

    private static class Node {
        public Node(int val) {
            this.val = val;
        }

        int val;
        Node left;
        Node right;

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}

