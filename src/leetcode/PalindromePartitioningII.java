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
            for(int i = 0; i + step <= len; i++) {
                //check palindrome
                if (c[i] == c[i + step - 1] && count[i + 1][step - 2] == 0) {
                    count[i][step] = 0;
                } else {
                    count[i][step] = -1;
                }
            }
            if(count[0][step] != 0) {
                //只需要计算count[0][x]具体值
                //其他的count[m][n]只用-1和0代表是否回文
                int k = Integer.MAX_VALUE;
                for (int split = 1; split < step; split++) {
                    if (count[split][step - split] != 0)
                        continue;
                    int k2 = count[0][split] + count[split][step - split] + 1;
                    if (k2 < k)
                        k = k2;
                }
                count[0][step] = k;
            }
        }
        return count[0][len];
    }

    //思路没问题，但是多算了很多无用的count
    //对于每一段，肯定可以分为后面一个回文+前面若干
    public int minCut_tle(String s) {
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
                        if(k == 1)
                            break;
                    }
                    count[i][step] = k;
                }
            }
        }
        return count[0][len];
    }

    public static void main(String args[]){
        System.out.println(new PalindromePartitioningII().minCut("cdd"));
        //System.out.println(new PalindromePartitioningII().minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
