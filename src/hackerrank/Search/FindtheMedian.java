package hackerrank.Search;

import java.util.Scanner;

/**
 * Created by anthony on 7/13/14.
 */
public class FindtheMedian {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(find(array, 0, n-1, n/2));
    }

    private static int find(int[] array, int start, int end, int kth) {
        if(start == end){
            return array[start];
        }
        else if(start > end){
            return -1;  //this shouldn't happen
        }
        int ptr = start;
        int pivot = array[end];
        for(int i = start; i < end; i++){
            if(array[i] < pivot){
                int t = array[ptr];
                array[ptr] = array[i];
                array[i] = t;
                ptr++;
            }
        }
        int t = array[ptr];
        array[ptr] = pivot;
        array[end] = t;

        if(ptr-start == kth){
            return array[ptr];
        }
        else if(ptr-start < kth){
            return find(array, ptr+1, end, kth-(ptr+1-start));
        }
        else{
            return find(array, start, ptr-1, kth);
        }
    }
}
