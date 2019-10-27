package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2D Array
 * Matrix
 * Sprial
 */
public class Problem0054 extends BaseProblem {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return result;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;

        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;

        while(result.size() < total) {
            //Traverse left to right on top row
            for(int i=left; i<=right && result.size() < total; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //Traverse top to bottom on right column
            for(int i=top; i<=bottom && result.size() < total; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            //Traverse right to left on bottom row
            for(int i=right; i>=left && result.size() < total; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            //Traverse bottom to top on left col
            for(int i=bottom; i>=top && result.size() < total; i--) {
                result.add(matrix[i][left]);
            }
            left++;

        }

        return result;

    }

    @Override
    public void solve() {
        System.out.println(spiralOrder(Utils.toInt2DArray(",", "1,2,3", "4,5,6", "7,8,9")));
        System.out.println(spiralOrder(Utils.toInt2DArray(",", "1,2,3,4", "5,6,7,8", "9,10,11,12")));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/spiral-matrix/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0054());
    }
}
