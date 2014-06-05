package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/5.
 */
public class SudokuSolver {
    class Position{
        int x,y;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public void solveSudoku(char[][] board) {
        boolean block[][] = new boolean[9][9];
        boolean row[][] = new boolean[9][9];
        boolean column[][] = new boolean[9][9];
        ArrayList<Position> unknown = new ArrayList<Position>();

        for(int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++){
                if(board[x][y] != '.'){
                    int c = board[x][y]-'1';
                    row[y][c] = true;
                    column[x][c] = true;

                    block[(y/3)*3+(x/3)][c] = true;
                }
                else
                    unknown.add(new Position(x,y));
            }
        }

        int ptr = 0;
        boolean flag = true;
        while(ptr >= 0){
            int x = unknown.get(ptr).x;
            int y = unknown.get(ptr).y;
            int c = (board[x][y]=='.')?-1:(board[x][y]-'1');
            if(c >= 0){
                row[y][c] = false;
                column[x][c] = false;
                block[(y/3)*3+(x/3)][c] = false;
            }
            c++;
            for(;c<9;c++){
                if(!row[y][c] && !column[x][c] && !block[(y/3)*3+(x/3)][c])
                    break;
            }
            if(c < 9){
                row[y][c] = true;
                column[x][c] = true;
                block[(y/3)*3+(x/3)][c] = true;
                board[x][y] = (char) ('1'+c);
                ptr++;
            }
            else{
                board[x][y] = '.';
                ptr--;
            }
            if(ptr >= unknown.size())
                break;
        }
    }
}
