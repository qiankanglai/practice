package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/1/14.
 */
public class NQueensII {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int count = 0;
    public int totalNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(n <= 0)
            return 0;
        int quenes[] = new int[n];
        count = 0;
        dfs(0, n, quenes);
        return count;
    }

    private void dfs(int level, int n, int[] quenes) {
        if(level == n){
            count++;
            return;
        }
        for(int t = 0; t < n; t++){
            quenes[level] = t;
            boolean flag = false;
            for(int i = 0; i < level; i++){
                if(quenes[i] == quenes[level]){
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;

            for(int i = 0; i < level; i++){
                if(quenes[i] + i == quenes[level] + level){
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;

            for(int i = 0; i < level; i++){
                if(quenes[i] + level == quenes[level] + i){
                    flag = true;
                    break;
                }
            }
            if(flag)
                continue;

            dfs(level+1,n,quenes);
        }
    }
}
