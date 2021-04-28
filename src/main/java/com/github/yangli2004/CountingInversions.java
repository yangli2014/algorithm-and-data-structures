package com.github.yangli2004;

import java.util.Arrays;

public class CountingInversions {
   static int count;
   // Complete the countInversions function below.
   static long countInversions(int[] arr) {
      arr = mergeSort(arr);
      System.out.println(Arrays.toString(arr));
      return count;
   }
   static int[] mergeSort(int [] arr){
      if(arr.length==1) {
         return arr;
      }
      int mid = (arr.length - 1) / 2;
      int [] left = Arrays.copyOfRange(arr, 0, mid + 1);
      int [] right = Arrays.copyOfRange(arr, mid+1, arr.length);
      mergeSort(left);
      mergeSort(right);

      return merge(left, right);
   }

   static int [] merge(int[] left, int[] right) {
      int [] tmp = new int[left.length + right.length];
      int i=0, j=0, k=0;
      while (i<left.length && j<right.length) {
         if(left[i] <= right[j]) {
            tmp[k++] = left[i++];
         } else {
            tmp[k++] = right[j++];

            count += left.length - i;
         }
      }
      while(i<left.length) {
         tmp[k++] = left[i++];
      }
      while(j<left.length) {
         tmp[k++] = right[j++];
      }

      return tmp;
   }

   public static void main(String[] args) {
      System.out.println(countInversions(new int[] {7, 2, 5, 1 ,3, 1}));
   }
}
