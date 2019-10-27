package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.Arrays;

/**
 * Int array
 * merge
 * 2 pointer
 * two pointer
 */
public class Problem0088 extends BaseProblem {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0 || m == 0) return;

        m--;
        n--;
        int p = nums1.length - 1;

        while(m >= 0 && n >= 0) {
            if(nums1[m] >= nums2[n]) {
                nums1[p--] = nums1[m--];
            } else if(nums1[m] < nums2[n]) {
                nums1[p--] = nums2[n--];
            }
        }

        while(n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }

    @Override
    public void solve() {
        int[] arr1 = Utils.toIntArray(1,2,3,0,0,0);
        int[] arr2 = Utils.toIntArray(2,5,6);
        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));

        int[] arr3 = Utils.toIntArray(7,8,9,0,0,0);
        int[] arr4 = Utils.toIntArray(2,5,6);
        merge(arr3, 3, arr4, 3);
        System.out.println(Arrays.toString(arr3));
    }

    @Override
    public String getProblemURL() {
        return "";
    }

    public static void main(String[] args) {
        baseMain(new Problem0088());
    }
}
