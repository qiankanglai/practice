package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/12.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int []temp1 = new int[n], temp2 = new int[n];
        Arrays.fill(temp1, 0);

        temp1[0] = (obstacleGrid[0][0]==0)?1:0;
        for(int i = 1; i < n; i++)
            temp1[i] = (obstacleGrid[0][i]==0)?temp1[i-1]:0;
        for(int i = 1; i < m; i++){
            temp2[0] = (obstacleGrid[i][0]==0)?temp1[0]:0;
            for(int j = 1; j < n; j++)
                temp2[j] = (obstacleGrid[i][j]==0)?(temp1[j]+temp2[j-1]):0;
            int []temp = temp1;
            temp1 = temp2;
            temp2 = temp;
        }
        return temp1[n-1];
    }
}
