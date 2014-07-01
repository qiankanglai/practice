package lintcode;

import java.util.HashMap;

/**
 * Created by anthony on 7/1/14.
 */
public class MinimumWindowSubstring {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if(source == null || target == null || source.length() == 0 || target.length() > source.length())
            return "";
        HashMap<Character, Integer> t = new HashMap<Character, Integer>();
        for(char c : target.toCharArray()){
            if(!t.containsKey(c))
                t.put(c, 1);
            else
                t.put(c, t.get(c)+1);
        }
        int start = 0, end = 0, left = target.length();
        while(end < source.length()){
            char c = source.charAt(end);
            if(t.containsKey(c)){
                int k = t.get(c);
                if(k > 0){
                    left--;
                }
                t.put(c, k-1);
            }
            end++;
            if(left == 0)
                break;
        }
        if(left > 0){
            return "";
        }
        String window = source.substring(start, end);
        for(int i = start; i < source.length(); i++){
            char c = source.charAt(i);
            if(!t.containsKey(c)) {
                continue;
            }
            if(end-i < window.length())
                window = source.substring(i, end);

            t.put(c, t.get(c)+1);
            if(t.get(c) > 0){
                while(end < source.length()) {
                    char c2 = source.charAt(end);
                    if(t.containsKey(c2)) {
                        t.put(c2, t.get(c2) - 1);
                    }
                    end++;
                    if(c2 == c)
                        break;
                }
            }
            if(t.get(c) > 0) {
                break;
            }
        }

        return window;
    }

    public static void main(String args[]){
        new MinimumWindowSubstring().minWindow("absdfaabab", "adb");
    }
}
