package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class Powxn {
    public double pow(double x, int n) {
        if(x == 1.0) return 1.0;
        if(x == -1.0) return (n%2==1)?-1:1;
        if(n == 0) return 1;
        if(n < 0) return 1/pow(x, -n);


        double _x = pow(x, n/2);
        _x = _x * _x;
        if(n%2==1)
            _x = _x*x;
        return _x;
    }
}
