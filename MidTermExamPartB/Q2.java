package com.kevinshi721;

import static java.lang.StrictMath.sqrt;

public class Q2 {

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.arrangeCoins(5));
        System.out.println(q2.arrangeCoins(8));
        System.out.println(q2.arrangeCoins(Integer.MAX_VALUE));
    }

    public int arrangeCoins(int n){
        return (int)((-1 + sqrt(1 + 8 * (long)n)) / 2);
    }
}

