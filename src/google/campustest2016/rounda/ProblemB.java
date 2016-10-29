package google.campustest2016.rounda;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProblemB {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                //("src/google/campustest2016/rounda/B-small-practice.in"));
                ("src/google/campustest2016/rounda/B-small-attempt2.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int N = in.nextInt();
            int K = in.nextInt();

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(solve(A,B,N,K));
        }
    }

    private static long modula = 1000000007;
    private static long solve(int a, int b, int n, int k) {
        long []k_a = new long[k];
        long []k_b = new long[k];
        for(int i = 0; i < k; i++)
        {
            k_a[i] = pow_with_module(i, k, a);
            k_b[i] = pow_with_module(i, k, b);
        }
        long sum = 0;
        for(int i = 0; i < k; i++)
        {
            for(int j = 0; j < k; j++)
            {
                if((k_a[i]+k_b[j]) % k == 0)
                {
                    int a_candidates = (n+i)/k;
                    int b_candidates = (n+j)/k;
                    if(a_candidates <= 0 || b_candidates <= 0) continue;
                    if(i==j)
                    {
                        a_candidates--;
                    }
                    sum += (a_candidates % modula) * (b_candidates % modula);
                    sum = sum % modula;
                }
            }
        }
        return sum;
    }

    private static long pow_with_module(int i, int k, int exp) {
        if (exp == 0) return 0;
        if (exp == 1) return i % k;
        long r = pow_with_module(i, k, exp / 2);
        r = r * r;
        r = r % k;
        if (exp % 2 != 0)
            r = r * (i % k);
        return r % k;
    }
}
