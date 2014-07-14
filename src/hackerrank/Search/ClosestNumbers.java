package hackerrank.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/13/14.
 */
public class ClosestNumbers {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        ArrayList<Integer> result = new ArrayList<Integer>();
        int min = array[1] - array[0];
        for (int i = 0; i < n - 1; i++) {
            int m2 = array[i + 1] - array[i];
            if (min > m2) {
                min = m2;
                result.clear();
            }
            if (min == m2) {
                result.add(array[i]);
                result.add(array[i + 1]);
            }
        }
        for (Integer i : result) {
            System.out.print(i);
            System.out.print(' ');
        }
    }
}
