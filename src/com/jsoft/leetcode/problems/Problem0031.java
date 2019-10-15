package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.Arrays;

public class Problem0031 extends BaseProblem {

    public void nextPermutation(int[] nums) {
        //From right, find the first decreasing number.
        //Ex : 1,2,3, we need to find 2 because it is lesser than it next number 3.
        //Ex : 5,4,1,3,2 , we need to find 1 because it is lesser than it next number 3.
        //Ex : 4 5 6 3 2 1, we need to find 5 because it is lesser than it next number 6.
        int p = -1;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                p = i;
                break;
            }
        }

        if(p == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        //From right, find the first number greater than p.
        int q = -1;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] > nums[p]) {
                q = i;
                break;
            }
        }

        swap(nums, p, q);
        reverse(nums, p+1, nums.length-1);


    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }


    @Override
    public void solve() {
        int[] nums1 = {1,2,3,4};
        nextPermutation(nums1);
        TestHelper.testArray(nums1, new int[]{1,2,4,3});

        int[] nums2 = {3,2,1};
        nextPermutation(nums2);
        TestHelper.testArray(nums2, new int[]{1,2,3});

        int[] nums3 = {1,1,5};
        nextPermutation(nums3);
        TestHelper.testArray(nums3, new int[]{1,5,1});

        int[] nums4 = {4, 5, 6, 3, 2, 1};
        nextPermutation(nums4);
        TestHelper.testArray(nums4, new int[]{4, 6, 1, 2, 3, 5});
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/next-permutation/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0031());
    }
}
