package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem0027 extends BaseProblem {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            if (left == right && nums[right] != val) {
                left++;
                right++;
            } else if (nums[right] == val) {
                right++;
            } else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        return left;
    }

    public int removeElementOptimized(int[] nums, int val) {
        int left = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }


    @Override
    public void solve() {
        TestHelper.test(removeElement(new int[]{3,2,2,3}, 3), 2);
        TestHelper.test(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2), 5);

        TestHelper.test(removeElementOptimized(new int[]{3,2,2,3}, 3), 2);
        TestHelper.test(removeElementOptimized(new int[]{0,1,2,2,3,0,4,2}, 2), 5);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/remove-element/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0027());
    }
}
