package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int p=1,q=1;
        for(int i = 1; i<=n; i++){
            int r = p+q;
            p=q;
            q=r;
        }
        return p;
    }
}
