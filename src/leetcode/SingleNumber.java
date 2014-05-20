package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class SingleNumber {
    public int singleNumber(int A[]) {
        int x = 0;
        for(int i = 0; i < A.length; i++)
            x ^= A[i];
        return x;
    }
}
