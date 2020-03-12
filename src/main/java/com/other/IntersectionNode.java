package com.other;

public class IntersectionNode {
    /*

        天壤智能 面试题。

        编写一个程序，找到两个单链表相交的起始节点。
        输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
        输出：Reference of the node with value = 2
        输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。

     */

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        boolean flagA = false;
        boolean flagB = false;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == null) {
                if (flagA) {
                    break;
                }
                flagA = true;
                p1 = headB;
            }

            if (p2 == null) {
                if (flagB) {
                    p1 = null;
                    break;
                }
                flagB = true;
                p2 = headA;
            }
        }


        return p1;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}