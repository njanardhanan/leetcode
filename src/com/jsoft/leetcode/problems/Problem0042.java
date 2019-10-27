package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.Utils;

/**
 * dp
 * Dynamic Programming
 * Trapping rain water
 */
public class Problem0042 extends BaseProblem {

    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;

        int len = height.length;

        int[] maxHeightOnRight = new int[len];

        //Note maximum height on the right
        maxHeightOnRight[len-1] = height[len-1];
        for(int i=len-2; i>=0; i--) {
            maxHeightOnRight[i] = Math.max(maxHeightOnRight[i+1], height[i]);
        }

        int maxHeightOnLeft = 0;
        int rainWaterCount = 0;
        for(int i=0; i<len; i++) {
            //Note the maximum height on the left, including current tower.
            maxHeightOnLeft = Math.max(maxHeightOnLeft, height[i]);

            //Get the minimum of left vs right
            int minTower = Math.min(maxHeightOnLeft, maxHeightOnRight[i]);

            //rain water count will be minimum tower - current height
            rainWaterCount += (minTower - height[i]);
        }

        return rainWaterCount;

    }

    @Override
    public void solve() {
        TestHelper.test(trap(Utils.toArray(0,1,0,2,1,0,1,3,2,1,2,1)), 6);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/trapping-rain-water/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0042());
    }
}
