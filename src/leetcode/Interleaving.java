package leetcode;

/**
 * Created by anthony on 6/8/14.
 */
public class Interleaving {
    public boolean isInterleave_tle(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1+l2 != l3)
            return false;
        if(l1 > 0 && s1.charAt(0) == s3.charAt(0)){
            if(isInterleave_tle(s1.substring(1), s2, s3.substring(1)))
                return true;
        }
        if(l2 > 0 && s2.charAt(0) == s3.charAt(0)){
            if(isInterleave_tle(s1, s2.substring(1), s3.substring(1)))
                return true;
        }
        return false;
    }
}
