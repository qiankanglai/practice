package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class QuickSort1Partition {
    static void partition(int[] ar) {
        int p = ar[0];
        int[] ar2 = new int[ar.length];
        int ptr1 = 0, ptr2 = 0;
        for(int i = 1; i < ar.length; i++){
            if(ar[i] <= p){
                ar[ptr1] = ar[i];
                ptr1++;
            }
            else{
                ar2[ptr2] = ar[i];
                ptr2++;
            }
        }
        ar[ptr1] = p;
        for(int i = 0; i < ptr2; i++){
            ar[ptr1+i+1] = ar2[i];
        }
        printArray(ar);
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        partition(ar);
    }
}
