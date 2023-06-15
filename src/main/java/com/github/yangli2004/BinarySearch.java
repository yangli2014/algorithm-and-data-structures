package com.github.yangli2004;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binSearch(new int[]{1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100}, 12));
    }

    static int binSearch(int[] a, int key) {
        //TODO: Write - Your - Code
        int start = 0;
        int end = a.length -1;
        while(start <= end) {
            int mid = (end + start) / 2;
            if(a[mid]==key) {
                return mid;
            }
            if(key>a[mid]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }
}
