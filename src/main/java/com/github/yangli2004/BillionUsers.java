package com.github.yangli2004;

public class BillionUsers {
    private double target = 1000000000;
    private double usersByDay(float rate, int days) {
        return Math.pow(rate, days);
    }

    public int getBillionUsersDay(float[] growthRates) {
        int start = 1;
        int end = 2000;
        while (start < end) {
            double users = 0;
            int mid = start + (end - start) / 2;
            for (float rate : growthRates) {
                users += usersByDay(rate, mid);
            }
            if (users >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private void run() {
        //float [] rates = new float[] {(float) 1.1};
        System.out.println(getBillionUsersDay2(new float[]{1.1f, 1.2f, 1.3f}));
    }

    public static void main(String[] args) {
        new BillionUsers().run();
    }

    private double totalsByDay(float[] rates, int days) {
        double users = 0;
        for(float rate: rates) {
            users += Math.pow(rate, days);
        }
        return users;
    }

    private int search(float [] rates, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (totalsByDay(rates, mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
            search(rates, start, end);
        }
        return end;
    }

    public int getBillionUsersDay2(float [] growthRates) {
        int i = 1;
        double users = 0;
        while (users < target) {
            i *= 2;
            users = totalsByDay(growthRates, i);
        }

        return search(growthRates, i/2 ,i);
    }
}
