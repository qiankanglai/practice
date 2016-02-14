package codewars;

/**
 * Created by anthony on 2/12/16.
 */
public class Suite {
    public static double going(int n) {
        double sum = 1;
        double inv = 1;
        for(int i = n; i >= 2; i--){
            inv = inv / i;
            sum += inv;
        }
        sum = Math.floor(sum*1e6)/1e6;
        return sum;
    }

    public static void main(String args[]){
        System.out.println(going(6));
    }
}
