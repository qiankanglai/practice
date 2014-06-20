package library;

/**
 * Created by Anthony on 2014/6/20.
 */
public class Math {
    public static final double EPISLON = 1e-6;
    //bisection
    public static double sqrt1(double x){
        if(x < 0){
            throw new ArithmeticException("negative numbers");
        }
        double low = 0, high = x, mid = 0;
        while(java.lang.Math.abs(low - high)>EPISLON){
            mid = (low + high) / 2;
            if(mid * mid > x)
                high = mid;
            else
                low = mid;
        }
        return mid;
    }
    //newton: http://www.matrix67.com/blog/archives/361
    public static double sqrt2(double x) {
        if (x < 0) {
            throw new ArithmeticException("negative numbers");
        }
        else if(x == 0){
            return 0;
        }
        double x1 = x;
        while(java.lang.Math.abs(x - x1*x1)>EPISLON){
            x1 = (x1 + x / x1) / 2;
        }
        return x1;
    }

    public static void main(String args[]){
        System.out.println(Math.sqrt2(1000));
    }
}
