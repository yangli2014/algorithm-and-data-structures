package com.github.yangli2004;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

//find the smallest in the sorted and roted array
public class BinarySearchFindSmallest {
    public static void main(String[] args) {
        int[] data = new int[]{6, 1, 2, 3, 4, 5};
        System.out.println(findSmallest(data, 0, data.length - 1));
        System.out.println(binarySearch(data, 0, data.length - 1));
    }

    static int findSmallest(int[] arr, int start, int end) {
        if (start >= end) {
            return arr[start];
        }
        int mid = (start + end) / 2;

        if (mid - 1 >= 0 && mid + 1 < arr.length - 1) {
            if (arr[mid] <= arr[mid - 1] && arr[mid] <= arr[mid + 1]) {
                return arr[mid];
            }
        }

        if (arr[start] > arr[mid]) {
            return findSmallest(arr, start, mid);
        } else if (arr[mid] > arr[end]) {
            return findSmallest(arr, mid + 1, end);
        } else {
            return Math.min(findSmallest(arr, start, mid), findSmallest(arr, mid + 1, end));
        }

        /*if(arr[start] > arr[end]) {
            return findSmallest(arr, mid, end);
        }else {
            return findSmallest(arr, start, mid);
        }*/
    }

    static int binarySearch(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        if (start + 1 == end) {
            return Math.min(arr[start], arr[end]);
        }
        int mid = (start + end) / 2;
        if (arr[start] < arr[mid]) {
            return Math.min(arr[start], binarySearch(arr, mid + 1, end));
        }
        if (arr[start] == arr[mid]) {
            int minLHS = binarySearch(arr, start, mid);
            if (minLHS < arr[mid]) {
                return minLHS;
            }
            return Math.min(minLHS, binarySearch(arr, mid + 1, end));
        }

        return binarySearch(arr, start, mid);
    }

    static int findMin(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] < arr[j]) {
                return arr[i];
            }
            if (arr[j] < arr[j - 1]) {
                return arr[j];
            }
            ++i;
            --j;
        }
        return arr[j];
    }

    @Test
    public void test() {
        assertEquals(0, findMin(new int[]{6, 7, 0, 1, 2}));
        assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1}));
        assertEquals(1, findMin(new int[]{4, 4, 4, 4, 1}));
        assertEquals(1, findMin(new int[]{1, 4, 4, 4, 4}));
        assertEquals(1, findMin(new int[]{10, 1, 10, 10, 10}));
        assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 4}));
        assertEquals(0, findMin(new int[]{0, 1, 4, 4, 5, 6, 7}));
        assertEquals(1, findMin(new int[]{1, 3, 5}));
        assertEquals(0, findMin(new int[]{2, 2, 2, 0, 1}));
    }


}
