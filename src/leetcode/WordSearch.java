package leetcode;

/**
 * Created by Anthony on 2014/6/8.
 */
public class WordSearch {

    char[][] _board;
    char[] _word;
    int rows, cols;

    public boolean dfs(int x, int y, int offset){
        if(offset+1 >= _word.length)
            return true;

        _board[y][x] = '.';
        if(x+1 < cols && _board[y][x+1] == _word[offset+1]){
            if(dfs(x+1,y,offset+1))
                return true;
        }
        if(x-1 >= 0 && _board[y][x-1] == _word[offset+1]){
            if(dfs(x-1,y,offset+1))
                return true;
        }
        if(y+1 < rows && _board[y+1][x] == _word[offset+1]){
            if(dfs(x,y+1,offset+1))
                return true;
        }
        if(y-1 >= 0 && _board[y-1][x] == _word[offset+1]){
            if(dfs(x,y-1,offset+1))
                return true;
        }
        _board[y][x] = _word[offset];

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0 || board == null ||
                board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        rows = board.length;
        cols = board[0].length;
        _word = word.toCharArray();
        _board = board;

        for(int x = 0; x < cols; x++)
            for(int y = 0; y < rows; y++)
                if(board[y][x] == _word[0]){
                    if(dfs(x,y,0))
                        return true;
                }
        return false;
    }

    public static void main(String args[]){
        char[][] board = new char[3][];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','C','S'};
        board[2] = new char[]{'A','D','E','E'};

        System.out.println(new WordSearch().exist(board, "ABCCED"));
    }
}
