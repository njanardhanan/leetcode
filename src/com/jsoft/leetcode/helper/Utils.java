package com.jsoft.leetcode.helper;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int[] toIntArray(int... nums) {
        return nums;
    }

    public static List toList(int... nums) {
        List list = new ArrayList();
        for(int n :  nums) {
            list.add(n);
        }
        return list;
    }
}
