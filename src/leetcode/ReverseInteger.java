package leetcode;

/**
 * Created by anthony on 8/23/14.
 */
public class ReverseInteger {
    int reverse(int x) {
        boolean n = (x < 0);
        if(n)
            x = -x;
        int t = 0;
        while(x > 0){
            t = t*10+x%10;
            x = x /10;
        }
        if(n)
            t = -t;
        return t;
    }
}
