package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 6/9/14.
 */
public class Candy {
    //更好的解法https://oj.leetcode.com/discuss/76/does-anyone-have-a-better-idea
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int len = ratings.length;
        int c[] = new int[len];
        Arrays.fill(c, 1);

        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i-1])
                c[i] = c[i-1]+1;
        }
        for(int i = len-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && c[i] <= c[i+1])
                c[i] = c[i+1]+1;
        }

        int sum = 0;
        for(int i = 0; i < len; i++)
            sum += c[i];
        return sum;
    }
}
