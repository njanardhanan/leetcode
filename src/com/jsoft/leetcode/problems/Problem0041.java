package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

public class Problem0041 extends BaseProblem {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;
        //Remove all -ves and zero, Convert the -ve numbers and zero to n+1
        for(int i=0; i<n; i++) {
            if(nums[i] <= 0) {
                nums[i] = n+1;
            }
        }

        //Now all numbers are +ve
        //Update the index using value to -ve
        for(int i=0; i<n; i++) {
            int val = Math.abs(nums[i]);
            if(val > n) continue;
            int index = val - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        //First positive index is the missing positive number
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) return i+1;
        }
        return n+1;
    }

    @Override
    public void solve() {
        TestHelper.test(firstMissingPositive(new int[]{1}), 2);
        TestHelper.test(firstMissingPositive(new int[]{1,2,0}), 3);
        TestHelper.test(firstMissingPositive(new int[]{3,4,-1,1}), 2);
        TestHelper.test(firstMissingPositive(new int[]{7,8,9,11,12}), 1);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/first-missing-positive/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0041());
    }
}
