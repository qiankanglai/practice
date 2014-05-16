package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/16.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[0][];

        int [][]r = new int[n][];
        for(int i = 0; i < n; i++){
            r[i] = new int[n];
            Arrays.fill(r[i], 0);
        }

        final int dx[] = {0, 1, 0, -1};
        final int dy[] = {1, 0, -1, 0};
        int direction = 0, x=0, y=-1;
        for(int k=1; k<=n*n; k++){
            while(true) {
                x += dx[direction];
                y += dy[direction];
                if (x < 0 || y < 0 || x >= n || y >= n || r[x][y] != 0) {
                    x -= dx[direction];
                    y -= dy[direction];
                    direction = (direction + 1) % 4;
                }
                else
                    break;
            }
            r[x][y] = k;
        }
        return r;
    }

    public static void main(String args[]){
        new SpiralMatrixII().generateMatrix(2);
    }
}
