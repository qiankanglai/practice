package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class Arrays {
    public static int findSmallest( final int[] numbers, final String toReturn ) {
        int idx = 0;
        for(int i =1;i<numbers.length;i++)
        {
            if(numbers[i] < numbers[idx])
            {
                idx=i;
            }
        }
        return (toReturn.equals("value") ? numbers[idx]:idx);
    }
}
