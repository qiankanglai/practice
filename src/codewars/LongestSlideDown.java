package codewars;

/**
 * Created by qiank on 1/30/2016.
 */
public class LongestSlideDown {
    public static int longestSlideDown(int[][] pyramid) {
        int depth = pyramid.length;
        int res1[] = new int[depth];
        int res2[] = new int[depth];
        res1[0] = pyramid[0][0];
        for(int i = 1; i < depth; i++)
        {
            res2[0] = res1[0]+pyramid[i][0];
            res2[i] = res1[i-1]+pyramid[i][i];
            for(int j = 1; j <= i-1; j++)
            {
                res2[j] = Math.max(res1[j], res1[j-1])+pyramid[i][j];
            }
            int tmp[] = res1;
            res1= res2;
            res2 = tmp;
        }
        int max = res1[0];
        for(int i=1;i<depth; i++)
        {
            if(res1[i] > max) max=res1[i];
        }
        return max;
    }

    public static void main(String args[])
    {
        int[][] test = new int[][] {{3}, {7, 4}, {2, 4, 6}, {8, 5, 9, 3}};
        System.out.println(longestSlideDown(test));
    }
}
