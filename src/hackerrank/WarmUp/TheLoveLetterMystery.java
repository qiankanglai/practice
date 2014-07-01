package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class TheLoveLetterMystery {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for(int i = 0; i < T; i++) {
            char s[] = in.nextLine().toCharArray();
            int sum = 0;
            for(int k = 0; k*2 < s.length; k++){
                sum += Math.abs(s[k]-s[s.length-1-k]);
            }
            System.out.println(sum);
        }
    }
}
