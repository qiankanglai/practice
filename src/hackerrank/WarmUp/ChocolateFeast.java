package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++) {
            int N = in.nextInt();
            int C = in.nextInt();
            int M = in.nextInt();
            int sum = N/C;
            int temp = sum;
            while(temp >= M){
                int t = temp / M;
                sum += t;
                temp -= t*M;
                temp += t;
            }
            System.out.println(sum);
        }
    }
}
