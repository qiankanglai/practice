package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/20.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean []visited = new boolean[10];
        for(int i = 0; i < 9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int c = board[i][j]-'0';
                    if(visited[c])
                        return false;
                    else
                        visited[c] = true;
                }
            }
        }
        for(int i = 0; i < 9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    int c = board[j][i]-'0';
                    if(visited[c])
                        return false;
                    else
                        visited[c] = true;
                }
            }
        }
        for(int i1 = 0; i1 < 9; i1+=3){
            for(int j1 = 0; j1 < 9; j1+=3){
                Arrays.fill(visited, false);
                for(int i2 = 0; i2 < 3; i2++){
                    for(int j2 = 0; j2 < 3; j2++){
                        if(board[i1+i2][j1+j2] != '.'){
                            int c = board[i1+i2][j1+j2]-'0';
                            if(visited[c])
                                return false;
                            else
                                visited[c] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
