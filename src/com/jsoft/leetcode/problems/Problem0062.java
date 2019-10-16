package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;
import java.util.Map;

public class Problem0062 extends BaseProblem {

    public int uniquePaths(int m, int n) {
        int[][] box = new int[m][n];

        //init first row and col to 1, since there is only one path
        for(int i=0; i<n; i++) {
            box[0][i] = 1;
        }
        for(int i=0; i<m; i++) {
            box[i][0] = 1;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                box[i][j] = box[i-1][j] + box[i][j-1];
            }
        }
        return box[m-1][n-1];
    }

    @Override
    public void solve() {
        TestHelper.test(uniquePaths(3,2), 3);
        TestHelper.test(uniquePaths(7,3), 28);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/unique-paths/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0062());
    }
}
