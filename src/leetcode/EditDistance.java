package leetcode;

/**
 * Created by Anthony on 2014/6/9.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return 0;
        int l1 = word1.length(), l2 = word2.length();
        if(l1 == 0 || l2 == 0)
            return Math.max(l1, l2);
        int steps[][] = new int[l1+1][l2+1];
        steps[0][0] = 0;
        for(int i = 1; i <= l1; i++)
            steps[i][0] = i;
        for(int i = 1; i <= l2; i++)
            steps[0][i] = i;
        for(int i = 1; i <= l1; i++){
            for(int j = 1; j <= l2; j++){
                int t1 = steps[i-1][j]+1;
                int t2 = steps[i][j-1]+1;
                int t3 = steps[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                steps[i][j] = Math.min(Math.min(t1,t2),t3);
            }
        }
        return steps[l1][l2];
    }
}
