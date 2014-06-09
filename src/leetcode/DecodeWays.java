package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/6/9.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int l = s.length();
        int counts[] = new int[l+1];
        Arrays.fill(counts, 0);
        counts[l] = 1;
        for(int i = l-1; i >= 0; i--){
            if(s.charAt(i) == '0')
                continue;
            counts[i] += counts[i+1];
            if(i+1 < l && ((s.charAt(i) == '1') || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')))
                counts[i] += counts[i+2];
        }
        return counts[0];
    }

    public static void main(String args[]){
        System.out.println(new DecodeWays().numDecodings("2"));
    }
}
