package hackerrank.ArraysandSorting;

/**
 * Created by anthony on 7/4/14.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class InsertionSortPart1 {



    public static void insertIntoSorted(int[] ar) {
        int len = ar.length;
        int V = ar[len-1];
        int i = len-2;
        while(i >= 0 && ar[i] > V){
            ar[i+1] = ar[i];
            i--;
            printArray(ar);
        }
        ar[i+1] = V;
        printArray(ar);
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }


}
