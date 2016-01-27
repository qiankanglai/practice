package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class SequenceSum {
    public static int[] sumOfN(int n) {
        if(n == 0) return new int[]{0};
        boolean negative = n < 0;
        n = Math.abs(n);
        int[]res = new int[n+1];
        res[0] = 0;
        for(int i = 1; i <= n; i++)
        {
            res[i] = res[i-1] + (negative?-i:i);
        }
        return res;
    }
}
