package hihocoder;

import java.util.Scanner;

/**
 * Created by anthony on 8/10/14.
 */
public class Week6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int need[] = new int[n], value[] = new int[n];
        for(int i = 0; i < n; i++){
            need[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        in.close();
        long cache1[] = new long[m+1];
        long cache2[] = new long[m+1];
        cache1[0] = 0;
        cache2[0] = 0;
        for(int i = 1; i <= Math.min(need[0]-1, m); i++)
            cache1[i] = 0;
        for(int i = Math.min(need[0], m); i <= m; i++)
            cache1[i] = value[0];
        for(int k = 1; k < n; k++){
            if(need[k] > m) {
                continue;
            }
            for(int i = 1; i <= Math.min(need[k]-1, m); i++)
                cache2[i] = cache1[i];
            for(int i = Math.min(need[k], m); i <= m; i++)
                cache2[i] = Math.max(cache1[i], value[k] + cache1[i-need[k]]);

            long[] temp = cache1;
            cache1 = cache2;
            cache2 = temp;
        }
        System.out.println(cache1[m]);
    }
}
