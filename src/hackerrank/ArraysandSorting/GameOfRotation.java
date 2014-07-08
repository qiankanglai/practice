package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class GameOfRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long ar[] = new long[N];
        long currentPMEAN = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            ar[i] = in.nextLong();
            sum += ar[i];
            currentPMEAN += ar[i] * (i+1);
        }
        long maxPMEAN = currentPMEAN;
        for(int i = 0; i < N; i++){
            currentPMEAN += ar[i] * N - sum;
            if(maxPMEAN < currentPMEAN)
                maxPMEAN = currentPMEAN;
        }
        System.out.println(maxPMEAN);
    }
}
