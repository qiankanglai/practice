package hackerrank.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by anthony on 8/7/14.
 */
public class DortmundDilemma {
    //https://www.hackerrank.com/challenges/dortmund-dilemma
    private static long A[][] = new long[27][27];
    private static long C[][] = new long[27][27];
    private static long count_cache[][][] = new long[100001][27][27];
    private static final long modulo = 1000000009;

    public static void main(String[] args) {
        for(int i = 1; i <= 26; i++){
            A[i][0] = 1;
            for(int j = 1; j <= i; j++){
                A[i][j] = A[i][j-1] * (i-j+1) % modulo;
            }
        }
        for(int i = 1; i <= 26; i++){
            C[i][0] = 1;
            for(int j = 1; j <= i; j++){
                C[i][j] = C[i][j-1] * (i-j+1) / j % modulo;
            }
        }

        //组成长度为n的串，其中k1个必须至少出现一次，k2随意
        for(int k2 = 0; k2 < 27; k2++){
            count_cache[0][0][k2] = 1;
        }
        for(int i = 1; i < 100001; i++){
            for(int k1 = 0; k1 < 27; k1++){
                for(int k2 = 0; k2 < 27-k1; k2++){
                    if(k1 > i){
                        count_cache[i][k1][k2] = 0;
                        continue;
                    }
                    else if(k1 == i){
                        count_cache[i][k1][k2] = A[k1][k1];
                        continue;
                    }

                    long sum = 0;
                    if(k1 > 0) {
                        sum += k1 * count_cache[i - 1][k1 - 1][k2 + 1] % modulo;
                    }
                    if(k2 > 0) {
                        sum += k2 * count_cache[i - 1][k1][k2] % modulo;
                    }
                    sum = sum % modulo;
                    count_cache[i][k1][k2] = sum;
                }
            }
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            int k = in.nextInt();
            long sum = solve(n, k);
            sum *= C[26][k];
            sum = sum % modulo;
            System.out.println(sum);
        }
        in.close();
    }

    private static long solve_cache[][] = new long[100001][27];
    private static long solve(int n, int k) {        //获得所有全排列
        if(n <= k)
            return 0;
        if(solve_cache[n][k] > 0)
            return solve_cache[n][k];
        long sum = 0;
        for(int i = 1; i <= n/2; i++){
            for(int _k = 1; _k <= Math.min(i, k); _k++){     //用_k元素构造prefix
                long t0 = C[k][_k];
                long t1 = count_cache[i][_k][0] - solve(i, _k);   //组成prefix/suffix，自身不重复
                if(t1 == 0)
                    continue;
                long t2 = 0;
                if(n == 2*i){
                    if(_k == k){
                        t2 = 1;
                    }
                }
                else {
                    t2 = count_cache[n-2*i][k-_k][_k];
                }
                sum += (t0*t1*t2) % modulo;
            }
        }
        solve_cache[n][k] = sum;
        return sum;
    }
}
