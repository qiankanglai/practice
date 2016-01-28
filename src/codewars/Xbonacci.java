package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        double []res = new double[n];
        if(n < 3)
        {
            for(int i =0;i<n;i++) res[i] = s[i];
            return res;
        }
        for(int i = 0; i < 3; i++)
        {
            res[i] = s[i];
        }
        for(int i =3;i<n;i++)
        {
            res[i] = res[i-1]+res[i-2]+res[i-3];
        }
        return res;
    }
}
