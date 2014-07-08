package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class SherlockandArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int ar[] = new int[N];
            int left = 0, right = 0;
            for (int i = 0; i < N; i++) {
                ar[i] = in.nextInt();
                right += ar[i];
            }
            right -= ar[0];
            for(int i = 0; i < N-1; i++){
                if(left >= right){
                    break;
                }
                left += ar[i];
                right -= ar[i+1];
            }
            System.out.println((left==right)?"YES":"NO");
        }
    }
}
