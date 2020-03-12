package com.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeLevelOrder {

    /*
        从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

        例如:
        给定二叉树: [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        返回：

        [3,9,20,15,7]
         

        提示：

        节点总数 <= 1000

     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        int[] ints = levelOrder(root);

        System.out.println(Arrays.toString(ints));

    }

    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<TreeNode> list = new ArrayList<>();

        list.add(root);

        int startIndex = 0;
        int endIndex = 0;
        int len = 1;

        TreeNode currentNode;

        boolean flag = true;
        while (flag) {

            startIndex = endIndex;
            endIndex = endIndex + len;

            len = 0;
            flag = false;

            for (int i = startIndex; i < endIndex; i++) {
                currentNode = list.get(i);
                if (currentNode.left != null) {
                    list.add(currentNode.left);
                    len++;
                    flag = true;
                }

                if (currentNode.right != null) {
                    list.add(currentNode.right);
                    len++;
                    flag = true;
                }

            }
        }

        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i).val;
        }

        return array;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

}
