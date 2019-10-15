package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;

public class Problem0001 extends BaseProblem {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(target-nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }


    @Override
    public void solve() {
        TestHelper.testArray(twoSum(new int[]{1,2,3,4}, 5), new int[]{1,2});
        TestHelper.testArray(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0,1});
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/two-sum/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0001());
    }
}
