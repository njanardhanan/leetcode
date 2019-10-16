package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem0090 extends BaseProblem {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int k = 1 << nums.length;
        Set<List<Integer>> pSet = new HashSet<>();
        for(int i=0; i<k; i++) {
            List<Integer> newList = new ArrayList<>();
            for(int j=0; j<nums.length; j++) {
                if(((1<<j) & i) > 0) {
                    newList.add(nums[j]);
                }
            }
            pSet.add(newList);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.addAll(pSet);
        return result;
    }

    public List<List<Integer>> subsetsWithDupIterative(int[] nums) {
        Arrays.sort(nums);
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

        Set<List<Integer>> pSet = new HashSet<>();
        pSet.addAll(result);

        result.clear();
        result.addAll(pSet);
        return result;
    }

    @Override
    public void solve() {
        System.out.println("Using bits");
        for(List<Integer> l : subsetsWithDup(Utils.toIntArray(4,4,4,1,4))) {
            System.out.println(l);
        }

        System.out.println("Using bits");
        for(List<Integer> l : subsetsWithDup(Utils.toIntArray(1,2,2))) {
            System.out.println(l);
        }

        System.out.println("Using iterative method");
        for(List<Integer> l : subsetsWithDupIterative(Utils.toIntArray(1,2,2))) {
            System.out.println(l);
        }
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/subsets-ii/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0090());
    }
}
