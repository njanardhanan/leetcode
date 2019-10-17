package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * String to int
 * Sort
 */
public class Problem0179 extends BaseProblem {

    public String largestNumber(int[] nums) {
        String[] str = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(str, (a,b) -> ( (b+a).compareTo((a+b))));

        String ans = Arrays.stream(str).collect(Collectors.joining());
        return (ans.startsWith("0")) ? "0" : ans;
    }

    @Override
    public void solve() {
        TestHelper.test(largestNumber(Utils.toIntArray(30,34)), "3430");
        TestHelper.test(largestNumber(Utils.toIntArray(10,2)), "210");
        TestHelper.test(largestNumber(Utils.toIntArray(3,30,34,5,9)), "9534330");
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/largest-number/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0179());
    }
}
