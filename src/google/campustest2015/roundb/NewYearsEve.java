package google.campustest2015.roundb;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Anthony on 9/15/2014.
 */
public class NewYearsEve {

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/roundb/B-large.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int B = in.nextInt(), L = in.nextInt(), N = in.nextInt();

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");

            double r = 250*Math.min(solve(B, L, N), 1);
            DecimalFormat   format   =   new DecimalFormat("0.000000");
            System.out.println(format.format(r));
        }
        in.close();
    }

    private static double solve(int b, int l, int n) {
        double [][]map1 = new double[l][l], map2 = new double[l][l];
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                map1[i][j] = 0;
                map2[i][j] = 0;
            }
        }
        map1[0][0] = b * 3;
        for(int _l = 2; _l <= l; _l++){
            for(int i = 0; i < _l; i++){
                for(int j = 0; j < _l; j++){
                    map2[i][j] = 0;
                }
            }
            for(int i = 0; i < _l; i++){
                for(int j = 0; j < _l; j++){
                    double t = (map1[i][j] - 1) / 3;
                    if(t > 0){
                        map2[i][j] += t;
                        map2[i+1][j] += t;
                        map2[i+1][j+1] += t;
                    }
                }
            }

            double [][] temp = map1;
            map1 = map2;
            map2 = temp;
        }
        int count = n;
        for(int i = 1; i <= l; i++){
            if(count <= i)
                return map1[i-1][count-1];
            count -= i;
        }
        return -1;
    }
}
