package com.github.yangli2004;

import java.util.Arrays;

public class FraudulentActivities {
    static int activityNotifications(int[] expenditure, int d) {;

        int notificationCount = 0;

        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {

            double median = getMedian(d, data);

            if (expenditure[i] >= 2 * median) {
                notificationCount++;

            }

            data[expenditure[i]]++;
            data[expenditure[i - d]]--;

        }

        return notificationCount;

    }

    static double getMedian(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= d/2) {
                    m1 = j;
                }
                if (m2 == null && count >= d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

    static int activityNotifications2(int[] expenditure, int d) {
        int count = 0;
        for (int i = d; i< expenditure.length; i++) {
            if(expenditure[i] >= 2 * median(expenditure, i-d, i-1)) {
                count++;
            }
        }

        return count;
    }

    static double median (int [] arr, int l, int r) {
        double median = 0;
        int [] tmp = new int[r-l+1];
        for(int i=0; i<tmp.length; i++) {
            tmp[i] = arr[l+i];
        }
        Arrays.sort(tmp);
        int m1= tmp.length / 2;
        if(tmp.length%2==0) {
            median = (tmp[m1] + tmp[m1+1]) / 2;
        } else {
            median = tmp[m1];
        }

        return median;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications2(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
    }
}
