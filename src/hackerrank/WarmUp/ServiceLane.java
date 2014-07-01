package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class ServiceLane {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        int width[] = new int[N];
        for(int k = 0; k < N; k++){
            width[k] = in.nextInt();
        }
        for(int k = 0; k < T; k++){
            int i = in.nextInt();
            int j = in.nextInt();
            int min = width[i];
            if(min > 1) {
                for (int k2 = i+1; k2 <= j; k2++) {
                    if (min > width[k2]){
                        min = width[k2];
                        if(min == 1)
                            break;
                    }
                }
            }
            System.out.println(min);
        }
    }
}
