package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

public class Problem0035 extends BaseProblem {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        return binarySearchEqualToOrGreaterThan(nums, target);
    }

    private int binarySearchEqualToOrGreaterThan(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    @Override
    public void solve() {
        TestHelper.test(searchInsert(new int[]{0, 1, 2, 3, 4}, 3), 3);
        TestHelper.test(searchInsert(new int[]{0, 1, 2, 4}, 3), 3);
        TestHelper.test(searchInsert(new int[]{1,3,5,6}, 5), 2);
        TestHelper.test(searchInsert(new int[]{1,3,5,6}, 2), 1);
        TestHelper.test(searchInsert(new int[]{1,3,5,6}, 7), 4);
        TestHelper.test(searchInsert(new int[]{1,3,5,6}, 0), 0);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/search-insert-position/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0035());
    }
}
