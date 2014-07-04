package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class CountingSort3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[100];
        for (int i = 0; i < n; i++) {
            ar[in.nextInt()]++;
            in.nextLine();
        }
        for (int i = 1; i < 100; i++) {
            ar[i] += ar[i-1];
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(ar[i]);
            System.out.print(' ');
        }
    }
}
