package lintcode;

/**
 * Created by Anthony on 2014/6/24.
 */
public class InterleavingString {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null)
            return false;
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean flags[][] = new boolean[s1.length()+1][s2.length()+1];
        flags[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            flags[i][0] = flags[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for(int i = 1; i <= s2.length(); i++){
            flags[0][i] = flags[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                flags[i][j] = (flags[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (flags[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            }
        }
        return flags[s1.length()][s2.length()];
    }

    public static void main(String args[]){
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
