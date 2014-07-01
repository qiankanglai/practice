package hackerrank;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class MaximizingXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int R = in.nextInt();
        int sum = 0, bit = 1;
        while(R > 0){
            if(R > L){
                sum += bit;
            }
            L /= 2;
            R /= 2;
            bit *= 2;
        }
        System.out.println(sum);
    }
}
