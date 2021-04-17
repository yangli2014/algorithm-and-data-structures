package com.github.yangli2004;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DataStructure {
   public static void main(String[] args) {
      /*ListNode root1 = new ListNode(2, new ListNode(4, new ListNode(3)));
      ListNode root2 = new ListNode(5, new ListNode(6, new ListNode(4)));
      printList(root1, "l1");
      printList(root2,"l2");
      printList(solution(root1, root2), "result");*/
      //removeDuplicate(new int[] {1,1,2});
      //removeDuplicate(new int[] {2,2,3,3,4});
      //System.out.println(lengthOfLongestSubstring("abcdeabss"));
      long start = System.currentTimeMillis();
      String [] arr = new String[] {"{(([])[])[]}","{(([])[])[]]}","{(([])[])[]}[]"};
      for (String s : arr){
         System.out.println(isBalanced2(s));
      }
      long end = System.currentTimeMillis();
      System.out.println(end - start);

   }

   public static String isBalanced2(String s) {
      int n = 0;
      while (s.length() != n) {
         n = s.length();
         s = s.replace("()", "");
         s = s.replace("[]", "");
         s = s.replace("{}", "");
      }
      if(s.isEmpty()) {
         return "YES";
      }
      return "NO";
   }

   public static String isBalanced(String s){
      Stack<Character> st = new Stack();
      String result = "YES";
      for(int i=0; i<s.length(); i++) {
         char c = s.charAt(i);
         if(c=='{'||c=='['||c=='(') {
            st.push(c);
         } else if (!st.isEmpty()){
            char poped = st.pop();
            if((poped != '{' && c=='}') || (poped !='[' && c==']')
                  || (poped !='(' && c ==')')) {
               return "NO";

            }
         } else {
            return "NO";

         }
      }
      result = st.isEmpty() ? "YES" : "NO";
      return result;
   }

   public static ListNode solution(ListNode l1, ListNode l2) {
      ListNode result = null;
      ListNode first = l1, second = l2;
      int tmp = 0;
      while (first != null) {
         int value = first.val + second.val + tmp;
         tmp = value / 10;
         value = value % 10;
         if(result == null) {
            result = new ListNode(value);
         } else {
            ListNode current = result;
            while (current.next != null) {
               current = current.next;
            }
            current.next = new ListNode(value);

         }
         first = first.next;
         second = second.next;
      }
      return result;
   }

   public static void printList(ListNode node, String msg) {
      ListNode current = node;
      System.out.print(msg + " ");
      while(current != null) {
         System.out.print(current.val + " ");
         current = current.next;
      }
      System.out.println();
   }

   public static class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
         this.val = val;
      }

      ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
      }
   }

   private static int removeDuplicate(int[] nums) {
      if(nums.length == 0) {
         return 0;
      }
      List<Integer> list = new ArrayList<>();
      for(int i:nums) {
         if(!list.contains(i)){
            list.add(i);
         }
      }
      list.stream().forEach(i -> System.out.println(i));
      nums = list.stream().mapToInt(i->i).toArray();
      return nums.length;
   }
   public static int lengthOfLongestSubstring(String s) {
      int l=0, r=0, count =0;
      Set<Character> set = new HashSet<>();
      while(r < s.length()) {
         char c= s.charAt(r++);
         if(!set.add(c)) {
            while(s.charAt(l) != c) {
               set.remove(s.charAt(l++));
            }
            l++;
         }

         count = Math.max(count, set.size());

      }

      return count;
   }
}
