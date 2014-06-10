package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Anthony on 2014/6/10.
 */
public class SurroundedRegions {
    class Position{
        public int x,y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        int rows = board.length, columns = board[0].length;

        final int dx[] = {1,0,-1,0};
        final int dy[] = {0,1,0,-1};

        HashSet<Integer> donotfilp = new HashSet<Integer>();
        int count = 0;
        for(int y = 0; y < rows; y++){
            for(int x = 0; x < columns; x++){
                if(board[y][x] == 'O'){
                    count++;
                    Stack<Position> stack = new Stack<Position>();
                    stack.push(new Position(x, y));

                    while(!stack.empty()){
                        Position p = stack.pop();
                        if(board[p.y][p.x] != 'O')
                            continue;
                        board[p.y][p.x] = (char) count;

                        boolean flag = false;
                        for(int d = 0; d < 4; d++){
                            int x2 = p.x + dx[d], y2 = p.y + dy[d];
                            if(x2 < 0 || x2 >= columns || y2 < 0 || y2 >= rows){
                                flag = true;
                            }
                            else if(board[y2][x2] == 'O'){
                                stack.add(new Position(x2, y2));
                            }
                        }
                        if(flag)
                            donotfilp.add(count);
                    }
                }
            }
        }

        for(int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                if(board[y][x] != 'X'){
                    int c = board[y][x];
                    if(donotfilp.contains(c))
                        board[y][x] = 'O';
                    else
                        board[y][x] = 'X';
                }
            }
        }
    }
}
