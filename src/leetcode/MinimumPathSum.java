package leetcode;

/**
 * Created by Anthony on 2014/5/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int []temp1 = new int[n], temp2 = new int[n], temp3;

        temp1[0] = grid[0][0];
        for(int i=1; i<n; i++)
            temp1[i] = temp1[i-1]+grid[0][i];
        for(int j=1; j<m; j++){
            temp2[0] = temp1[0]+grid[j][0];
            for(int i=1; i<n; i++)
                temp2[i] = Math.min(temp1[i], temp2[i-1])+grid[j][i];

            temp3 = temp2;
            temp2 = temp1;
            temp1 = temp3;
        }

        return temp1[n-1];
    }
}
