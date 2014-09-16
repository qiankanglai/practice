package google.campustest2015.roundb;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Anthony on 9/15/2014.
 */
public class ParenthesesOrder {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/roundb/D-large-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            temp = in.nextLine();
            String t2[] = temp.split(" ");
            int n = Integer.valueOf(t2[0]);
            BigInteger k = new BigInteger(t2[1]);

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            if(k.compareTo(count(n, n)) > 0)
                System.out.println("Doesn't Exist!");
            else
                System.out.println(solve(n, k));
        }
        in.close();
    }

    static private BigInteger cache[][] = new BigInteger[101][101];
    private static BigInteger count(int left, int right){
        //ensure right >= left
        if(right == 0)
            return BigInteger.ONE;
        if(left < 0 || right < 0)
            return BigInteger.ZERO;
        if(cache[left][right] != null)
            return cache[left][right];
        BigInteger t = count(left-1, right);
        if(right > left)
            t = t.add(count(left, right - 1));
        cache[left][right] = t;
        return t;
    }

    private static String solve(int n, BigInteger k) {
        int left = n, right = n;
        StringBuilder sb = new StringBuilder();
        while(left > 0 && right > 0){
            if(left == right){
                sb.append("(");
                left--;
                continue;
            }
            BigInteger t = count(left-1, right);
            if(k.compareTo(t) > 0){
                sb.append(")");
                k = k.add(t.negate());
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
