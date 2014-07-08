package hackerrank.ArraysandSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class RunningTimeofQuicksort {
    static int partition(int[] ar, int start, int end) {
        int p = ar[end];
        int ptr1 = start;
        for(int i = start; i < end; i++){
            if(ar[i] <= p){
                shifts++;
                int t = ar[ptr1];
                ar[ptr1] = ar[i];
                ar[i] = t;
                ptr1++;
            }
        }
        ar[end] = ar[ptr1];
        ar[ptr1] = p;
        shifts++;
        return ptr1;
    }
    static void quickSort(int[] ar, int start, int end) {
        if(start >= end)
            return;
        int pivot = partition(ar, start, end);
        quickSort(ar, start, pivot-1);
        quickSort(ar, pivot + 1, end);
    }
    static int shifts = 0;
    static int quickSort(int[] ar) {
        shifts = 0;
        quickSort(ar, 0, ar.length-1);
        return shifts;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        System.out.println(insertionSort(Arrays.copyOf(ar, ar.length))-quickSort(ar));
    }

    public static int insertionSort(int[] A) {
        int shifts = 0;
        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value) {    //原来j > 0有问题
                A[j + 1] = A[j];
                j = j - 1;
                shifts++;
            }
            A[j + 1] = value;
        }
        return shifts;
    }
}
