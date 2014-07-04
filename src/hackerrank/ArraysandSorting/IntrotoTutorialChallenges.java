package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class IntrotoTutorialChallenges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            if(t == n){
                System.out.println(i);
                return;
            }
        }
    }
}
