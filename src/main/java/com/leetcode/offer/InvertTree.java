package com.leetcode.offer;

public class InvertTree {

    /*
        翻转一棵二叉树。

        示例：

        输入：

             4
           /   \
          2     7
         / \   / \
        1   3 6   9
        输出：

             4
           /   \
          7     2
         / \   / \
        9   6 3   1

     */

    public static void main(String[] args) {


    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        if (root.left != null) {
            invertTree(root.left);
        }

        if (root.right != null) {
            invertTree(root.right);
        }

        TreeNode tmpNode = root.right;
        root.right = root.left;
        root.left = tmpNode;

        return root;
    }
}
