package google.campustest2014.rounda;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 8/20/14.
 */
public class Sorting {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2014/rounda/C-large-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            int odds = 0;
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
                if(Math.abs(arr[i]) % 2 == 1){
                    odds++;
                }
            }
            int arr1[] = new int[odds];
            int arr2[] = new int[n - odds];
            int ptr1 = 0, ptr2 = 0;
            for(int i = 0; i < n; i++){
                if(Math.abs(arr[i]) % 2 == 1){
                    arr1[ptr1] = arr[i];
                    ptr1++;
                }
                else{
                    arr2[ptr2] = arr[i];
                    ptr2++;
                }
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(":");

            ptr1 = 0;
            ptr2 = arr2.length-1;
            for(int i = 0; i < n; i++) {
                if (Math.abs(arr[i]) % 2 == 1) {
                    System.out.print(' ');
                    System.out.print(arr1[ptr1]);
                    ptr1++;
                } else {
                    System.out.print(' ');
                    System.out.print(arr2[ptr2]);
                    ptr2--;
                }
            }
            System.out.println();
        }
        in.close();
    }
}
