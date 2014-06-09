package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/6/9.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        if(S == null || S.length() == 0)
            return 0;
        if(T == null || T.length() == 0)
            return 0;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int len_s = s.length, len_t = t.length;
        int[][] count = new int[len_s][len_t];
        for(int i = 0; i < len_s; i++){
            if(t[0] == s[i])
                count[i][0] = 1;
        }
        for(int j = 1; j < len_t; j++){
            for(int i = 0; i < len_s; i++){
                if(t[j]==s[i]){
                    for(int i2 = 0; i2 < i; i2++)
                        count[i][j] += count[i2][j-1];
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < len_s; i++){
            sum += count[i][len_t-1];
        }

        return sum;
    }

    public static void main(String args[]){
        System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
        System.out.println(new DistinctSubsequences().numDistinct("ABCDE", "ACE"));
        System.out.println(new DistinctSubsequences().numDistinct("ccc", "c"));
    }
}
