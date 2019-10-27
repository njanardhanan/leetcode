package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.Utils;

import java.util.Arrays;

/**
 * 2D array
 * Set matrix zeros
 *
 * Microsoft
 */
public class Problem0073 extends BaseProblem {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isFirstColumnContainsZero = false;
        for(int r=0; r<rows; r++) {
            if(matrix[r][0] == 0) {
                isFirstColumnContainsZero = true;
                break;
            }
        }

        boolean isFirstRowContainsZero = false;
        for(int c=0; c<cols; c++) {
            if(matrix[0][c] == 0) {
                isFirstRowContainsZero = true;
                break;
            }
        }

        //Analyze all rows and columns except first row and column
        for(int r=1; r<rows; r++) {
            for(int c=1; c<cols; c++) {
                if(matrix[r][c] == 0) {
                    //set corresponding first row and column to zero
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        //Process all rows and columns except first row and column
        for(int r=1; r<rows; r++) {
            for(int c=1; c<cols; c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        //Process first row
        if (isFirstRowContainsZero) {
            for(int c=0; c<cols; c++) {
                matrix[0][c] = 0;
            }
        }

        //Process first col
        if (isFirstColumnContainsZero) {
            for(int r=0; r<rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }

    @Override
    public void solve() {
        int[][] matrix = Utils.toInt2DArray(",","1,1,1", "1,0,1", "1,1,1");
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix1 = Utils.toInt2DArray(",","0,1,2,0", "3,4,5,2", "1,3,1,5");
        setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/set-matrix-zeroes/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0073());
    }
}
