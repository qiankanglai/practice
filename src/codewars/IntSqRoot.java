package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class IntSqRoot {
    public static long IntRac(long n, long guess)  {
        int count = 1;
        long guess2 = (guess + n / guess) /2;
        while(guess != guess2)
        {
            guess = guess2;
            count++;
            guess2 = (guess + n / guess) /2;
        }
        return count;
    }

    public static void main(String args[])
    {
        System.out.println(IntRac(25, 1));
    }
}
