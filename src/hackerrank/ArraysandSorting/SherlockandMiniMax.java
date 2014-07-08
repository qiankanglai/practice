package hackerrank.ArraysandSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class SherlockandMiniMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long ar[] = new long[N];
        for (int i = 0; i < N; i++) {
            ar[i] = in.nextLong();
        }
        long P = in.nextLong(), Q = in.nextLong();
        Arrays.sort(ar);

        long M = 0, max = 0;
        if(ar[0]-P > max){
            M = P;
            max = ar[0] - P;
        }
        for(int i = 0; i < N-1; i++){
            long l = Math.max(P, ar[i]);
            long r = Math.min(Q, ar[i+1]);
            if(l > r){
                continue;
            }
            long mid = (ar[i] + ar[i+1]) / 2;
            if(mid < l)
                mid = l;
            else if(mid > r)
                mid = r;
            long m2 = Math.min(Math.abs(mid-ar[i]), Math.abs(mid-ar[i+1]));
            if(m2 > max){
                M = mid;
                max = m2;
            }
        }
        if(Q-ar[N-1] > max){
            M = Q;
            max = Q - ar[0];
        }
        System.out.println(M);
    }
}
