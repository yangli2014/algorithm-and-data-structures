package com.github.yangli2004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingTriangles {
    class Sides{
        int a;
        int b;
        int c;
        Sides(int a,int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    // Add any helper functions you may need here
    boolean isSame(Sides s1, Sides s2) {
        List<Integer> list1 = Arrays.asList(s1.a, s1.b, s1.c);
        List<Integer> list2 = Arrays.asList(s2.a, s2.b, s2.c);
        int indx = list1.indexOf(list2.get(0));
        for(int i=0; i<list2.size(); i++) {
            System.out.println("indx =" + indx);
            if(list2.get(i) != list1.get(indx)) {
                return false;
            }
            indx ++;
            if(indx > list1.size()-1) {
                indx=0;
            }
        }
        return true;
    }

    int countDistinctTriangles(ArrayList<Sides> arr) {
        // Write your code here
        int counter = arr.size();
        for(int i=0; i<arr.size(); i++) {
            for(int j=i+1; j<arr.size(); j++) {
                if(isSame(arr.get(i), arr.get(j))) {
                    counter -=2;
                }
            }
        }
        return counter;
    }













    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        int expected_1 = 3;
        int output_1 = countDistinctTriangles(arr_1);
        check(expected_1, output_1);

        ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        int expected_2 = 3;
        int output_2 = countDistinctTriangles(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new CountingTriangles().run();
    }
}
