package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class SherlockandTheBeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++){
            long N = in.nextLong();
            long fives = (N/3) * 3;
            long threes = N-fives;
            while(fives >= 0){
                if(threes % 5 == 0)
                    break;
                fives -= 3;
                threes += 3;
            }
            if(fives < 0){
                System.out.println(-1);
            }
            else{
                StringBuilder sb = new StringBuilder();
                for(long t = 0; t < fives; t++){
                    sb.append('5');
                }
                for(long t = 0; t < threes; t++){
                    sb.append('3');
                }
                System.out.println(sb.toString());
            }
        }
    }
}
