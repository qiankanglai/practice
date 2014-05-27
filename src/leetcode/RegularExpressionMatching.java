package leetcode;

/**
 * Created by Anthony on 2014/5/27.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        //p.length()>0
        char c = p.charAt(0);
        String p2 = p.substring(1);
        boolean zeroormore = false;
        if(p2.length() > 0 && p2.charAt(0) == '*'){
            zeroormore = true;
            p2 = p2.substring(1);
        }
        if(s.length() == 0) {
            return zeroormore && isMatch(s, p2);
        }
        if(zeroormore){
            if(c == '.'){
                for(int i = 0; i <= s.length(); i++){
                    if(isMatch(s.substring(i), p2))
                        return true;
                }
                return false;
            }
            else{
                for(int i = 0; i <= s.length(); i++) {
                    if(isMatch(s.substring(i), p2))
                        return true;
                    if(i < s.length() && s.charAt(i) != c)
                        break;
                }
                return false;
            }
        }
        else{
            if(c == '.')
                return isMatch(s.substring(1), p2);
            else{
                if(c != s.charAt(0))
                    return false;
                return isMatch(s.substring(1), p2);
            }
        }
    }

    public static void main(String args[]){
        /*System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "aa"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "aa"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b*"));
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*c"));*/
        System.out.println(new RegularExpressionMatching().isMatch("a", "ab*"));
    }
}
