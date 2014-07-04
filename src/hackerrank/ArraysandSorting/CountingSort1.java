package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class CountingSort1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[100];
        for (int i = 0; i < n; i++) {
            ar[in.nextInt()]++;
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(ar[i]);
            System.out.print(' ');
        }
    }
}
