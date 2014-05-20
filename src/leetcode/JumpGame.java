package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/20.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if(A==null || A.length==0) return false;
        int last_available = A.length-1;
        for(int i = A.length-1; i>=0; i--){
            if(i+A[i]>=last_available)
                last_available = i;
        }
        return (last_available==0);
    }
}
