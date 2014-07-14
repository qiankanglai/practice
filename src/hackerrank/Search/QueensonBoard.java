package hackerrank.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anthony on 7/14/14.
 */
public class QueensonBoard {
    private static final int module = 1000000007;
    private static int m = 0, n = 0, count = 0;
    private static byte[][] isBlock = null;

    private static boolean available_row[][] = null;
    private static int row_id[][] = null;
    private static boolean available_column[][] = null;
    private static int column_id[][] = null;

    private static boolean available_diagona1[][] = null;
    private static int diagona1_id[][] = null;
    private static boolean available_diagona2[][] = null;
    private static int diagona2_id[][] = null;

    private static Integer candidates[] = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            n = in.nextInt();
            m = in.nextInt();
            in.nextLine();
            isBlock = new byte[n][m];
            for(int i = 0; i < n; i++){
                char []c = in.nextLine().toCharArray();
                for(int j = 0; j < m; j++) {
                    isBlock[i][j] = (byte) ((c[j]== '#')?-1:0);  //-1表示不可用；1表示访问过了
                }
            }
            //pre process
            available_row = new boolean[n][m+1];
            row_id = new int[n][m];
            for(int i = 0; i < n; i++){
                int ptr = 0;
                available_row[i][0] = true;
                for(int j = 0; j < m; j++){
                    if(isBlock[i][j] < 0){
                        ptr++;
                        available_row[i][ptr] = true;
                    }
                    else{
                        row_id[i][j] = ptr;
                    }
                }
            }
            available_column = new boolean[m][n+1];
            column_id = new int[n][m];
            for(int j = 0; j < m; j++){
                int ptr = 0;
                available_column[j][0] = true;
                for(int i = 0; i < n; i++){
                    if(isBlock[i][j] < 0){
                        ptr++;
                        available_column[j][ptr] = true;
                    }
                    else{
                        column_id[i][j] = ptr;
                    }
                }
            }

            available_diagona1 = new boolean[m+n][Math.max(m,n)+1];
            diagona1_id = new int[n][m];
            for(int i = 0; i < m+n-1; i++){
                //i=x+y
                int y = i, x = 0;
                if(y >= n){
                    y = n-1;
                    x = i-y;
                }
                int ptr = 0;
                available_diagona1[i][ptr] = true;
                while(x < m && y >= 0){
                    if(isBlock[y][x] < 0){
                        ptr++;
                        available_diagona1[i][ptr] = true;
                    }
                    else{
                        diagona1_id[y][x] = ptr;
                    }
                    x++;
                    y--;
                }
            }

            available_diagona2 = new boolean[m+n][Math.max(m,n)+1];
            diagona2_id = new int[n][m];
            for(int i = 0; i < m+n-1; i++) {
                //i=y-x+m-1
                int y = i, x = m-1;
                if(y >= n){
                    y = n-1;
                    x = y+m-1-i;
                }
                int ptr = 0;
                available_diagona2[i][ptr] = true;
                while(x >= 0 && y >= 0){
                    if(isBlock[y][x] < 0){
                        ptr++;
                        available_diagona2[i][ptr] = true;
                    }
                    else{
                        diagona2_id[y][x] = ptr;
                    }
                    y--;
                    x--;
                }
            }

            long result = 1;
            for(int i = 0; i < n*m; i++) {
                if(isBlock[i/m][i%m] == 0) {
                    ArrayList<Integer> _candidates = new ArrayList<Integer>();
                    dfs_build(i, _candidates);
                    candidates = _candidates.toArray(new Integer[0]);
                    Arrays.sort(candidates);

                    count = 0;
                    Stack<Integer> stack = new Stack<Integer>();

                    int i2 = 0;
                    while(true){
                        for(; i2 < candidates.length; i2++){
                            int y2 = candidates[i2] / m;
                            int x2 = candidates[i2] % m;
                            if(isBlock[y2][x2] < 0)
                                continue;
                            if(!available_row[y2][row_id[y2][x2]])
                                continue;
                            if(!available_column[x2][column_id[y2][x2]])
                                continue;
                            if(!available_diagona1[x2+y2][diagona1_id[y2][x2]])
                                continue;
                            if(!available_diagona2[y2-x2+m-1][diagona2_id[y2][x2]])
                                continue;
                            break;
                        }
                        if(i2 < candidates.length){
                            count++;
                            mark(candidates[i2], false);
                            stack.add(i2);
                            i2++;
                        }
                        else{
                            if(stack.empty()){
                                break;
                            }
                            i2 = stack.peek()+1;
                            mark(candidates[stack.peek()], true);
                            stack.pop();
                        }
                    }
                    result = result * (count+1) % module;
                    if(result == 0)
                        break;
                }
            }
            System.out.println(result-1);
        }
    }

    private static void mark(int idx, boolean b) {
        int y = idx / m;
        int x = idx % m;

        available_row[y][row_id[y][x]] = b;
        available_column[x][column_id[y][x]] = b;
        available_diagona1[x+y][diagona1_id[y][x]] = b;
        available_diagona2[y-x+m-1][diagona2_id[y][x]] = b;
    }

    private static void dfs_build(int idx, ArrayList<Integer> _candidates) {
        _candidates.add(idx);
        isBlock[idx/m][idx%m] = 1;
        final int d[] = {-m,-1,1,m,-m-1,-m+1,m-1,m+1};
        for(int i = 0; i < d.length; i++){
            int idx2 = idx + d[i];
            if(idx2 < 0 || idx2 >= m*n)
                continue;
            if(isBlock[idx2/m][idx2%m] == 0){
                dfs_build(idx2, _candidates);
            }
        }
    }
}
