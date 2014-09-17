package google.campustest2015.rounda;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Anthony on 9/17/2014.
 */
public class Super2048 {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/rounda/B-small-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int N = in.nextInt();
            String dir = in.nextLine().trim();
            int map[][] = new int[N][N];
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    map[i][j] = in.nextInt();
                }
            }
            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.println(":");
            if(dir.equals("left"))
                solve(map, N, 0, 0, 0, 1, 1, 0);
            else if(dir.equals("right"))
                solve(map, N, N-1, 0, 0, 1, -1, 0);
            else if(dir.equals("down"))
                solve(map, N, 0, N-1, 1, 0, 0, -1);
            else if(dir.equals("up"))
                solve(map, N, 0, 0, 1, 0, 0, 1);
            else
                System.err.println("ERROR");

            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    System.out.print(""+map[i][j]+" ");
                }
                System.out.println();
            }
        }
        in.close();
    }

    private static void solve(int[][] map, int n, int x0, int y0, int dx0, int dy0, int dx, int dy) {
        for(int i = 0; i < n; i++){
            Stack<Integer> stack = new Stack<Integer>();
            int x = x0;
            int y = y0;
            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(map[y][x] > 0){
                    if(!stack.empty() && stack.peek() == map[y][x] && flag){
                        stack.pop();
                        stack.push(2 * map[y][x]);
                        flag = false;
                    }
                    else{
                        stack.push(map[y][x]);
                        flag = true;
                    }
                }
                x += dx;
                y += dy;
            }

            Stack<Integer> stack_reverse = new Stack<Integer>();
            while(!stack.empty()){
                stack_reverse.push(stack.pop());
            }
            x = x0;
            y = y0;
            for(int j = 0; j < n; j++){
                if(stack_reverse.empty()){
                    map[y][x] = 0;
                }
                else{
                    map[y][x] = stack_reverse.pop();
                }
                x += dx;
                y += dy;
            }

            x0 += dx0;
            y0 += dy0;
        }
    }
}
