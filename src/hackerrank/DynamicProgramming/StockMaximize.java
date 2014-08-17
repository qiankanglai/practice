package hackerrank.DynamicProgramming;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by anthony on 8/7/14.
 */
public class StockMaximize {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            long ar[] = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextLong();
            }

            Stack<Long> temp = new Stack<Long>();
            long sum = 0;
            for(int i = n-1; i >= 0; i--){
                while(!temp.empty() && temp.peek() < ar[i]){
                    temp.pop();
                }
                if(temp.empty()){
                    temp.add(ar[i]);
                }
                else{
                    sum += temp.peek() - ar[i];
                }
            }
            System.out.println(sum);
        }
        in.close();
    }
}
