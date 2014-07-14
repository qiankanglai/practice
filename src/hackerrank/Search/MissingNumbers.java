package hackerrank.Search;

import java.util.Scanner;

/**
 * Created by anthony on 7/14/14.
 */
public class MissingNumbers {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count[] = new int[20001];
        for(int i = 0; i < n; i++){
            int t = in.nextInt();
            count[t+10000]++;
        }
        int m = in.nextInt();
        for(int i = 0; i < m; i++){
            int t = in.nextInt();
            count[t+10000]--;
        }
        for(int i = 0; i < 20001; i++){
            if(count[i] < 0){
                System.out.print(i-10000);
                System.out.print(' ');
            }
        }
    }
}
