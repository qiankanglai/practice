package leetcode;

import java.util.HashMap;

/**
 * Created by Anthony on 2014/5/8.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l==0) return 0;
        HashMap<Character, Integer> cache = new HashMap<Character, Integer>();
        int length = 0, max = 1;
        for(int i = 0; i < l; i++){
            char c = s.charAt(i);
            int last = -1;
            if(cache.containsKey(c))
                last = cache.get(c);
            length = Math.min(length+1, i-last);
            if(length>max)
                max = length;
            cache.put(c, i);
        }
        return max;
    }

    public static void main(String args[]){
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("hchzvfrkmlnozjk"));
    }
}
