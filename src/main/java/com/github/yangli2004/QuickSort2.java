package com.github.yangli2004;

import java.util.Arrays;

public class QuickSort2 {

    static void quickSort(int[] arr, int low, int high) {
        if (high > low) {
            int idx = partitionInMid(arr, low, high);
            quickSort(arr, low, idx - 1);
            quickSort(arr, idx + 1, high);
        }
    }

    static int partitionAtEnd(int[] arr, int low, int high) {
        int p = arr[high];
        int i = low, j = high;
        while (j > i) {
            while (arr[i] < p) {
                i++;
            }
            while (j >= low && arr[j] >= p) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[high] = arr[i];
        arr[i] = p;
        return i;
    }

    static int partitionAtFirst(int[] arr, int low, int high) {
        int p = arr[low];
        int i = low, j = high;
        while (i < j) {
            while (i <= high && arr[i] <= p) {
                i++;
            }
            while (arr[j] > p) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        arr[low] = arr[j];
        arr[j] = p;
        return j;
    }

    static int partitionInMid(int[] arr, int low, int high) {
        int i = low, j = high;
        int p = arr[(low + high) / 2];
        while (i <= j) {
            while(arr[i] < p) {
                i++;
            }
            while (arr[j] > p) {
                j--;
            }
            if(i<=j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{7, 3, 11, 2, 9, 4};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }
}
