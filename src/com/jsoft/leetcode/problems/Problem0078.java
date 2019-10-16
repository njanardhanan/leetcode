package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0078 extends BaseProblem {

    public List<List<Integer>> subsets(int[] nums) {
        int k = 1 << nums.length;
        List<List<Integer>> pSet = new ArrayList<>();
        for(int i=0; i<k; i++) {
            List<Integer> newList = new ArrayList<>();
            for(int j=0; j<nums.length; j++) {
                if(((1<<j) & i) > 0) {
                    newList.add(nums[j]);
                }
            }
            pSet.add(newList);
        }
        return pSet;
    }

    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }

    @Override
    public void solve() {
        System.out.println("Using bits");
        for(List<Integer> l : subsets(Utils.toIntArray(1,2,3))) {
            System.out.println(l);
        }

        System.out.println("Using iterative method");
        for(List<Integer> l : subsetsIterative(Utils.toIntArray(1,2,3))) {
            System.out.println(l);
        }
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/subsets/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0078());
    }
}
