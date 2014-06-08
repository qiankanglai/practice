package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Anthony on 2014/6/8.
 */
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if(S == null || S.length() == 0 || T==null || T.length() == 0)
            return "";
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        int count = t.length;
        HashMap<Character, Integer> count_t = new HashMap<Character, Integer>();
        HashMap<Character, Integer> count_s = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length; i++){
            if(count_t.containsKey(t[i]))
                count_t.put(t[i], count_t.get(t[i])+1);
            else
                count_t.put(t[i], 1);
        }
        int start = 0, end = 0;
        while(count > 0 && end < s.length){
            char idx = s[end];
            if(count_t.containsKey(idx)) {
                if(count_s.containsKey(idx))
                    count_s.put(idx, count_s.get(idx)+1);
                else
                    count_s.put(idx, 1);
                if(count_s.get(idx) <= count_t.get(idx)){
                    count--;
                }
            }
            end++;
        }
        if(count > 0)
            return "";
        String result = S.substring(start, end);
        while(start < end){
            char idx = s[start];
            if(count_t.containsKey(idx)) {
                count_s.put(idx, count_s.get(idx)-1);
                if(count_s.get(idx) < count_t.get(idx)) {
                    count++;    //=1
                }
            }
            start++;
            if(count == 0){
                if(end - start < result.length()) {
                    result = S.substring(start, end);
                }
            }
            else{
                while(count > 0 && end < s.length){
                    char idx2 = s[end];
                    if(count_t.containsKey(idx2)) {
                        if(count_s.get(idx2) < count_t.get(idx2)){
                            count--;
                        }
                        count_s.put(idx2, count_s.get(idx2)+1);
                    }
                    end++;
                }
                if(count > 0)
                    break;
            }
        }

        return result;
    }

    public static void main(String args[]){
        //System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow("of_characters_and_as", "aas"));
    }
}
