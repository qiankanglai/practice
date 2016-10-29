package hihocoder;

import java.util.Scanner;

/**
 * Created by Anthony on 2016/7/17.
 */
public class test2 {
    public static int[] offsets = new int[25];
    public static void main(String[] args) {
        offsets[0] = 0;
        offsets[1] = 0;
        offsets[2] = 2;
        for(int i = 3; i < 25; i++)
        {
            offsets[i] = 1;
            for(int j = 0; j < i; j++)
                offsets[i] += offsets[j];
        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        for(int i = 0; i < m; i++)
        {
            int x1 = in.nextInt(), y1 = in.nextInt();
            int x2 = in.nextInt(), y2 = in.nextInt();
            System.out.println(calc(x1, y1, x2, y2, n));
        }
    }

    private static int calc(int x1, int y1, int x2, int y2, int n) {
        int sum = 0;
        if(y1 <= 0 && x1 <= 0 && y2 >= 0 && x2 >= 0) {
            x1 = 1;
            sum++; // root calculcate
        }
        if(x1 > x2) return sum;
        if(n >= 2) {
            int offset = offsets[n];
            sum += calc(x1-offset, y1 - offset, x2-offset, y2 - offset, n-1);
            sum += calc(x1-offset, y1 + offset, x2-offset, y2 + offset, n-1);
        }
        return sum;
    }
}
