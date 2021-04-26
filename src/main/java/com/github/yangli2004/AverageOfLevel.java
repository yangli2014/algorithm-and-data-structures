package com.github.yangli2004;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AverageOfLevel {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    Node createTree() {
        Node root = new Node(4);
        root.left = new Node(7);
        root.left.left = new Node(10);
        root.left.right = new Node(2);
        root.left.right.right = new Node(6);
        root.left.right.right.left = new Node(2);
        root.right = new Node(9);
        root.right.right = new Node(6);

        return root;
    }

    private static class NodeLevel {
        Node node;
        int level;

        public NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }


    int[] average(Node root) {
        Queue<NodeLevel> q = new LinkedList<>();
        q.add(new NodeLevel(root, 0));
        int[][] data = new int[5][];
        while(!q.isEmpty()) {
            NodeLevel nodeLevel = q.remove();
            int lvl = nodeLevel.level;
            if(data[lvl] !=null) {
                int [] arr = data[lvl];
                arr[0]++;
                arr[1] += nodeLevel.node.value;
            } else {
                data[lvl] = new int[]{1, nodeLevel.node.value};
            }
            if(nodeLevel.node.left != null) {
                q.add(new NodeLevel(nodeLevel.node.left, lvl + 1));
            }
            if(nodeLevel.node.right != null) {
                q.add(new NodeLevel(nodeLevel.node.right, lvl + 1));
            }
        }
        int[] result = new int[data.length];
        for(int i=0; i< data.length; i++) {
            int[] tmp = data[i];
            int average = tmp[1] / tmp[0];
            result[i] = average;
        }
        return result;
    }
    public static void main(String [] args) {
        AverageOfLevel app = new AverageOfLevel();
        Node root = app.createTree();
        System.out.println(Arrays.toString(app.average(root)));
    }
}
