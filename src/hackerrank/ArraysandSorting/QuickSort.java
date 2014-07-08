package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class QuickSort {
    static int partition(int[] ar, int start, int end) {
        int p = ar[start];
        int[] ar2 = new int[end-start];
        int ptr1 = start, ptr2 = 0;
        for(int i = start+1; i <= end; i++){
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
        return ptr1;
    }
    static void quickSort(int[] ar, int start, int end) {
        if(start >= end)
            return;
        int pivot = partition(ar, start, end);
        quickSort(ar, start, pivot-1);
        quickSort(ar, pivot+1, end);
        printArray(ar, start, end);
    }

    static void quickSort(int[] ar) {
        quickSort(ar, 0, ar.length-1);
    }

    static void printArray(int[] ar, int start, int end) {
        for(int i = start; i <= end; i++){
            System.out.print(ar[i]+" ");
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
        quickSort(ar);
    }
}
