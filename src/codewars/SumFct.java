package codewars;

import java.math.BigInteger;

/**
 * Created by qiank on 1/29/2016.
 */
public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        //4*(F_{n+2}-1)
        long t = n.longValue()+3;
        BigInteger a=BigInteger.ONE,b=BigInteger.ONE;
        for(int i = 2; i < t; i++)
        {
            BigInteger c=a.add(b);
            a=b;
            b=c;
        }
        b=b.add(BigInteger.valueOf(-1)).multiply(BigInteger.valueOf(4));
        return b;
    }

    public static void main(String args[])
    {
        System.out.println(perimeter(BigInteger.valueOf(30790)));
    }
}
