package com.interview.wirtecode;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode("A");
        TreeNode node2 = new TreeNode("B");
        TreeNode node3 = new TreeNode("C");
        TreeNode node4 = new TreeNode("D");
        TreeNode node5 = new TreeNode("E");
        TreeNode node6 = new TreeNode("F");

        BinaryTree tree = new BinaryTree(node1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        System.out.println("前序遍历");
        tree.preOrder();
        System.out.println("中序遍历");
        tree.infixOrder();
        System.out.println("后序遍历");
        tree.postOrder();


        System.out.println(tree.preOrderSearch("A"));
        System.out.println(tree.infixOrderSearch("A"));
        System.out.println(tree.postOrderSearch("A"));

        System.out.println(tree.deleteNode("C"));
        System.out.println(tree.deleteNode("a"));

        tree.preOrder();
    }
}

class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    //前序遍历
    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }

        root.preOrder();
        System.out.println();
    }

    //中序遍历
    public void infixOrder() {

        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        root.infixOrder();
        System.out.println();

    }


    //后序遍历
    public void postOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }

        root.postOrder();
        System.out.println();
    }

    //前序遍历
    public boolean preOrderSearch(String value) {
        if (root == null) {
            System.out.println("二叉树为空");
            return false;
        }

        return root.preOrderSearch(value);
    }

    //前序遍历
    public boolean infixOrderSearch(String value) {
        if (root == null) {
            System.out.println("二叉树为空");
            return false;
        }

        return root.infixOrderSearch(value);
    }

    //前序遍历
    public boolean postOrderSearch(String value) {
        if (root == null) {
            System.out.println("二叉树为空");
            return false;
        }

        return root.postOrderSearch(value);
    }

    //删除
    public boolean deleteNode(String value) {
        boolean isDelete = false;

        if (root == null) {
            System.out.println("二叉树为空");
            return isDelete;
        }

        if (root.data.equals(value)) {
            root = null;
            return true;
        }

        isDelete = root.deleteNode(value);

        return isDelete;
    }

}

class TreeNode {
    public String data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(String data) {
        this.data = data;
    }

    //前序遍历
    public void preOrder() {
        System.out.print(this.data + " ");

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {


        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(this.data + " ");

        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {


        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.print(this.data + " ");
    }


    //前序遍历查找
    public boolean preOrderSearch(String value) {

        if (this.data.equals(value)) {
            return true;
        } else if (this.left != null && this.left.preOrderSearch(value)) {
            return true;
        } else if (this.right != null && this.right.preOrderSearch(value)) {
            return true;
        } else {
            return false;
        }
    }

    //中序遍历查找
    public boolean infixOrderSearch(String value) {


        if (this.left != null && this.left.preOrderSearch(value)) {
            return true;
        } else if (this.data.equals(value)) {
            return true;
        } else if (this.right != null && this.right.preOrderSearch(value)) {
            return true;
        } else {
            return false;
        }
    }

    //后序遍历查找
    public boolean postOrderSearch(String value) {


        if (this.left != null && this.left.preOrderSearch(value)) {
            return true;
        } else if (this.right != null && this.right.preOrderSearch(value)) {
            return true;
        } else if (this.data.equals(value)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteNode(String value) {
        boolean isDelete = false;

        if (this.left != null && this.left.data.equals(value)) {
            this.left = null;
            isDelete = true;
        }

        if (!isDelete && this.right != null && this.right.data.equals(value)) {
            this.right = null;
            isDelete = true;
        }

        if (!isDelete && this.left != null) {
            isDelete = this.left.deleteNode(value);
        }

        if (!isDelete && this.right != null) {
            isDelete = this.right.deleteNode(value);
        }

        return isDelete;
    }

}
