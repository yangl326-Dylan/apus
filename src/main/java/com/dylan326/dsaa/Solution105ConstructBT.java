package com.dylan326.dsaa;

import java.util.Stack;

/**
 * Created by dylan on 2023/11/6.
 */
public class Solution105ConstructBT {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

    }


    /**
     * @param preorder 3,9,20,15,7
     * @param inorder  9 3 15 20 7
     *                 postorder 9 15 7 20 3
     * @return
     */
    public static TreeNode constructBTNoRecursive(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> tmp = new Stack<>();
        tmp.add(root);
        int pre = 1;
        int in = 0;
        while (tmp.size() !=0 && pre < preorder.length){
            TreeNode top = tmp.peek();
            if(top.val != inorder[in]){
                top.left = new TreeNode(preorder[pre]);
                tmp.add(top.left);
                pre++;
            } else {
                while(tmp.size()!=0  && tmp.peek().val == inorder[in]){// 这个地方注意  tmp.peek
                    top = tmp.pop();
                    in++;
                }
                top.right= new TreeNode(preorder[pre]);
                tmp.add(top.right);
                pre++;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        constructBTNoRecursive(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }



    /**
     * @param preorder 3,9,20,15,7
     * @param inorder  9 3 15 20 7
     *                 postorder 9 15 7 20 3
     * @return
     */
    public static TreeNode constructBT(int[] preorder, int[] inorder) {
        return findTmpRootNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * preorder 3,9,20,15,7
     *
     * inorder  9 3 15 20 7
     *
     * @return
     */
    private static TreeNode findTmpRootNode(int[] preorder, int[] inorder, int startP, int endP, int startI, int endI) {
        if (startP > endP || startI > endI) {
            return null;
        }
        int tmpRootVal = preorder[startP];
        TreeNode tmpRoot = new TreeNode(tmpRootVal);
        int flag = 0;
        for (int i = startI; i <= endI; i++) {
            if (inorder[i] == tmpRootVal) {
                flag = i;
            }
        }
        tmpRoot.left = findTmpRootNode(preorder, inorder, startP + 1, startP + flag - startI, startI, flag - 1);
        tmpRoot.right = findTmpRootNode(preorder, inorder, startP + flag - startI + 1, endP, flag + 1, endI);
        return tmpRoot;
    }

    /**
     * postorder 9 15 7 20 3
     *
     * inorder  9 3 15 20 7
     *
     * @return
     */
    private static TreeNode findTmpRootNode2(int[] postorder, int[] inorder, int startP, int endP, int startI, int endI) {
        if (startP > endP || startI > endI) {
            return null;
        }
        int tmpRootVal = postorder[endP];
        TreeNode tmpRoot = new TreeNode(tmpRootVal);
        int flag = 0;
        for (int i = startI; i <= endI; i++) {
            if (inorder[i] == tmpRootVal) {
                flag = i;
            }
        }
        tmpRoot.left = findTmpRootNode(postorder, inorder, startP, startP + flag - startI, startI, flag - 1);
        tmpRoot.right = findTmpRootNode(postorder, inorder, startP + flag - startI + 1, endP - 1, flag + 1, endI);
        return tmpRoot;
    }



}
