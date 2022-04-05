package com.LPC1;

public class Main {

    public static void main(String[] args) {

        GUI runnable1 = new GUI();
        Thread thread1 = new Thread(runnable1);
        thread1.start();

    }
}
