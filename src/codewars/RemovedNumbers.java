package codewars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by qiank on 1/30/2016.
 */
public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> res = new ArrayList();
        long sum = (n+1)*n/2;
        for(long x=1; x<=n-1; x++)
        {
            long s2 = sum-x;
            long min = (s2-n)/x, max=(s2-x-1)/x;
            if(min <= x) min=x+1;
            if(max >n) max=n;
            for(long y=min;y<=max;y++)
            {
                if(x*y==s2-y)
                {
                    res.add(new long[]{x, y});
                    res.add(new long[]{y, x});
                }
            }
        }
        res.sort(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o1[0]-o2[0]);
            }
        });
        return res;
    }

    public static void main(String args[])
    {
        List<long[]> res = RemovedNumbers.removNb(26);
    }
}
