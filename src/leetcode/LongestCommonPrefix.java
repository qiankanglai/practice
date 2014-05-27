package leetcode;

/**
 * Created by Anthony on 2014/5/27.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String str = new String(strs[0]);
        for(int i = 1; i < strs.length; i++){
            int k = 0;
            int l = Math.min(str.length(), strs[i].length());
            while(k < l){
                if(str.charAt(k) != strs[i].charAt(k))
                    break;
                else
                    k++;
            }
            str = str.substring(0, k);
        }
        return str;
    }
}
