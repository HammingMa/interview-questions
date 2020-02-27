package com.mzh.leetcode.offer;

import java.util.Arrays;
import java.util.Stack;

public class ReversePrint {

    /*
        输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

 

        示例 1：

        输入：head = [1,3,2]
        输出：[2,3,1]
         

        限制：

        0 <= 链表长度 <= 10000
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;

        System.out.println(Arrays.toString(reversePrint(node1)));
    }

    public static int[] reversePrint(ListNode head) {
        int[] ints = {};
        if (head == null) {
            return ints;
        }

        int size = 0;
        ListNode tmpNode = head;
        Stack<ListNode> stack = new Stack<>();
        while (tmpNode != null) {
            stack.push(tmpNode);
            tmpNode = tmpNode.next;
            size++;
        }

        ints = new int[size];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop().val;
        }

        return ints;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
