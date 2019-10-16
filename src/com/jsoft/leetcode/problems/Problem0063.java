package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

public class Problem0063 extends BaseProblem {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //Change the obstacle from 1 to -1
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
            }
        }


        //init first row and col to 1, since there is only one path
        for(int i=0; i<n; i++) {
            //break the loop if you find obstacle
            if(obstacleGrid[0][i] == -1) {
                break;
            }
            obstacleGrid[0][i] = 1;
        }
        for(int i=0; i<m; i++) {
            //break the loop if you find obstacle
            if(obstacleGrid[i][0] == -1) {
                break;
            }
            obstacleGrid[i][0] = 1;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(obstacleGrid[i][j] == -1) continue;

                int leftCell = (obstacleGrid[i-1][j] == -1) ? 0 : obstacleGrid[i-1][j];
                int topCell = (obstacleGrid[i][j-1] == -1) ? 0 : obstacleGrid[i][j-1];
                obstacleGrid[i][j] = leftCell + topCell;
            }
        }
        return (obstacleGrid[m-1][n-1] == -1) ? 0 : obstacleGrid[m-1][n-1];
    }

    @Override
    public void solve() {
        int[][] area = {{0,0,0},
                {0,1,0},
                {0,0,0}};
        //TestHelper.test(uniquePathsWithObstacles(area), 2);

        int[][] area1 = {{1}};
        TestHelper.test(uniquePathsWithObstacles(area1), 0);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/unique-paths-ii/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0063());
    }
}
