package com.github.yangli2004;

public class Algorithm {
   public static void main(String[] args) {
      //BinarySearchWithRecursive();
      //System.out.println(twoArrays(new int[]{1,2,3,7}, new int[]{ 4,5,6}));

      //System.out.println(longestPalindrome("babad"));
      knasack();
   }

   private static void BinarySearchWithLoop() {
      int arr[] = { 2, 3, 4, 5, 7, 10, 40 };
      int x = 4;
      int i = -1;
      int l = 0, r = arr.length - 1;
      while (l <= r) {
         int m = l + (r-l) / 2;
         if(arr[m] == x) {
            i = m;
            break;
         }
         if(arr[m] < x) {
            l = m + 1;
         } else {
            r = m-1;
         }
      }
      System.out.println(i);
      if( i > 0 && i < arr.length  )
         System.out.println(arr[i]);
   }

   private static void BinarySearchWithRecursive() {
      int arr[] = { 2, 3, 4, 5, 7, 10, 40 };
      int x = 4;
      System.out.println(SearchRecursive(arr, 0, arr.length-1, x));
   }

   private static int SearchRecursive(int[] arr, int l, int r, int x) {
      if(r >= l) {
         int m = l + (r - l) / 2;
         if (arr[m] == x) {
            return m;
         }
         if (arr[m] < x) {
            return SearchRecursive(arr, m + 1, r, x);
         }

         return SearchRecursive(arr, l, m - 1, x);
      }
      return -1;
   }

   private static double twoArrays(int [] nums1, int [] nums2){
      int totalNums = nums1.length + nums2.length;
      boolean isOdd = totalNums % 2 == 0 ? false : true;
      boolean isFound = false;
      int cur = 0;
      int last = 0;
      int target = totalNums / 2;
      int index = 0;
      int index1 = 0;
      int index2 = 0;
      while(true){
         while(index1 < nums1.length && index2 < nums2.length){
            last = cur;
            cur = nums1[index1] > nums2[index2] ? nums2[index2++]: nums1[index1++];
            index++;
            if(index == target + 1) {
               isFound = true;
               break;
            }
         }
         while(!isFound && index1 < nums1.length){
            last = cur;
            cur = nums1[index1++];
            index++;
            if(index == target + 1) {
               isFound = true;
               break;
            }
         }
         while(!isFound && index2 < nums2.length){
            last = cur;
            cur = nums2[index2++];
            index++;
            if(index == target + 1) {
               isFound = true;
               break;
            }
         }

         if(isOdd) return cur;
         else return (double)(cur + last)/2;
      }

   }

   private static String longestPalindrome(String s) {
      int len = s.length();
      if(len <=0) return s;

      boolean[][] dp = new boolean[len][len];

      int x = 0;
      int y = 0;

      for(int g=0;g < len ; g++) {
         for(int i=0, j= g; j < len ; i++, j++ ) {
            if(g==0) {
               dp[i][j] = true;
            } else if (g==1) {
               dp[i][j] =  (s.charAt(i) == s.charAt(j));
            } else {
               dp[i][j] =  (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
            }

            if(dp[i][j] && j-i > y-x) {
               x=i;
               y=j;

            }
         }
      }
      return s.substring(x,y+1);


   }


   public static void knasack() {
      Item [] items = new Item[] {new Item(1, 6), new Item(2, 10), new Item(3, 12)};
      int maxW = 5, maxV =0;
      for(int i =0; i< items.length; i ++) {

      }

   }




   private static class Item {
      int weight;
      int value;

      public Item(final int weight, final int value) {
         this.weight = weight;
         this.value = value;
      }
   }







}
