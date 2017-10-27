package com.kevinshi721;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int [] q3t1 = {1, 2, 3};
        int [] q3t2 = {1, 2, 3, 4};
        System.out.println(q3.minMoves(q3t1));
        System.out.println(q3.minMoves(q3t2));

    }
    public int minMoves(int[] nums){
        if (nums.length == 0) return 0;
        int min = nums[0];
        int sum = 0;
        for (int n : nums) {
            min = Math.min(min, n);
            sum += n;
        }
        return sum - nums.length * min;
    }
}
