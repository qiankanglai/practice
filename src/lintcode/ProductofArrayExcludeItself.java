package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/25/14.
 */
public class ProductofArrayExcludeItself {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        if(A == null || A.size() <= 1){
            return new ArrayList<Long>();
        }
        int len = A.size();
        ArrayList<Long> res = new ArrayList<Long>();

        long t = 1;
        for(int i = 0; i < len; i++){
            res.add(t);
            t *= A.get(i);
        }
        t = 1;
        for(int i = len-1; i >= 0; i--){
            res.set(i, t*res.get(i));
            t *= A.get(i);
        }

        return res;
    }
}
