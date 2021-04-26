package com.github.yangli2004;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*System.out.println("hello");
        System.out.println("326 is "+isColorful(326));
        System.out.println("3245 is "+isColorful(3245));*/
        //int[] data = new int[]{6, 2, 10, 8, 5, 7, 3, 4};
       /* System.out.println(Arrays.toString(data));
        mergeSort2(data);
        System.out.println(Arrays.toString(data));*/
        //insertSort(data);
        //int [] data = new int[] {10, 7, 8, 9, 1, 5};
        //quickSort(data, 0, data.length - 1);
        //System.out.println(Arrays.toString(data));
        //quickSortWithList(Arrays.asList(5, 8, 1, 3, 7, 9, 2));
        /*HeapImp hp = new HeapImp();
        hp.insert(4);
        hp.insert(9);
        System.out.println(hp.peek());
        hp.poll();
        System.out.println(hp.peek());*/
        /*int [][] edges = new int[10][2];
        System.out.println(Arrays.toString(bfs(70, 1988, edges, 16)));*/
        int[][] ladders = {{3,54},{37, 100}};
        int [][] snakes = {{56, 33}};
        System.out.println(quickestWayUp(ladders, snakes));
    }

    static Map<Integer, Integer> prepareData(int[][] ladders, int[][] snakes) {
        Map<Integer, Integer> map = new HashMap<>();
        //IntStream.range(1, 101).forEach(i->map.put(i, 0));
        for(int[] ladder: ladders) {
            map.put(ladder[0], ladder[1]);
        }
        for (int[] snake: snakes) {
            map.put(snake[0], snake[1]);
        }
        map.forEach((k, v) ->System.out.println(k + "->" +v));
        return map;
    }

    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        Map<Integer, Integer> graph = new HashMap<>();
        for(int[] ladder: ladders) {
            graph.put(ladder[0], ladder[1]);
        }
        for (int[] snake: snakes) {
            graph.put(snake[0], snake[1]);
        }
        int start =1;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,Integer> visited = new HashMap<>();
        visited.put(start, 0);
        q.add(start);
        int result = -1;
        while(!q.isEmpty()) {
            int stp = q.remove();
            if (stp==100) {
                return visited.get(stp);
            }
            for(int i= 1; i<=6; i++) {
                int next = i + stp;
                if(graph.keySet().contains(next)) {
                    next = graph.get(next);
                }
                if(visited.get(next) == null) {
                    visited.put(next, visited.get(stp) + 1);
                    q.add(next);
                } else if(visited.get(stp) + 1 < visited.get(next)) {
                    visited.put(next, visited.get(stp) + 1);
                }
            }
        }
        return result;
    }

    static int[] bfs(int n, int m, int[][] edges, int s) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> relationMap = new HashMap<>();

        q.add(s);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(s, 0);
        while(!q.isEmpty()) {
            int val = q.remove();
            if(!visited.contains(val)) {
                visited.add(val);
                res[val-1] = map.get(val);
                for(int[] edg: edges){
                    if(edg[0] == val || edg[1] == val) {
                        int tmp = edg[0] == val? edg[1]:edg[0];
                        int dist = map.get(val);
                        q.add(tmp);
                        if(!map.keySet().contains(tmp)) {
                            map.put(tmp, dist + 6);
                        }
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<res.length; i++) {
            if(i!=(s-1)) {
                list.add(res[i]);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }




    static List<Integer> quickSortWithList(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> fullList = new ArrayList<>();
        int pv = list.get(0);
        list.stream().forEach(v -> {
            if (v < pv) {
                left.add(v);
            } else if (v > pv) {
                right.add(v);
            }
        });
        fullList.addAll(quickSortWithList(left));
        fullList.add(pv);
        fullList.addAll(quickSortWithList(right));
        String str = Arrays.toString(fullList.toArray());
        System.out.println(str);
        return fullList;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void printList(int[] arr) {
        for (int v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static int partition(int[] arr, int left, int right) {
        int p = arr[left];
        while (left <= right) {
            while (arr[left] < p) {
                left++;
            }
            while (arr[right] > p) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pi = partition(arr, left, right);
        quickSort(arr, left, pi - 1);
        quickSort(arr, pi, right);


    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int v = arr[i];
            while (j >= 0 && arr[j] > v) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
            Arrays.stream(arr).forEach(item -> System.out.print(item + " "));
            System.out.println();
        }
    }

    private static boolean isColorful(int num) {
        int[] digits = getDigits(num);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (set.contains(digits[i])) {
                return false;
            } else {
                set.add(digits[i]);
            }
            for (int j = i + 1; j < digits.length; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= digits[k];
                }
                if (set.contains(product)) {
                    return false;
                } else {
                    set.add(product);
                }
            }
        }
        return true;
    }

    private static int[] getDigits(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void mergeSort2(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort2(left);
            mergeSort2(right);
            int l = 0;
            int r = 0;
            int i = 0;
            while (l < left.length && r < right.length) {
                if (left[l] <= right[r]) {
                    arr[i] = left[l];
                    l++;
                } else {
                    arr[i] = right[r];
                    r++;
                }
                i++;
            }
            while (l < left.length) {
                arr[i] = left[l];
                i++;
                l++;
            }

            while (r < right.length) {
                arr[i] = right[r];
                i++;
                r++;
            }
        }
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        mergeHalves(arr, temp, left, right);
    }

    private static void mergeHalves(int[] arr, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart, right = rightStart, index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                tmp[index] = arr[left];
                left++;
            } else {
                tmp[index] = arr[right];
                right++;
            }
            index++;
        }
        System.arraycopy(arr, left, tmp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, tmp, index, rightEnd - right + 1);
        System.arraycopy(tmp, leftStart, arr, leftStart, size);

    }

    private static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = Arrays.copyOfRange(arr, l, m + 1);
        int R[] = Arrays.copyOfRange(arr, m + 1, r + 1);


        /*Copy data to temp arrays*/
       /*for (int i = l; i <=m; ++i)
            L[i] = arr[i];
        for (int j = m+1; j < r; ++j)
            R[j] = arr[j];*/

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static class HeapImp {
        int length = 10;
        int size = 0;
        int [] items = new int[length];
        public int peek() {
            return items[0];
        }

        public void insert(int val) {
            items[size] = val;
            size++;
            moveUp();
        }

        public int poll() {
            int val = items[0];
            items[0] = items[size-1];
            size--;
            moveDown();
            return val;
        }

        private void moveUp() {
            int i = size  - 1;
            while (hasParent(i) && items[getParentIndex(i)] > items[i]) {
                swap(getParentIndex(i), i);
                i = getParentIndex(i);
            }
        }

        private boolean hasParent(int idx) {
            return getParentIndex(idx) >=0;
        }

        private boolean hasLeft(int idx) {
            return getLeftChldIndex(idx) < size;
        }

        private boolean hasRight(int idx) {
            return getRightChldIndex(idx) < size;
        }

        private void moveDown() {
            System.out.println(Arrays.toString(items));
            int i = 0;
            while (hasLeft(i)) {
                int smallerIdx = getLeftChldIndex(i);
                if(hasRight(i) && items[getRightChldIndex(i)] < items[getLeftChldIndex(i)]){                smallerIdx = getRightChldIndex(i);
                }
                if(items[i] < items[smallerIdx]) {
                    break;
                } else {
                    swap(i, smallerIdx);
                }
                i = smallerIdx;
            }
            System.out.println(Arrays.toString(items));
        }

        private int getParentIndex(int index) {
            return (index - 1) /2;
        }

        private int getLeftChldIndex(int index) {
            return (index * 2) + 1;
        }

        private int getRightChldIndex(int idx) {
            return (idx*2) + 2;
        }


        private void swap(int l, int r) {
            int tmp = items[l];
            items[l] = items[r];
            items[r] = tmp;
        }
    }


}
