package com.axiomaster;

public class L400 {
    public static int findNthDigit(int n) {
        int d = 1;
        int c = 10;
        int e = c - d;
        int idx = 1;

        while (e < n) {
            d = d * 10 + 1;
            c = (c * 10) * (idx + 1);
            e = c - d;
            idx++;
        }

        int x = (n + d - 1) / idx;
        int y = (n + d) % idx;
        y = (y == 0 ? idx : y);
        y = idx - y;

        int i = 0;
        while (i < y) {
            x = x / 10;
            i++;
        }
        return x % 10;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(100000));
    }
}
