package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/6.
 */
public class NQueensII {
    int count;
    int[] places;

    public void dfs(int level, int n){
        if(level >= n){
            count++;
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
    public int totalNQueens(int n) {
        count = 0;
        places = new int[n];
        dfs(0, n);
        return count;
    }
}
