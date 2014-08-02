package hackerrank.Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 8/1/14.
 */
public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int m = in.nextInt(), n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            int arr2[] = Arrays.copyOf(arr, n);

            Arrays.sort(arr);
            int i = 0, j = n-1;
            for(; i < n; i++){
                int begin = i+1, end = j, mid = 0;
                int target = m - arr[i];
                while(begin <= end){
                    mid = (begin+end)/2;
                    if(arr[mid] == target){
                        break;
                    }
                    else if(arr[mid] < target){
                        begin = mid+1;
                    }
                    else{
                        end = mid-1;
                    }
                }
                j = mid;
                if(arr[mid] == target){
                    break;
                }
                j = Math.min(j+1, n-1);
            }

            int id1 = 0, id2 = 0;
            for(int k = 0; k < n; k++){
                if(id1 == 0 && arr2[k] == arr[i])
                    id1 = k+1;
                else if(id2 == 0 && arr2[k] == arr[j])
                    id2 = k+1;
            }
            if(id1 > id2){
                int temp = id1;
                id1 = id2;
                id2 = temp;
            }
            System.out.print(id1);
            System.out.print(' ');
            System.out.println(id2);

        }
    }
}
