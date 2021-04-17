package com.github.yangli2004;

public class LeastCommonNumber {
   public static void main(String[] args) {
      int[] a1 = new int[] {1, 5, 6, 7, 17, 20};
      int[] a2 = new int[] {3, 4, 7, 9, 12, 16, 50};
      int[] a3 = new int[] {5, 6, 7, 10, 16, 25};
      System.out.println(findLeastCommonNumber(a1, a2, a3));
   }
   static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
      //TODO: Write - Your - Code
      for(int i =0; i< arr1.length; i++) {
         int val = arr1[i];
         if(binarySearch(arr2, val, 0, arr2.length-1)>=0 && binarySearch(arr3, val, 0, arr3.length-1)>=0) {
            return val;
         }
      }
      return -1;
   }
   static int binarySearch(int arr[], int key, int l, int r) {
      if(l>r) {
         return -1;
      }

      int mid = l + (r-l) / 2;
      if(arr[mid] == key) {
         return mid;
      } else if(arr[mid] > key) {
         return binarySearch(arr, key, l, mid-1);
      } else {
         return binarySearch(arr, key, mid + 1, r);
      }
   }


}
