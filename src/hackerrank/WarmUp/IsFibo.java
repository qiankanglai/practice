package hackerrank.WarmUp;

import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class IsFibo {
    public static void main(String[] args) {
        long fib[] = new long[10000];
        int ptr = 2;
        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int _t = 0; _t < T; _t++){
            long N = in.nextLong();
            while(fib[ptr] < N){
                ptr++;
                fib[ptr] = fib[ptr-1]+fib[ptr-2];
            }
            boolean found = false;
            int start = 0, end = ptr;
            while(start <= end){
                int mid = (start+end)/2;
                if(fib[mid] == N){
                    found = true;
                    break;
                }
                else if(fib[mid] < N)
                    start = mid+1;
                else
                    end = mid-1;
            }
            if(found)
                System.out.println("IsFibo");
            else
                System.out.println("IsNotFibo");
        }
    }
}
