package com.leetcode.offer;

public class LinkedListDeleteNode {


    /*
        给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

        返回删除后的链表的头节点。

        注意：此题对比原题有改动

        示例 1:

        输入: head = [4,5,1,9], val = 5
        输出: [4,1,9]
        解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
        示例 2:

        输入: head = [4,5,1,9], val = 1
        输出: [4,5,9]
        解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = deleteNode(node1, 5);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();


    }


    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode tmp = head;

        boolean flag = false;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }

        if (flag) {
            tmp.next = tmp.next.next;
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


