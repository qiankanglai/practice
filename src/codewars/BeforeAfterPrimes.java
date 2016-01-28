package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class BeforeAfterPrimes {
    public static boolean isPrime(long num){
        for(int k = (int)Math.sqrt(num); k>=2; k--){
            if(num % k==0)return false;
        }
        return true;
    }
    public static long[] primeBefAft(long num) {
        long[] res = new long[2];
        for(long k = num-1; k>=1; k--)
        {
            if(isPrime(k))
            {
                res[0] = k;
                break;
            }
        }
        num++;
        while(!isPrime(num))
        {
            num++;
        }
        res[1] = num;
        return res;
    }
}
