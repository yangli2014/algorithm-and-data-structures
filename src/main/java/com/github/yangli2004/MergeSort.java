package com.github.yangli2004;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, tmp, start, mid);
        mergeSort(arr, tmp, mid + 1, end);
        merge(arr, tmp, start, end);
    }

    static void merge(int[] arr, int[] temp, int start, int end) {
        int mid = (start + end) / 2;
        int l = start, r = mid + 1, k = start;
        int size = end - start + 1;

        while (l <= mid || r <= end) {
            if (l > mid) {
                temp[k++] = arr[r++];
            } else if (r > end) {
                temp[k++] = arr[l++];
            } else if (arr[l] <= arr[r]) {
                temp[k++] = arr[l++];
            } else {
                temp[k++] = arr[r++];
            }
        }

        System.arraycopy(temp, start, arr, start, size);
    }

    public static void main(String[] args) {
        int [] data = new int[] {3, 7, 11, 2, 9, 4};
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

}
