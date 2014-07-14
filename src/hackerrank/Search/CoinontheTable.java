package hackerrank.Search;

import java.util.Scanner;

/**
 * Created by anthony on 7/14/14.
 */
public class CoinontheTable {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        char board[][] = new char[n][];
        in.nextLine();
        int tx = -1, ty = -1;
        for(int i = 0; i < n; i++){
            String line = in.nextLine();
            board[i] = line.toCharArray();
            for(int j = 0; j < m; j++){
                if(board[i][j] == '*'){
                    ty = i;
                    tx = j;
                }
            }
        }
        int dist1[][] = new int[n][m];
        int dist2[][] = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist1[i][j] = -1;
                dist2[i][j] = -1;
            }
        }
        dist1[0][0] = 0;
        final int dx[] = {0, 1, 0, -1};
        final int dy[] = {-1, 0, 1, 0};
        final char d[] = {'U', 'R', 'D', 'L'};
        for(int _k = 0; _k < k; _k++){
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(dist1[i][j] < 0)
                        continue;
                    if(dist2[i][j] < 0 || dist1[i][j] < dist2[i][j])
                        dist2[i][j] = dist1[i][j];
                    if(board[i][j] == '*')
                        continue;
                    for(int _d = 0; _d < 4; _d++){
                        int x2 = j + dx[_d], y2 = i + dy[_d];
                        if(x2 < 0 || x2 >= m || y2 < 0 || y2 >= n)
                            continue;
                        int newd = dist1[i][j] + (board[i][j] == d[_d] ? 0 : 1);
                        if(dist2[y2][x2] < 0 || dist2[y2][x2] > newd){
                            dist2[y2][x2] = newd;
                        }
                    }
                }
            }
            int[][] t = dist1;
            dist1 = dist2;
            dist2 = t;
        }
        System.out.println(dist1[ty][tx]);
    }
}
