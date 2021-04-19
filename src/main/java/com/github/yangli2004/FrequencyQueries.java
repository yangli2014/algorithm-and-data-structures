package com.github.yangli2004;

import java.util.*;

//HackerRank Dictionary and Hashmap
public class FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int maxFreq = 0;
        for (List<Integer> q : queries) {
            int operation = q.get(0);
            int data = q.get(1);
            int count = map.get(data) == null? 0: map.get(data);
            if (operation == 1) {
                map.put(data, ++count);
                maxFreq = Math.max(maxFreq, count);
            } else if (operation == 2) {
                if (count>0) {
                    map.put(data, --count);
                }
            } else {
                if(data <= maxFreq && map.containsValue(data)) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> q = new ArrayList<>();
        q.add(Arrays.asList(3, 4));
        q.add(Arrays.asList(2, 1003));
        q.add(Arrays.asList(1, 16));
        q.add(Arrays.asList(3, 1));
        /*q.add(Arrays.asList(1, 10));
        q.add(Arrays.asList(1, 6));
        q.add(Arrays.asList(2, 5));
        q.add(Arrays.asList(3, 2));*/

        List<Integer> res = freqQuery(q);
        res.forEach(i->System.out.println(i));
    }
}
