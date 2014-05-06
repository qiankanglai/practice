package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/6.
 */
public class NQueens {
    ArrayList<String[]> result = null;
    int[] places;

    public void dfs(int level, int n){
        if(level >= n){
            //save to result
            String[] res = new String[n];
            for(int i = 0; i < n; i++){
                int p = places[i];
                StringBuilder sb = new StringBuilder();
                for(int t = 0; t < p; t++)
                    sb.append(".");
                sb.append("Q");
                for(int t = p+1; t < n; t++)
                    sb.append(".");
                res[i] = sb.toString();
            }
            result.add(res);
        }
        else{
            for(int i = 0; i < n; i++){
                boolean flag = true;
                for(int j = 0; j < level; j++){
                    if(places[j] == i){
                        flag = false;break;
                    }
                    if(places[j]+j==i+level){
                        flag = false;break;
                    }
                    if(places[j]+level==j+i){
                        flag = false;break;
                    }
                }
                places[level] = i;
                if(flag)
                    dfs(level+1, n);
            }
        }
    }
    public ArrayList<String[]> solveNQueens(int n) {
        result = new ArrayList<String[]>();
        places = new int[n];
        dfs(0, n);
        return result;
    }
    public static void main(String args[]) {
        new NQueens().solveNQueens(1);
    }
}
