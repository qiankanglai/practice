package hackerrank.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 8/4/14.
 */
public class RedJohnisBack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            System.out.println(solve(n));
        }

        in.close();
    }

    private static int solve(int n) {
        if(n <= 0)
            return 0;
        int s[] = new int[n];
        s[0] = 1;
        for(int i = 1; i < n; i++){
            s[i] = s[i-1];
            if(i == 3){
                s[i] += 1;
            }
            else if(i >= 4) {
                s[i] += s[i - 4];
            }
        }
        int r = s[n-1];
        if(r < 2)
            return 0;
        boolean s2[] = new boolean[r];
        Arrays.fill(s2, true);
        for(int j = 2; j * 2 <= r; j++){
            if(s2[j-1]){
                int k = j-1+j;
                while(k < r){
                    s2[k] = false;
                    k += j;
                }
            }
        }
        int count = 0;
        for(int j = 2; j <= r; j++){
            if(s2[j-1])
                count++;
        }
        return count;
    }
}
