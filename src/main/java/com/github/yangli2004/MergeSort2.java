package com.github.yangli2004;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{33, 6, 21, 12, 19, 29, 38, 22, 14, 40, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        mergeSort(arr, arr.length);
    }

    static void mergeSort(int[] arr, int len) {
        if (len<2) {
            return ;
        }
        int mid = len / 2;
        int [] left = new int[mid];
        int [] right = new int[len -mid];
        for(int i=0; i<mid; i++) {
            left[i] = arr[i];
        }
        for(int i=0; i<len-mid; i++) {
            right[i] = arr[mid+i];
        }
        mergeSort(left, mid);
        mergeSort(right, len - mid);
        merge(arr, left, right, mid, len-mid);
    }

    static void merge(int[] arr, int[] left, int [] right, int l, int r) {
        int i=0, j=0, k=0;
        while (i<l && j<r) {
            if(left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while(i<l) {
            arr[k++] = left[i++];
        }
        while (j<r) {
            arr[k++] = right[j++];
        }
    }
}
