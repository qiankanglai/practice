package leetcode;

/**
 * Created by Anthony on 2014/5/27.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        //p.length()>0
        char c = p.charAt(0);
        String p2 = p.substring(1);
        if(c == '?'){
            if(s.length() == 0)
                return false;
            return isMatch(s.substring(1), p2);
        }
        else if(c == '*'){
            int start = 0;
            while(start < p2.length() && p2.charAt(start) == '*')
                start++;
            p2 = p2.substring(start);
            if(p2.length() == 0)
                return true;
            if(p2.indexOf('*') < 0){
                if(s.length() < p2.length())
                    return false;
                for(int i = 0; i < p2.length(); i++)
                    if(p2.charAt(p2.length()-1-i) != '?' && p2.charAt(p2.length()-1-i) != s.charAt(s.length()-1-i))
                        return false;
                return true;
            }
            else{
                int l = p2.indexOf('*');
                String p3 = p2.substring(l);
                p2 = p2.substring(0, l);
                for(int i = 0; i+l <= s.length(); i++){
                    //IMPORTANT cut off!如果这时候第二个*之后匹配依然不成功，这说明后半段就是匹配不上，不用继续i++匹配下去了
                    if(isMatch(s.substring(i, i+l), p2))
                        return isMatch(s.substring(i+l), p3);
                }
                return false;
            }
        }
        else{
            if(s.length() == 0)
                return false;
            if(s.charAt(0) != c)
                return false;
            return isMatch(s.substring(1), p2);
        }
    }

    public static void main(String args[]){
        /*System.out.println(new WildcardMatching().isMatch("aa", "a"));
        System.out.println(new WildcardMatching().isMatch("aa", "aa"));
        System.out.println(new WildcardMatching().isMatch("aaa", "aa"));
        System.out.println(new WildcardMatching().isMatch("aa", "*"));
        System.out.println(new WildcardMatching().isMatch("aa", "a*"));
        System.out.println(new WildcardMatching().isMatch("ab", "?*"));
        System.out.println(new WildcardMatching().isMatch("aab", "c*a*b*"));
        System.out.println(new WildcardMatching().isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb",
                "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a"));*/
        System.out.println(new WildcardMatching().isMatch("hi", "*?"));
    }
}
