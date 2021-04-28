package com.github.yangli2004;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceParenthesis {
   public static void main(String[] args) {
      System.out.println(balanceString("()"));
      System.out.println(balanceString("a(b)c)"));
      System.out.println(balanceString(")("));
      System.out.println(balanceString("((((("));
      System.out.println(balanceString("()()("));
      System.out.println(balanceString(")(())("));
      System.out.println(balanceString(")())(()()("));

   }

   static String balanceString(String str) {
      Stack<Integer> stack = new Stack<>();
      List<Integer> idxToSkip = new ArrayList<>();
      for(int i=0; i<str.length(); i++) {
         char c = str.charAt(i);
         if(c=='(') {
            stack.push(i);
         } else if(c==')') {
            if(!stack.isEmpty() && str.charAt(stack.peek())=='(') {
               stack.pop();
            } else {
               idxToSkip.add(i);
            }
         }
      }
      idxToSkip.addAll(stack);
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<str.length(); i++) {
         if(!idxToSkip.contains(i)) {
            sb.append(str.charAt(i));
         }
      }

      return sb.toString();
   }
}
