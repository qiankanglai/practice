package google.campustest2015.roundb;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anthony on 9/15/2014.
 */
public class PasswordAttacker {
    public static long module = 1000000007;
    public static int numberOfCombination(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret.intValue();
    }

    public static long solve(int m, int n){
        long t[] = new long[m];
        t[0] = 1;
        for(int i = 1; i < m; i++){
            long temp = 1;
            for(int _t = 0; _t < n; _t++){
                temp *= i+1;
                temp %= module;
            }
            for(int j = 0; j < i; j++) {
                temp -= t[j] * numberOfCombination(i + 1, j + 1);
                temp %= module;
                if(temp < 0)
                    temp += module;
            }
            t[i] = temp;
        }
        return t[m-1];
    }

    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/roundb/A-small-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int M = in.nextInt(), N = in.nextInt();

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");

            System.out.println(solve(M, N));
        }
        in.close();
    }
}
