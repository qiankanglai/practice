package hackerrank.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by anthony on 8/7/14.
 */
public class DortmundDilemma {
    //https://www.hackerrank.com/challenges/dortmund-dilemma
    private static long C[][] = new long[27][27];
    private static final long modulo = 1000000009;

    public static void main(String[] args) {
        for(int i = 1; i <= 26; i++){
            C[i][0] = 1;
            for(int j = 1; j <= i; j++){
                C[i][j] = C[i][j-1] * (i-j+1) / j % modulo;
            }
        }

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            long sum = solve(n, k) - solve(n, k-1)*k;
            sum = sum % modulo;
            sum *= C[26][k];
            sum = sum % modulo;
            System.out.println(sum);
        }
        in.close();
    }
    /*
    public static long pow(int k, int i){
        long t = 1;
        for(int j = 0; j < i; j++){
            t *= k;
        }
        return t;
    }

    private static long solve(int n, int k) {
        if(n <= 1)
            return 0;
        long sum = 0;
        for(int i = 1; i <= n/2; i++){
            sum  += (pow(k, i) - solve(i, k)) * pow(k, n-2*i);
        }
        return sum;
    }
    */

    private static long solve(int n, int k) {
        if (n <= 1)
            return 0;
        long pow_cache[] = new long[n+1];
        pow_cache[0] = 1;
        for(int i = 1; i <= n; i++){
            pow_cache[i] = (k * pow_cache[i-1]) % modulo;
        }
        long solve_cache[] = new long[Math.max(n+1, 2)];
        solve_cache[0] = 0;
        solve_cache[1] = 0;
        for(int _n = 2; _n <= n; _n++){
            long sum = 0;
            for(int i = 1; i <= _n/2; i++){
                sum  += ((pow_cache[i] - solve_cache[i]) * pow_cache[_n-2*i]) % modulo;
            }
            solve_cache[_n] = sum % modulo;
        }
        return solve_cache[n];
    }
}
