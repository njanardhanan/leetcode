package com.jsoft.leetcode.helper;

import java.util.Arrays;
import java.util.List;

public class TestHelper {
    public static <T extends Comparable<T>> void test(T actual, T expected) {
        if(actual.compareTo(expected) == 0) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED : expected " + expected + " but actual was " + actual);
        }
    }

    public static void testArray(int[] actualArray, int[] expectedArray) {
        if (Arrays.equals(actualArray, expectedArray)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED : expected " + Arrays.toString(expectedArray) + " but actual was " + Arrays.toString(actualArray));
        }
    }

    public static void test(List actual, List expected) {
        if(actual.equals(expected)) {
            System.out.println("PASSED!");
        } else {
            System.out.println("FAILED : expected " + expected + " but actual was " + actual);
        }
    }
}
