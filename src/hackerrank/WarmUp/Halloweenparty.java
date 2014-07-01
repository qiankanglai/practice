package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class Halloweenparty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++) {
            int K = in.nextInt();
            long k1 = K/2, k2 = K-k1;
            System.out.println(k1 * k2);
        }
    }
}
