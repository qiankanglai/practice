package google.campustest2015.roundb;

import sun.security.util.BigInt;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Anthony on 9/15/2014.
 */
public class PasswordAttacker {
    private static long module = 1000000007;
    private static final BigInteger _module = BigInteger.valueOf(module);
    /* This is WRONG!!!
    Big C(m,n) should be infered by sum, not multiply!
    public static int numberOfCombination(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                    .divide(BigInteger.valueOf(k+1)).mod(_module);
        }
        return ret.intValue();
    }
    */
    public static long solve(int m, int n, long C[][]){
        long t[] = new long[m];
        t[0] = 1;
        for(int i = 1; i < m; i++){
            long temp = 1;
            for(int _t = 0; _t < n; _t++){
                temp *= i+1;
                temp %= module;
            }
            for(int j = 0; j < i; j++) {
                temp -= t[j] * C[i+1][j+1];
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
                ("src/google/campustest2015/roundb/A-large-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);

        long C[][] = new long[101][101];
        C[1][0] = 1;
        C[1][1] = 1;
        for(int i = 2; i <= 100; i++){
            C[i][0] = 1;
            for(int j = 1; j <= i; j++){
                C[i][j] = (C[i-1][j] + C[i-1][j-1]) % module;
            }
        }

        for (int _t = 0; _t < T; _t++) {
            int M = in.nextInt(), N = in.nextInt();

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");

            System.out.println(solve(M, N, C));
        }
        in.close();
    }
}
