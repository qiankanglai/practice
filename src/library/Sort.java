package library;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Anthony on 2014/6/9.
 */
public class Sort {
    public static int[] RadixSort(int[] arr){
        int length = arr.length;
        int max = Math.abs(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int t = Math.abs(arr[i]);
            if(max < t) max = t;
        }
        max = Math.max(max, 3); //ensures base >= 2;
        int base = (int) Math.ceil(Math.sqrt(max));
        int bucket[] = new int[base*2];
        int arr2[]  = new int[arr.length];
        int exp = 1;
        while(exp > 0 && exp <= max){
            Arrays.fill(bucket, 0);
            for(int i = 0; i < arr.length; i++){
                int t = (arr[i] / exp) % base+base;
                bucket[t] ++;
            }
            for (int i = 1; i < base*2; i++) {
                bucket[i] += bucket[i - 1];
            }
            for(int i = arr.length-1; i >= 0; i--){
                int t = (arr[i] / exp) % base+base;
                arr2[--bucket[t]] = arr[i];
            }

            int []temp = arr;
            arr = arr2;
            arr2 = temp;

            exp *= base;    //it may overflow here...
        }
        return arr;
    }

    public static void main(String args[]){
        final int len = 10;
        int arr[] = new int[len];
        Random rand = new Random(0);
        for(int i = 0; i < len; i++)
            arr[i] = rand.nextInt();
        for(int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            System.out.print('\t');
        }
        System.out.println();
        arr = RadixSort(arr);
        for(int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}
