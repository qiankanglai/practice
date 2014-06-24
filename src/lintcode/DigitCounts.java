package lintcode;

/**
 * Created by Anthony on 2014/6/24.
 */
public class DigitCounts {
    //param k : description of k
    //param n : description of n
    //return ans a integer
    public int digitCounts(int k, int n) {
        int count = 0;
        int ptr = 1, left = 0;
        while(n > 0){
            int current = n % 10;
            int right = n / 10;
            count += right * ptr;
            if(current > k)
                count += ptr;
            else if(current == k)
                count += left+1;

            n = right;
            left = ptr * current + left;
            ptr = ptr * 10;
        }
        return count;
    }

    public static void main(String args[]){
        System.out.println(new DigitCounts().digitCounts(1, 12));
    }
}
