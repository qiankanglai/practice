package codewars;

/**
 * Created by Anthony on 1/29/2016.
 */
public class Suite2 {
    public static long frac(long a, long b){
        while(a!=b){
            if(a>b)
            {
                long t=a;
                a=b;
                b=t;
            }
            b=b%a;
            if(b==0) return a;
        }
        return a;
    }
    public static String game2(long n) {
        if(n<=0) return "[0]";
        long f1 = 1, f2=2;
        for(long i=1;i<=n;i++)
        {
            for(long j=1;j<=n;j++)
            {
                if(i==1&&j==1)
                {
                    continue;
                }
                long g1= j, g2=i+j;

                long h1=f1*g2+f2*g1, h2=f2*g2;
                long tmp = frac(h1, h2);
                f1=h1/tmp;
                f2=h2/tmp;
            }
        }
        if(f2 == 1)
            return "["+f1+"]";
        else
            return "["+f1+", "+f2+"]";
    }
    public static String game(long n){
        //sum_{m=1}^{k}sum_{n=1}^{k}\frac{m}{m+n}=\frac{1}{2}*k*k
        n=n*n;
        if(n%2==0)
            return "["+(n/2)+"]";
        else
            return "["+n+", 2]";
    }

    public static void main(String args[])
    {
        System.out.println(game(7));
    }
}
