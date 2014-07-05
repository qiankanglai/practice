package hackerrank.ArraysandSorting;

/**
 * Created by anthony on 7/4/14.
 */

import java.util.Scanner;

public class InsertionSortPart2 {

    public static void insertionSortPart2(int[] ar)
    {
        int len = ar.length;
        for(int i = 1; i < len; i++){
            for(int j = i; j >= 1; j--){
                if(ar[j] < ar[j-1]){
                    int t = ar[j];
                    ar[j] = ar[j-1];
                    ar[j-1] = t;
                }
                else{
                    break;
                }
            }
            printArray(ar);
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
