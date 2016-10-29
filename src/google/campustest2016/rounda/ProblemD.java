package google.campustest2016.rounda;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Anthony on 2016/8/28.
 */
public class ProblemD {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2016/rounda/D-small-practice.in"));
                //("src/google/campustest2016/rounda/D-small-attempt0.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int N = in.nextInt();
            int M = in.nextInt();

            int result = 0;
            int sum = 0;
            for(int k =1;k<=N;k++)
            {
                sum += (k*k) % M;
                sum %= M;
                result = (result + sum) % M;
            }

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(result);
        }
    }
}
