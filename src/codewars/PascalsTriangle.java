package codewars;

/**
 * Created by qiank on 1/30/2016.
 */
public class PascalsTriangle {
    public static int[][] pascal(int depth) {
        int[][] res = new int[depth][];
        res[0] = new int[]{1};
        for(int i = 1; i < depth; i++)
        {
            res[i] = new int[i+1];
            res[i][0] = 1;
            for(int j=1;j<i;j++)
            {
                res[i][j] = res[i-1][j-1]+res[i-1][j];
            }
            res[i][i] = 1;
        }
        return res;
    }
}
