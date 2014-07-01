package hackerrank;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class ManasaandStones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(a > b){
                a = a+b;
                b = a-b;
                a = a-b;
            }
            long s = a*(n-1);
            System.out.print(s);
            if(a < b) {
                for (int k = 1; k < n; k++) {
                    s += (b - a);
                    System.out.print(' ');
                    System.out.print(s);
                }
            }
            System.out.println();
        }
    }
}
