package com.github.yangli2004;

import com.github.yangli2004.data.LinkedList;
import com.github.yangli2004.data.LinkedListNode;

public class IntersectionTwoLinkedLists {
    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        //TODO: Write - Your - Code
        int len1 = countNodes(head1);
        int len2 = countNodes(head2);
        int d = Math.abs(len1-len2);
        if(d > 0) {
            if(len1>len2) {
                head1 = moveSteps(head1, d);
            } else {
                head2 = moveSteps(head2, d);
            }
        }
        while(head1!=null) {
            if(head1 == head2) {
                break;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    static LinkedListNode moveSteps(LinkedListNode node, int d) {
        while(d>0) {
            node = node.next;
            d--;
        }
        return node;
    }
    static int countNodes(LinkedListNode head) {
        int count = 0;
        while(head!=null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] a1 = {13,4};
        int [] a2 = {29, 23, 82, 11};
        LinkedListNode list_head_1 = LinkedList.createLinkedList(a1);
        LinkedListNode list_head_2 = LinkedList.createLinkedList(a2);
        LinkedListNode node1 = new LinkedListNode(12);
        LinkedListNode node2 = new LinkedListNode(27);

        LinkedList.insertAtTail(list_head_1, node1);
        LinkedList.insertAtTail(list_head_1, node2);

        LinkedList.insertAtTail(list_head_2, node1);

        System.out.print("List 1: ");
        LinkedList.display(list_head_1);
        System.out.print("List 2: ");
        LinkedList.display(list_head_2);

        LinkedListNode intersect_node = intersect(list_head_1, list_head_2);
        System.out.println(String.format("Intersect at %d", intersect_node.data));
    }
}
