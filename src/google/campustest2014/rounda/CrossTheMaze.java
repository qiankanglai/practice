package google.campustest2014.rounda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 8/20/14.
 */
public class CrossTheMaze {
    // N, E, S, W
    private static final int dx[] = {0, 1, 0, -1};
    private static final int dy[] = {-1, 0, 1, 0};
    private static final char dir[] = {'N', 'E', 'S', 'W'};

    private static boolean isMoveable(int x, int y, int n, char[][] map){
        if(x < 1 || y < 1)
            return false;
        if(x > n || y > n)
            return false;
        return map[y-1][x-1]=='.';
    }
    private static boolean isBrick(int x, int y, int n, char[][] map){
        if(x < 1 || y < 1)
            return true;
        if(x > n || y > n)
            return true;
        return map[y-1][x-1]!='.';
    }

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2014/rounda/D-large-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int n = in.nextInt();
            in.nextLine();
            char map[][] = new char[n][];
            for(int i = 0; i < n; i++){
                String line = in.nextLine();
                map[i] = Arrays.copyOf(line.toCharArray(), n);
            }
            int sy = in.nextInt(), sx = in.nextInt();
            int ey = in.nextInt(), ex = in.nextInt();
            int count = 0;
            ArrayList<Character> steps = new ArrayList<Character>();
            int d = (sx == 1)?0:2;    //Be careful here
            while((sx != ex || sy != ey) && steps.size() <= 10000){
                if(isMoveable(sx+dx[d], sy+dy[d], n, map)) {
                    sx += dx[d];
                    sy += dy[d];
                    steps.add(dir[d]);

                    if(sx==ex && sy==ey){    //WTF
                        break;
                    }
                    int d2 = (d+3)%4;
                    if(!isBrick(sx+dx[d2], sy+dy[d2], n, map)){
                        d = d2;
                        sx += dx[d];
                        sy += dy[d];
                        steps.add(dir[d]);
                    }
                    count = 0;
                }
                else{
                    d = (d+1)%4;
                    count ++;
                }
                if(count > 4){
                    break;
                }
            }

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            if(sx == ex && sy == ey){
                System.out.println(steps.size());
                for(Character c : steps){
                    System.out.print(c);
                }
                System.out.println();
            }
            else{
                System.out.println("Edison ran out of energy.");
            }
        }
        in.close();
    }
}
