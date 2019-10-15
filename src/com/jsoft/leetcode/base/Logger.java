package com.jsoft.leetcode.base;

public class Logger {
    long startTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        long endTime = System.currentTimeMillis();
        System.out.println("Time elapsed : " + (endTime - startTime) + " ms.\n");
    }
}