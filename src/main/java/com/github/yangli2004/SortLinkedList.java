package com.github.yangli2004;

public class SortLinkedList {
    static LinkedListNode insertToSorted(LinkedListNode sorted, LinkedListNode node) {
        if(node == null) {
            return sorted;
        }
        if(sorted == null || node.data<=sorted.data) {
            node.next = sorted;
            return node;
        }
        LinkedListNode curr = sorted;
        while(curr.next != null && (curr.next.data < node.data)) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return sorted;
    }
    public static LinkedListNode insertionSort(LinkedListNode head) {
        //TODO: Write - Your - Code
        LinkedListNode sorted = null;
        LinkedListNode curr = head;
        while (curr!= null) {
            LinkedListNode temp = curr.next;
            sorted = insertToSorted(sorted, curr);
            printNode(sorted);
            curr = temp;

        }
        return sorted;
    }

    static void printNode(LinkedListNode node) {
        LinkedListNode curr = node;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public  static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(29);
        head.next = new LinkedListNode(23);
        head.next.next= new LinkedListNode(82);
        head.next.next.next= new LinkedListNode(11);
        printNode(head);
        insertionSort(head);
    }
}
