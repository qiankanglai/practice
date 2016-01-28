package codewars;

/**
 * Created by qiank on 1/28/2016.
 */
public class DigPow {
    public static long digPow(int n, int p) {

        int k = (int)Math.log10(n) + p;
        long sum = 0;
        int n2 = n;
        while(n2>0)
        {
            sum += Math.pow(n2%10,k);
            n2/=10;
            k--;
        }
        if(sum % n == 0)
            return sum/n;
        return -1;
    }
}
