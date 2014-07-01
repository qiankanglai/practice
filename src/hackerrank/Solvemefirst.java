package hackerrank;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class Solvemefirst {
    static int solveMeFirst(int a, int b) {
        return a+b;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int _a;
        _a = in.nextInt();
        int _b;
        _b = in.nextInt();
        int sum;
        sum = solveMeFirst(_a, _b);
        System.out.println(sum);
    }
}
