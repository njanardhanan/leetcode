package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Int array
 * Pancake sort
 */
public class Problem0969 extends BaseProblem {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        if(A == null || A.length == 0) return result;
        int largest = A.length;
        //System.out.println(Arrays.toString(A));
        for(int i=0; i<A.length; i++) {
            int index = findIndex(A, largest);
            if(index != 0){
                reverse(A, 0, index);
                System.out.println(Arrays.toString(A));
                result.add(index);
            }
            reverse(A, 0, largest-1);
            //System.out.println(Arrays.toString(A));
            result.add(largest);
            largest--;
        }



        return result;

    }

    private void reverse(int[] A, int from, int to) {
        while(from < to) {
            int t = A[from];
            A[from++] = A[to];
            A[to--] = t;
        }
    }

    private int findIndex(int[] A, int target) {
        for(int i=0; i<A.length; i++) {
            if(A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void solve() {
        System.out.println(pancakeSort(Utils.toIntArray(3,2,4,1)));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/pancake-sorting/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0969());
    }
}
