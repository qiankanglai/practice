package hackerrank.Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/13/14.
 */
public class Flowers {
    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);

        int N, K;
        N = in.nextInt();
        K = in.nextInt();

        int C[] = new int[N];
        for(int i=0; i<N; i++){
            C[i] = in.nextInt();
        }

        int result = 0;
        Arrays.sort(C);
        for(int i=0; i<N; i++){
            result += (i/K + 1) * C[N-1-i];
        }


        System.out.println( result );

    }
}
