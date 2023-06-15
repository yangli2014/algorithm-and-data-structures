package com.github.yangli2004.sort;

import java.util.Arrays;

public class MergeSortV3 {
    public static void main(String[] args) {
        int[] data = new int[]{33, 6, 21, 12, 19, 29, 38, 22, 14, 40, 3, 5};
        mergeSort(data, new int[data.length], 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }

    public static  void mergeSort(int[] arr, int[] temp, int low, int high) {
        if(low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high);
    }

    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for(int i = low; i<=high; i++) {
            temp[i] = arr[i];
        }

        int l = low, r = mid + 1, current = low;
        while(l <= mid && r <= high) {
            if(temp[l] <= temp[r]) {
                arr[current++] = temp[l++];
            } else {
                arr[current++] = temp[r++];
            }
        }

        int lefRemaining = mid - l;
        for(int i = 0; i<= lefRemaining; i++) {
            arr[current + i] = temp[l + i];
        }
    }
}
