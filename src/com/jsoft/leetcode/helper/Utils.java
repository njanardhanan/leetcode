package com.jsoft.leetcode.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Utils {
    public static int[] toIntArray(int... nums) {
        return nums;
    }

    public static int[][] toInt2DArray(String separator, String... strs) {
        int[][] result = new int[strs.length][];
        int i=0;
        for(String s : strs) {
            int j=0;
            String[] vals = s.split(separator);
            result[i] = new int[vals.length];
            for(String v : vals) {
                result[i][j++] = Integer.parseInt(v);
            }
            i++;
        }
        return result;
    }

    public static int[] toArray(int... nums) {
        return nums;
    }

    public static char[] toArray(char... chars) {
        return chars;
    }

    public static String[] toArray(String... str) {
        return str;
    }

    public static String[] toArray(String str) {
        return toArray(Arrays.stream(str.split(" ")));
    }

    public static String[] toArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    public static List toList(int... nums) {
        List list = new ArrayList();
        for(int n :  nums) {
            list.add(n);
        }
        return list;
    }

    public static List<String> toStringList(String... strs) {
        List<String> list = new ArrayList();
        for(String s :  strs) {
            list.add(s);
        }
        return list;
    }
}
