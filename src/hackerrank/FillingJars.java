package hackerrank;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class FillingJars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        int M = in.nextInt();
        double sum = 0;
        for (int i = 0; i < M; i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long k = in.nextLong();
            double t = k * (b-a+1);
            sum += t/N;
        }
        System.out.println((long)sum);
    }
}
