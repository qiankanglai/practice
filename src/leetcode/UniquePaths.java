package leetcode;

/**
 * Created by Anthony on 2014/5/12.
 */
public class UniquePaths {
    long gcd(long a, long b) {
        while(b>0) {
            long c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    public int uniquePaths(int m, int n) {
        m--;n--;
        if(m==0)
            return 1;
        if(n==0)
            return 1;
        long a=1,b=1;
        for(int i =1;i<=n;i++){
            a *= (i+m);
            b *= i;
            long t=gcd(a,b);
            if(t>0){
                a /= t;
                b /= t;
            }
        }
        return (int)(a/b);
    }

    public static void main(String args[]){
        System.out.println(new UniquePaths().uniquePaths(13,23));
    }
}
