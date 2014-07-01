package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class UtopianTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++) {
            int N = in.nextInt();
            int height = 1;
            for(int k = 0; k < N; k++){
                if(k % 2 == 1){
                    height++;
                }
                else{
                    height *= 2;
                }
            }
            System.out.println(height);
        }
    }
}
