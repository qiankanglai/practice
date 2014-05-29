package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/28.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1)
            return;

        int i = num.length-2;
        while(i >= 0 && num[i] >= num[i+1])
            i--;
        if(i < 0) {
            Arrays.sort(num);
            return; //got to the end
        }
        int max_id = i+1;
        for(int ii = max_id; ii < num.length; ii++){
            if(num[ii] > num[i] && num[ii] < num[max_id]){
                max_id = ii;
            }
        }
        int temp = num[i];
        num[i] = num[max_id];
        num[max_id] = temp;

        Arrays.sort(num, i+1, num.length);
    }

    public static void main(String args[]){
        int arr[]=new int[]{5,1,1};
        new NextPermutation().nextPermutation(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(',');
        }
    }
}
