package com.github.yangli2004;

public class BinarySearchRotatedArray {
    public static void main(String[] args) {
        int [] data = new int[] {5, 6, 7, 1, 2, 3, 4};
        System.out.println(search(data, 0, data.length - 1, 6));
        System.out.println(search(data, 6));

    }

    static int search(int [] arr, int start, int end, int key) {
        if(start > end) {
            return - 1;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == key) {
            return mid;
        }

        if(arr[start]<=arr[mid] && key<arr[mid]&& key>=arr[start]) {
            return search(arr, start, mid-1, key);
        } else if(key>arr[mid] && arr[mid] <= arr[end] && key <= arr[end]) {
            return search(arr, mid  + 1, end, key);
        } else if (arr[end] <= arr[mid]) {
            return search(arr, mid+1, end, key);
        } else if (arr[start]>=arr[mid]) {
            return search(arr, start, mid-1, key);
        }

        return -1;
    }

    static int search(int[] arr, int key) {
        int start =0 , mid = 0, end = arr.length -1;
        while (start <= end) {
            mid = (start + end ) / 2;
            if(arr[mid] == key) {
                return mid;
            }
            if(key<arr[mid] && arr[start] <= arr[mid] && key>=arr[start]) {
                end = mid -1;
            } else if (key>arr[mid] && arr[mid] <= arr[end] && key <=arr[end]) {
                start = mid + 1;
            } else if(arr[end]<=arr[mid]) {
                start = mid + 1;
            } else if (arr[start]>=mid) {
                end = mid -1;
            }
        }
        return -1;
    }
}
