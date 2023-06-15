package com.github.yangli2004.sort;

import java.util.Arrays;

public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{33, 6, 21, 12, 19, 29, 38, 22, 14, 40, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return ;
        }
        int mid = arr.length / 2;
        int [] left = new int[mid];
        int [] right = new int[arr.length -mid];
        for(int i=0; i<mid; i++) {
            left[i] = arr[i];
        }
        for(int i=0; i<arr.length-mid; i++) {
            right[i] = arr[mid+i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    static void merge(int[] arr, int[] left, int [] right) {
        int r=0, l=0, a=0;
        while (l<left.length && r<right.length) {
            if(left[l] <= right[r]) {
                arr[a++] = left[l++];
            } else {
                arr[a++] = right[r++];
            }
        }
        while(l<left.length) {
            arr[a++] = left[l++];
        }
        while (r<right.length) {
            arr[a++] = right[r++];
        }
    }
}
