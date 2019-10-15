package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.Arrays;

public class Problem0034 extends BaseProblem {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[]{left, right};
    }

    private int binarySearch(int[] nums, int target, boolean leftMost) {
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left<=right) {
            int mid = (left + right) / 2;
            if(leftMost) {
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if(nums[mid] == target) index = mid;
        }

        return index;
    }

    @Override
    public void solve() {
        TestHelper.testArray(searchRange(new int[]{0,1,2,2,2,3,4}, 2), new int[]{2,4});
        TestHelper.testArray(searchRange(new int[]{5,7,7,8,8,10}, 8), new int[]{3,4});
        TestHelper.testArray(searchRange(new int[]{5,7,7,8,8,10}, 6), new int[]{-1,-1});
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0034());
    }
}
