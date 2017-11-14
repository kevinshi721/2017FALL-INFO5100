package com.kevinshi721.Assignment7;

public class MaxValue extends Thread{
    int lo, hi;
    int[] arr;
    int maxValue = Integer.MIN_VALUE;

    public MaxValue(int[] arr, int lo, int hi){
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public void run(){
        for (int i = lo; i < hi; i++){
            if (arr[i] > maxValue){
                maxValue = arr [i];
            }
        }
    }

    public static int findMaxValue(int[] arr) throws InterruptedException {
        int len = arr.length;
        int max = 0;

        MaxValue[] mv = new MaxValue[4];
        for (int i = 0; i < 4; i++){
            mv[i] = new MaxValue(arr, (i * len)/4, (i + 1) * len / 4);
            mv[i].start();
        }

        for (int i = 0; i < 4; i++){
            mv[i].join();
            if (max < mv[i].maxValue){
                max = mv[i].maxValue;
            }
        }
        return max;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 400);
            System.out.print(arr[i] + " ");

        }
        System.out.println();
        int maxValue = findMaxValue(arr);
        System.out.println("MaxValue -> " + maxValue);
    }
}
