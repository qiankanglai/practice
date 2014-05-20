package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class Sqrtx {
    public int sqrt(int x) {
        if(x==0) return 0;

        long right = 1, left = x;
        while(left>right+1){
            long mid = right+(left-right)/2;
            if(mid*mid>x)
                left = mid;
            else
                right = mid;
        }
        return (int)right;
    }
    public static void main(String args[]){
        System.out.println(new Sqrtx().sqrt(2147395599));
    }
}
