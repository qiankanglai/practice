package hackerrank.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by Administrator on 2014/8/6.
 */
public class PlayGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            long ar[] = new long[n];
            for(int i = 0; i < n; i++){
                ar[i] = in.nextLong();
            }
            long sum = 0;
            long maxResult[] = new long[n];
            for(int i = 0; i < Math.min(3, n); i++){
                sum += ar[n-1-i];
                maxResult[n-1-i] = sum;
            }
            for(int i = 3; i < n; i++){
                sum += ar[n-1-i];
                long temp = Math.min(maxResult[n-1-i+1], Math.min(maxResult[n-1-i+2], maxResult[n-1-i+3]));
                maxResult[n-1-i] = sum - temp;
            }
            System.out.println(maxResult[0]);
        }

        in.close();
    }
}
