package com.kevinshi721.Assignment7;

public class ReverseHello extends Thread {

    private int counter;


    public ReverseHello(int counter) {
        this.counter = counter;
        if (counter < 50) {
            ReverseHello rh = new ReverseHello(counter + 1);
        }
        System.out.println("Hello from Thread " + counter);
    }

    public static void main(String[] args) {
        ReverseHello rh = new ReverseHello(1);
    }
}