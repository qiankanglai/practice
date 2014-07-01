package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/1/14.
 */
public class NQueens {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(n <= 0)
            return res;
        int quenes[] = new int[n];
        dfs(0, n, quenes, res);
        return res;
    }

    private void dfs(int level, int n, int[] quenes, ArrayList<ArrayList<String>> res) {
        if(level == n){
            ArrayList<String> r = new ArrayList<String>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                int k = quenes[i];
                for(int t = 0; t < k; t++)
                    sb.append('.');
                sb.append('Q');
                for(int t = k+1; t < n; t++)
                    sb.append('.');
                r.add(sb.toString());
            }
            res.add(r);
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

            dfs(level+1,n,quenes,res);
        }
    }

    public static void main(String args[]){
        new NQueens().solveNQueens(4);
    }
}
