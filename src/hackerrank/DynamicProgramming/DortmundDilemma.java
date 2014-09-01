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
        int N = 100000;
        //Result Array1: result[k][n] how many names with length = n and characters <= k
        long [][]result = new long[27][];
        for(int k = 1; k <= 26; k++){
            result[k] = solve2(N, k);
        }
        //Result Array2: result[k][n] how many names with length = n and characters = k
        for(int n = 1; n <= N; n++){
            for(int k = 1; k <= 26; k++){
                long sum = result[k][n];
                for(int i = 1; i < k; i++) {
                    sum -= result[i][n] * C[k][i];
                    while (sum < 0) {
                        sum = sum % modulo + modulo;
                    }
                }
                result[k][n] = sum % modulo;
            }
        }

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            long sum = (result[k][n] * C[26][k]) % modulo;
            System.out.println(sum);
        }
        in.close();
    }

    // make f(n,k) simpler!
    // f(n,k)=k*f(n-1,k)+ [xxx (if n%2 == 0)]
    private static long[] solve2(int n, int k) {
        long pow_cache = 1;

        long solve_cache[] = new long[Math.max(n+1, 2)];
        solve_cache[0] = 0;
        solve_cache[1] = 0;
        for(int _n = 2; _n <= n; _n++){
            long sum = (solve_cache[_n-1] * k) % modulo;
            if(_n % 2 == 0){
                pow_cache = (pow_cache * k) % modulo;
                sum += (pow_cache - solve_cache[_n/2]);
                while(sum < 0){
                    sum += modulo;
                }
            }
            solve_cache[_n] = sum % modulo;
        }
        return solve_cache;
    }

    /*
    f(n,k): how many names with length = n and characters <= k
    f(n,k) = sum_{i=1}^{n/2} ((k^i - f(i,k)) * k^{n-2*i})

    Use solve() like this:
    long sums[] = new long[k+1];
    sums[0] = 0;
    sums[1] = (n>1)?1:0;
    for(int _k = 2; _k <= k; _k++){
        sums[_k] = solve(n, _k);
        for(int i = 1; i < _k; i++){
            sums[_k] -= sums[i] * C[_k][i];
            while(sums[_k] < 0){
                sums[_k] += modulo;
            }
            sums[_k] = sums[_k] % modulo;
        }
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
