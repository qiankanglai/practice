package hihocoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 8/5/14.
 */
public class Week5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n <= 0) {
            System.out.println(0);
            return;
        }
        int ar[][] = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ar[i - 1][j - 1] = in.nextInt();
            }
        }
        int temp[] = Arrays.copyOf(ar[n-1], n);
        int temp2[] = new int[n];
        for(int i = n-1; i >= 1; i--){
            for(int j = 1; j<=i; j++){
                temp2[j-1] = Math.max(temp[j-1], temp[j-1+1])+ar[i-1][j-1];
            }
            int []t = temp;
            temp = temp2;
            temp2 = t;
        }
        System.out.println(temp[0]);
    }
}
