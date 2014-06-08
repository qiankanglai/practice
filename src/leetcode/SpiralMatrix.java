package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 6/8/14.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0)
            return res;
        int xstart = 0, xend = matrix[0].length-1;
        int ystart = 0, yend = matrix.length-1;
        while(true){
            if(xstart <= xend){
                for(int x = xstart; x <= xend; x++)
                    res.add(matrix[ystart][x]);
            }
            else
                break;
            ystart++;

            if(ystart <= yend){
                for(int y = ystart; y <= yend; y++)
                    res.add(matrix[y][xend]);
            }
            else
                break;
            xend--;

            if(xstart <= xend){
                for(int x = xend; x >= xstart; x--)
                    res.add(matrix[yend][x]);
            }
            else
                break;
            yend--;

            if(ystart <= yend){
                for(int y = yend; y >= ystart; y--)
                    res.add(matrix[y][xstart]);
            }
            else
                break;
            xstart++;
        }


        return res;
    }

    public static void main(String args[]){
        int [][]matrix = new int[3][3];
        int k = 1;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++){
                matrix[i][j] = k;
                k++;
            }
        new SpiralMatrix().spiralOrder(matrix);
    }
}
