package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.Arrays;

/**
 * 2D array
 * rotate matrix
 * transpose
 */
public class Problem0048 extends BaseProblem {

    public void rotate(int[][] matrix) {
        /**
         * For rotating 90 degree clockwise, you need to transpose and reverse rows
         * For rotating 90 degree anti-clockwise, you need to reverse rows and then transpose
         */

        transpose(matrix);

        reverseRows(matrix);

    }

    private void reverseRows(int[][] matrix) {
        for(int r=0; r<matrix.length; r++) {
            reverse(matrix[r]);
        }
    }

    private void reverse(int[] row) {
        int l=0;
        int r=row.length-1;
        while(l<r) {
            int t = row[l];
            row[l++] = row[r];
            row[r--] = t;
        }
    }

    private void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<=i; j++) {
                if(i == j) continue;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }

        }
    }

    @Override
    public void solve() {
        int[][] matrix = Utils.toInt2DArray(",", "1,2,3", "4,5,6", "7,8,9");
        System.out.println(Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix1 = Utils.toInt2DArray(",","15,13,2,5", "14,3,4,1", "12,6,8,9", "16,7,10,11");
        System.out.println(Arrays.deepToString(matrix1));
        rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/rotate-image/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0048());
    }
}
