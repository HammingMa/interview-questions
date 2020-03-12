package com.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};



        TreeNode root = buildTree(preOrder, inOrder);

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);

    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {

        if (preOrder == null || preOrder.length == 0) {
            return null;
        }

        Map<Integer, Integer> value2index = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            value2index.put(inOrder[i], i);
        }
        TreeNode root = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, value2index);

        return root;
    }

    public static TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> value2index) {


        if (preStart > preEnd ) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);


        if (preStart == preEnd) {
            return root;
        } else {
            int rootIndex = value2index.get(root.val);
            int leftNodes = rootIndex - inStart;
            int rightNodes = inEnd - rootIndex;

            //System.out.println(preStart+" "+preEnd);
            TreeNode leftSubTree = buildTree(preOrder, preStart + 1, preStart + leftNodes, inOrder, inStart, rootIndex - 1, value2index);
            TreeNode rightSubTree = buildTree(preOrder, preEnd - rightNodes + 1, preEnd, inOrder, rootIndex + 1, inEnd, value2index);


            root.left = leftSubTree;
            root.right = rightSubTree;
            return root;
        }


    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}