package leetcode;

/**
 * Created by Anthony on 2014/5/28.
 */
public class strStr {
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return null;
        int l1 = haystack.length(), l2 = needle.length();
        if(l2==0) return haystack;
        for(int i = 0; i <= l1-l2; i++){
            int x = 0;
            for(; x < l2; x++)
                if(haystack.charAt(x+i) != needle.charAt(x))
                    break;
            if(x >= l2)
                return haystack.substring(i);
        }
        return null;
    }
}
