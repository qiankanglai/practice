package google.campustest2015.roundb;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Anthony on 9/15/2014.
 */
public class ParenthesesOrder {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/roundb/D-large.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int n = in.nextInt();
            long k = in.nextLong();

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            if(k > count(n, n))
                System.out.println("Doesn't Exist!");
            else
                System.out.println(solve(n, k));
        }
        in.close();
    }

    static private long cache[][] = new long[101][101];
    private static long count(int left, int right){
        //ensure right >= left
        if(right == 0)
            return 1;
        if(left < 0 || right < 0)
            return 0;
        if(cache[left][right] > 0)
            return cache[left][right];
        long t = count(left-1, right);
        if(right > left)
            t += count(left, right-1);
        cache[left][right] = t;
        return t;
    }

    private static String solve(int n, long k) {
        int left = n, right = n;
        StringBuilder sb = new StringBuilder();
        while(left > 0 && right > 0){
            if(left == right){
                sb.append("(");
                left--;
                continue;
            }
            long t = count(left-1, right);
            if(k > t){
                sb.append(")");
                k -= t;
                right--;
            }
            else{
                sb.append("(");
                left--;
            }
        }
        while(left > 0){
            sb.append("(");
            left--;
        }
        while(right > 0){
            sb.append(")");
            right--;
        }
        return sb.toString();
    }
}
