package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem0448 extends BaseProblem {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        //All numbers are +ve
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
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }

    @Override
    public void solve() {
        TestHelper.test(findDisappearedNumbers(Utils.toIntArray(4,3,2,7,8,2,3,1)), Utils.toList(5,6));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0448());
    }
}
