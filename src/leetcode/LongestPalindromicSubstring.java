package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 5/23/14.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1)
            return s;

        boolean flags_odd[] = new boolean[s.length()];
        boolean flags_even[] = new boolean[s.length()];
        Arrays.fill(flags_odd, true);
        Arrays.fill(flags_even, true);

        String max = ""+s.charAt(0);
        for(int i = 0; i < s.length()-1; i++){
            flags_even[i] = s.charAt(i)==s.charAt(i+1);
            if(flags_even[i])
                max = s.substring(i, i+2);
        }

        for(int step = 3; step <= s.length(); step++){
            int available = -1;
            if(step % 2 == 0){
                for(int i = 0; i <= s.length()-step; i++){
                    flags_even[i] = (flags_even[i+1] && s.charAt(i)==s.charAt(i+step-1));
                    if(flags_even[i])
                        available = i;
                }
            }
            else{
                for(int i = 0; i <= s.length()-step; i++){
                    flags_odd[i] = (flags_odd[i+1] && s.charAt(i)==s.charAt(i+step-1));
                    if(flags_odd[i])
                        available = i;
                }
            }
            if(available >= 0){
                max = s.substring(available, available+step);
            }
        }
        return max;
    }

    public String longestPalindrome0(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            sb.append(s.charAt(s.length()-i-1));
        String s_reverse = sb.toString();

        int max=1, start = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == s_reverse.charAt(j)){
                    int count = 0;
                    int max_move = Math.min(s.length()-i, s.length()-j);
                    if(max_move < max)
                        continue;
                    for(int k = 0; k < max_move; k++){
                        if(s.charAt(i+k) == s_reverse.charAt(j+k)){
                            count++;
                        }
                        else
                            break;
                    }
                    if(count > max){
                        max = count;
                        start = i;
                    }

                }
            }
        }

        return s.substring(start, start+max);
    }

    public static void main(String args[]){
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abcba"));
    }
}
