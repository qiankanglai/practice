package leetcode;

/**
 * Created by anthony on 5/17/14.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int d = (int)Math.floor(Math.log10(x));
        while(d > 0){
            int x2 = (int)(x / Math.pow(10, d));
            if(x % 10 != x2)
                return false;
            x = (x % (int)Math.pow(10, d))/10;
            d -= 2;
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(""+new PalindromeNumber().isPalindrome(1000110021));
    }
}
