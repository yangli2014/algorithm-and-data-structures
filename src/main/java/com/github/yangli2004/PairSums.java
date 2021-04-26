package com.github.yangli2004;

import java.util.HashMap;
import java.util.Map;

public class PairSums {
    static int numberOfWays(int[] arr, int k) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap();
        for (int v : arr) {
            if (map.get(v) == null) {
                map.put(v, 1);
            } else {
                map.put(v, map.get(v) + 1);
            }
        }
        int counter = 0;
        for (int v : arr) {
            if (map.get(k - v) != null) {
                counter += map.get(k - v);
            }
            if ((k - v) == v) {
                counter--;
            }
        }

        return counter / 2;

    }

    int numberOfWays2(int[] arr, int k) {
        // Write your code here
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 3, 3};
        System.out.println(numberOfWays(arr, 6));
    }
}
