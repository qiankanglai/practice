package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class InsertionSortAdvancedAnalysis {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.nextInt();
                //System.err.println(ar[j]);
            }
            int c = insertSort(ar);
            System.out.println(c);
        }
    }


    public static int insertSort(int[] ar)
    {
        int len = ar.length;
        int count = 0;
        for(int i = 1; i < len; i++){
            for(int j = i; j >= 1; j--){
                if(ar[j] < ar[j-1]){
                    int t = ar[j];
                    ar[j] = ar[j-1];
                    ar[j-1] = t;
                    count++;
                }
                else{
                    break;
                }
            }
        }
        return count;
    }
}
