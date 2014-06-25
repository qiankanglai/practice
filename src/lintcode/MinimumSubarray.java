package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/25.
 */
public class MinimumSubarray {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0)
            return 0;
        int []sum = new int[nums.size()+1];
        sum[0] = 0;
        for(int i = 0; i < nums.size(); i++){
            sum[i+1] = sum[i]+nums.get(i);
        }
        int min = sum[1];
        for(int i = 1; i <= nums.size(); i++){
            for(int j = 0; j < i; j++){
                int t = sum[i]-sum[j];
                if(t < min)
                    min = t;
            }
        }

        return min;
    }
}
