package com.github.yangli2004;

import java.util.*;

public class MinOperation {
    public static void main(String [] args) {
        MinOperation mo = new MinOperation();
        System.out.println(mo.minOperations(new int[]{3, 1, 2}));
        //mo.reverse(new int[] {1,2,3,4,5,6, 7}, 1, 4);
    }

    private int[] reverse(int[] arr, int start, int end) {
        for (int x = 0; x <= (end - start)/2; x++) {
            int temp = arr[start + x];
            arr[start + x] = arr[end - x];
            arr[end - x] = temp;
        }
        //System.out.println(Arrays.toString(arr));
        return arr;
    }

    private boolean isSorted(int[] arr) {
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] != x + 1) {
                return false;
            }
        }
        return true;
    }

    class Item {
        int[] a;
        int c;
        public Item(int[] a, int c) {
            this.a = a;
            this.c = c;
        }
    }

    Set<String> visited = new HashSet<>();

    int minOperations(int[] arr) {
        if (arr == null || arr.length <= 1 || isSorted(arr)) return 0;

        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(arr, 0));

        while (!queue.isEmpty()) {
            Item item = queue.poll();
            String s = Arrays.toString(item.a);
            if (visited.contains(s)) {
                continue;
            }
            visited.add(s);

            for (int x = 0; x < item.a.length; x++) {
                for (int y = x + 1; y < item.a.length; y++) {
                    int[] n = reverse(Arrays.copyOf(item.a, item.a.length), x, y);
                    if (isSorted(n)) {
                        System.out.println(Arrays.toString(item.a));
                        return item.c + 1;
                    }
                    queue.add(new Item(n, item.c + 1));
                }
            }
        }
        return -1;// Should never reach here for a valid input.
    }
}
