package leetcode;

import sun.org.mozilla.javascript.internal.ast.Jump;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/20.
 */
public class JumpGameII {
    public int selectivejump(int[] A, int[] min, int i){
        if(min[i] < 100000000)
            return min[i];
        int l = i+A[i];
        if (l >= A.length - 1) {
            min[i] = 1;
        } else {
            int m = 100000000;
            for (int j = l; j >= i + 1; j--) {
                if(A[j]+j <= l) continue;   //Ticky key line!!!For the TLE situation
                m = Math.min(m, selectivejump(A, min, j));
            }
            min[i] = m + 1;
        }
        return min[i];
    }
    public int jump(int[] A) {
        if (A == null || A.length == 0) return -1;
        if(A.length==1) return 0;
        int min[] = new int[A.length];
        Arrays.fill(min, 100000000);
        selectivejump(A, min, 0);
        return min[0];
    }
    public int jump0(int[] A) {
        if(A==null || A.length==0) return -1;
        int min[] = new int[A.length];
        Arrays.fill(min, -1);
        for(int i = A.length-1; i>=0; i--){
            if(i+A[i]>=A.length-1)
                min[i] = 1;
            else{
                int k = -1;
                for(int j = i+1; j<=i+A[i]; j++){
                    if(A[j] > 0){
                        if(k<0 || A[j]+1<k)
                            k=A[j]+1;
                    }
                }
                min[i]=k;
            }
        }
        return min[0];
    }

    public static void main(String args[]){
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 0, 1, 4}));
    }
}
