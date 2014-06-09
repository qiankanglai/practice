package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/6/9.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = s.length();
        char c[] = s.toCharArray();
        int count[][] = new int[len][len+1];  //start position, length
        for(int step = 2; step <= len; step++){
            for(int i = 0; i + step <= len; i++){
                if(c[i] == c[i+step-1] && count[i+1][step-2] == 0){
                    count[i][step] = 0;
                }
                else{
                    int k = Integer.MAX_VALUE;
                    for(int split = 1; split < step; split++){
                        int k2 = count[i][split] + count[i+split][step-split]+1;
                        if(k2 < k)
                            k = k2;
                    }
                    count[i][step] = k;
                }
            }
        }
        return count[0][len];
    }

    public static void main(String args[]){
        System.out.println(new PalindromePartitioningII().minCut("aab"));
    }
}
