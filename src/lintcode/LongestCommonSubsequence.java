package lintcode;

/**
 * Created by anthony on 6/28/14.
 */
public class LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        if(A == null || A.length() == 0)
            return 0;
        if(B == null || B.length() == 0)
            return 0;
        int lena = A.length(), lenb = B.length();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int flags[][] = new int[lena+1][lenb+1];
        for(int i = 1; i <= lena; i++){
            for(int j = 1; j <= lenb; j++){
                int t1 = flags[i-1][j], t2 = flags[i][j-1];
                int t3 = flags[i-1][j-1]+(a[i-1]==b[j-1]?1:0);
                flags[i][j] = Math.max(t1, Math.max(t2, t3));
            }
        }
        return flags[lena][lenb];
    }
}
