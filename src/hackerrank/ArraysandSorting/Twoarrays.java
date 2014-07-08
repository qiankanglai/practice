package hackerrank.ArraysandSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class Twoarrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t = 0; t < T; t++){
            int N = in.nextInt();
            int K = in.nextInt();
            int A[] = new int[N];
            int B[] = new int[N];
            for(int i = 0; i < N; i++){
                A[i] = in.nextInt();
            }
            for(int i = 0; i < N; i++){
                B[i] = in.nextInt();
            }
            Arrays.sort(A);
            Arrays.sort(B);
            int i = 0;
            for(; i < N; i++){
                if(A[i] + B[N-1-i] < K){
                    break;
                }
            }
            System.out.println((i >= N)?"YES":"NO");
        }
    }
}
