package com.github.yangli2004;

import java.util.Arrays;

public class QuickSort {
   public static void main(String[] args) {
      int [] arr = new int[] {3, 7, 2, 9, 4};
      quickSortRec(arr, 0, arr.length-1);
      System.out.println(Arrays.toString(arr));
   }

   static int partition(int[] arr, int low, int high) {
      System.out.println(Arrays.toString(Arrays.copyOfRange(arr, low, high +1)));
      int pivotValue = arr[low];
      int i = low;
      int j = high;

      while (i < j) {
         while (i <= high && arr[i] <= pivotValue) i++;
         while (arr[j] > pivotValue) j--;

         if (i < j) {
            // swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
         }
      }

      arr[low] = arr[j];
      arr[j] = pivotValue;

      // return the pivot index
      return j;
   }

   static int partitionAtEnd(int[] arr, int low, int high) {
      System.out.println(Arrays.toString(Arrays.copyOfRange(arr, low, high +1)));
      int p = arr[high];
      int i = low, j = high;
      while (j>i) {
         while (j>=low && arr[j] >= p) {
            j--;
         }
         while (arr[i]<p) {
            i++;
         }
         if(i<j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
         }
      }
      arr[high] = arr[i];
      arr[i] = p;
      return i;
   }

   static void quickSortRec(int[] arr, int low, int high) {
      if (high > low) {
         int pivotIndex = partitionAtEnd(arr, low, high);

         quickSortRec(arr, low, pivotIndex - 1);
         quickSortRec(arr, pivotIndex + 1, high);
      }
   }
}
