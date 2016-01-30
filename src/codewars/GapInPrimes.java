package codewars;

/**
 * Created by qiank on 1/29/2016.
 */
public class GapInPrimes {
    private static boolean isPrime(long x)
    {
        long xx = (long)Math.sqrt(x);
        for(long i=2;i<=xx;i++)
        {
            if(x%i==0) return false;
        }
        return true;
    }
    public static long[] gap(int g, long m, long n) {
        if(m <2) m=2;
        for(long x=m;x<=n-g;x++)
        {
            if(!isPrime(x)) continue;
            if(!isPrime(x+g)) continue;
            int j=g-1;
            for(;j>0;j--) {
                if (isPrime(x+j)){
                    x+=j-1;
                    break;
                }
            }
            if(j<=0)
                return new long[]{x, x+g};
        }
        return null;
    }

    public static void main(String args[])
    {
        long []t=GapInPrimes.gap(10,300,400);
        if(t!=null) {
            System.out.println(t[0]);
            System.out.println(t[1]);
        }
    }
}
