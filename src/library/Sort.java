package library;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Anthony on 2014/6/9.
 */
public class Sort {
    public static void RadixSort(int[] arr){
        int length = arr.length;
        int max = java.lang.Math.abs(arr[0]);
        for(int i = 1; i < length; i++){
            int t = java.lang.Math.abs(arr[i]);
            if(max < t) max = t;
        }
        max = java.lang.Math.max(max, 3); //ensures base >= 2;
        int base = (int) java.lang.Math.ceil(java.lang.Math.sqrt(max));
        int bucket[] = new int[base*2];
        int arr2[]  = new int[length];
        int exp = 1;
        while(exp > 0 && exp <= max){
            Arrays.fill(bucket, 0);
            for(int i = 0; i < length; i++){
                int t = (arr[i] / exp) % base+base;
                bucket[t] ++;
            }
            for (int i = 1; i < base*2; i++) {
                bucket[i] += bucket[i - 1];
            }
            for(int i = length-1; i >= 0; i--){
                int t = (arr[i] / exp) % base+base;
                arr2[--bucket[t]] = arr[i];
            }

            int []temp = arr;
            arr = arr2;
            arr2 = temp;

            exp *= base;    //it may overflow here...
        }
    }

    public static void BubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j + 1 + i < arr.length; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    public static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for(int j = 1; j + i < arr.length; j++){
                if(arr[j] > arr[max])
                    max = j;
            }
            int tmp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[max];
            arr[max] = tmp;
        }
    }

    private static void MergeSort(int[] arr, int low, int high){
        if(low >= high)
            return;
        if(low + 1 == high){
            if(arr[low] > arr[high]){
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
            return;
        }
        int mid = (low + high) / 2;
        MergeSort(arr, low, mid);
        MergeSort(arr, mid+1, high);
        int[] temp = Arrays.copyOfRange(arr, low, mid+1);
        int ptrLeft = low, ptrRight = mid+1;
        int ptr = low;
        while(ptrLeft <= mid && ptrRight <= high){
            if(temp[ptrLeft-low] < arr[ptrRight]){
                arr[ptr] = temp[ptrLeft-low];
                ptrLeft++;
            }
            else{
                arr[ptr] = arr[ptrRight];
                ptrRight++;
            }
            ptr++;
        }
        while(ptrLeft <= mid){
            arr[ptr] = temp[ptrLeft-low];
            ptrLeft++;
            ptr++;
        }
    }
    public static void MergeSort(int[] arr){
        MergeSort(arr, 0, arr.length-1);
    }

    private static int partition(int[] arr, int low, int high){
        //CCI书上的
        int pivot = arr[(low + high) / 2];
        while(low <= high){
            while(arr[low] < pivot)
                low++;
            while(arr[high] > pivot)
                high--;
            if(low <= high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
                low++;
                high--;
            }
        }
        return low;
    }
    private static int partition2(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;

        int ptr = low;
        for(int i = low; i < high - 1; i++){
            if(arr[i] < arr[high]){
                temp = arr[ptr];
                arr[ptr] = arr[i];
                arr[i] = temp;
                ptr++;
            }
        }
        temp = arr[ptr];
        arr[ptr] = arr[high];
        arr[high] = temp;
        return ptr;
    }
    private static void QuickSort(int[] arr, int low, int high){
        if(low >= high)
            return;
        if(true) {
            int pivot = partition2(arr, low, high);
            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot + 1, high);
        }
        else{
            int pivot = partition(arr, low, high);
            QuickSort(arr, low, pivot - 1);
            QuickSort(arr, pivot, high);
        }
    }
    public static void QuickSort(int[] arr){
        QuickSort(arr, 0, arr.length-1);
    }

    public static void main(String args[]){
        final int len = 10;
        int arr[] = new int[len];
        Random rand = new Random();
        for(int i = 0; i < len; i++)
            arr[i] = rand.nextInt();
        for(int i = 0; i < len; i++) {
            System.out.print(arr[i]);
            System.out.print('\t');
        }
        System.out.println();

        int[] arr_radix = Arrays.copyOf(arr, arr.length);
        RadixSort(arr_radix);
        for(int i = 0; i < len; i++) {
            System.out.print(arr_radix[i]);
            System.out.print('\t');
        }
        System.out.println();

        int[] arr_bubble = Arrays.copyOf(arr, arr.length);
        BubbleSort(arr_bubble);
        for(int i = 0; i < len; i++) {
            System.out.print(arr_bubble[i]);
            System.out.print('\t');
        }
        System.out.println();

        int[] arr_selection = Arrays.copyOf(arr, arr.length);
        SelectionSort(arr_selection);
        for(int i = 0; i < len; i++) {
            System.out.print(arr_selection[i]);
            System.out.print('\t');
        }
        System.out.println();

        int[] arr_merge = Arrays.copyOf(arr, arr.length);
        MergeSort(arr_merge);
        for(int i = 0; i < len; i++) {
            System.out.print(arr_merge[i]);
            System.out.print('\t');
        }
        System.out.println();

        int[] arr_quick = Arrays.copyOf(arr, arr.length);
        QuickSort(arr_quick);
        for(int i = 0; i < len; i++) {
            System.out.print(arr_quick[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}
