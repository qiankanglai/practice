package microsoft.AutumnCampus.Sudoku;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by anthony on 7/5/14.
 */
public class Sudoku {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/microsoft/AutumnCampus/Sudoku/SampleInput.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/microsoft/AutumnCampus/Sudoku/Sudoku.txt"));

        String temp = reader.readLine();
        while (temp != null && temp.length() > 0) {
            char[][] board = new char[9][9];
            for(int i = 0; i < 9; i++){
                char[] line = temp.toCharArray();
                for(int j = 0; j < 9; j++){
                    board[i][j] = line[2*j];
                }
                temp = reader.readLine();
            }

            new Sudoku().solveSudoku(board);
            for(int i = 0; i < 9; i++){
                writer.write(board[i][0]);
                for(int j = 1; j < 9; j++){
                    writer.write(" "+board[i][j]);
                }
                writer.newLine();
            }
            writer.newLine();

            temp = reader.readLine();
        }
        reader.close();
        writer.close();
    }

    // Copy from my leetcode solution: ValidSudoku
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
                if(board[x][y] != 'x'){
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
            int c = (board[x][y]=='x')?-1:(board[x][y]-'1');
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
                board[x][y] = 'x';
                ptr--;
            }
            if(ptr >= unknown.size())
                break;
        }
    }
}