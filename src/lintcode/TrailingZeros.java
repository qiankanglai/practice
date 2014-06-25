package lintcode;

/**
 * Created by Anthony on 2014/6/24.
 */
public class TrailingZeros {
    //param n : description of n
    //return: description of return
    public long trailingZeros(long n) {
        long five = 0;
        long temp = 5;
        while(n > temp){
            five += n / temp;
            temp *= 5;
        }
        return five;
    }
}
