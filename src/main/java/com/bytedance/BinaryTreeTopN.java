package com.bytedance;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTopN {

    /*
        给定一棵二叉搜索树，请找出其中第k大的节点。

 

        示例 1:

        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
        输出: 4
        示例 2:

        输入: root = [5,3,6,2,4,null,null,1], k = 3
               5
              / \
             3   6
            / \
           2   4
          /
         1
        输出: 4
         

        限制：

        1 ≤ k ≤ 二叉搜索树元素个数

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {
        // 1 2 3 4 5 6 7
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(30);
        TreeNode node4 = new TreeNode(40);
        TreeNode node5 = new TreeNode(50);
        TreeNode node6 = new TreeNode(60);
        TreeNode node7 = new TreeNode(70);

        node4.left = node2;
        node2.left = node1;
        node2.right = node3;
        node4.right = node6;
        node6.left = node5;
        node6.right = node7;

        System.out.println(binaryTreeTopNAsc(node4, 1));
    }


    public static int binaryTreeTopNAsc(TreeNode root, int k) {


        List<Integer> array = new ArrayList<>();
        binaryTreeTopN(root, array);

        return array.get(array.size() - k);
    }

    public static List<Integer> binaryTreeTopN (TreeNode node , List<Integer> array){
        if (node == null) {
            return array;
        }

        if (node.left != null ) {
            binaryTreeTopN(node.left, array);
        }


            array.add(node.value);


        if (node.right != null ) {
            binaryTreeTopN(node.right, array);
        }

        return array;
    }


    public static int binaryTreeTopN(TreeNode root, int k) {


        List<Integer> array = new ArrayList<>();
        binaryTreeTopN(root, k, array);

        return array.get(array.size() - 1);
    }

    public static List<Integer> binaryTreeTopN(TreeNode root, int k, List<Integer> array) {

        if (root == null) {
            return array;
        }

        if (root.right != null && array.size() < k) {
            binaryTreeTopN(root.right, k, array);
        }

        if (array.size() < k) {
            array.add(root.value);
        }



        if (root.left != null && array.size() < k) {
            binaryTreeTopN(root.left, k, array);
        }

        return array;
    }

}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}

