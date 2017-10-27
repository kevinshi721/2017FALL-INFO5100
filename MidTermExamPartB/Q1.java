package com.kevinshi721;

import java.util.Arrays;

public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] q1t1 = {9, 4, 8, 7, 5, 1, 3};
        int[] q1t2 = {6, 4, 1, 0, 3, 2};
        int[] q1r1 = q1.reverseEvenIndices(q1t1);
        int[] q1r2 = q1.reverseEvenIndices(q1t2);
        System.out.println(Arrays.toString(q1r1));
        System.out.println(Arrays.toString(q1r2));
    }

    public int[] reverseEvenIndices(int[] nums) {

        if(nums.length%2 == 0){
            int i = 0;
            int j = nums.length - 2;
            while(i < j ){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j -= 2;
            }
            return nums;
        }
        else{
            int i = 0;
            int j = nums.length - 1;
            while(i<=j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j -= 2;
            }
            return nums;
        }
    }
}