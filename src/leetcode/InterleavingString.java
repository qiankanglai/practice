package leetcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/8/14.
 */
public class InterleavingString {
    class Pair{
        public int i1, i2;
        public Pair(int v1, int v2){
            i1 = v1;
            i2 = v2;
        }
    }
    //动态规划：只要判断[i,j]子串是否能组成s3，有几种组合方式其实无所谓
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        if(l3 == 0)
            return true;
        boolean flags[][] = new boolean[l1+1][l2+1];
        flags[0][0] = true;
        for(int i = 0; i < l1; i++){
            if(s3.charAt(i) == s1.charAt(i))
                flags[i+1][0] = true;
            else
                break;
        }
        for(int i = 0; i < l2; i++){
            if(s3.charAt(i) == s2.charAt(i))
                flags[0][i+1] = true;
            else
                break;
        }
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                flags[i][j] = (flags[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1)) || (flags[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1));
            }
        }

        return flags[l1][l2];
    }

    public boolean isInterleave_tle2(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3)
            return false;

        ArrayList<Pair> current = new ArrayList<Pair>();
        if(l1 > 0 && s1.charAt(0) == s3.charAt(0)){
            current.add(new Pair(1, 0));
        }
        if(l2 > 0 && s2.charAt(0) == s3.charAt(0)){
            current.add(new Pair(0, 1));
        }
        if(current.size() == 0) {
            if(l3 == 0)
                return true;
            else
                return false;
        }
        for(int k = 1; k < l3; k++){
            char c = s3.charAt(k);
            ArrayList<Pair> next = new ArrayList<Pair>();
            for(Pair p:current){
                if(p.i1 < l1 && s1.charAt(p.i1) == c)
                    next.add(new Pair(p.i1+1, p.i2));
                if(p.i2 < l2 && s2.charAt(p.i2) == c)
                    next.add(new Pair(p.i1, p.i2+1));
            }

            if(next.size() == 0)
                return false;
            else
                current = next;
        }
        return true;
    }
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

    public static void main(String args[]){
        System.out.println(new InterleavingString().isInterleave(
                "a",
                "b",
                "ab"));
    }
}
