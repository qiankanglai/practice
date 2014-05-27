package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anthony on 2014/5/27.
 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int distance = 10000, result = 0;
        for(int i = 0; i < num.length-2; i++){
            if(i > 0 && num[i]==num[i-1])
                continue;

            int j = i+1, k = num.length-1;
            while(j < k){
                int sum = num[i]+num[j]+num[k] - target;
                if(sum == 0){
                    return target;
                }
                else if(sum < 0) {
                    if(-sum < distance){
                        distance = -sum;
                        result = sum+target;
                    }
                    j++;
                }
                else {
                    if(sum < distance){
                        distance = sum;
                        result = sum+target;
                    }
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(new ThreeSumCloset().threeSumClosest(new int[]{-1,2,1,-4},1));
    }
}
