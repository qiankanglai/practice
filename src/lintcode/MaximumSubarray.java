package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/1/14.
 */
public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        if(nums == null || nums.size() == 0)
            return 0;
        int max = nums.get(0), sum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
            if(sum > max)
                max = sum;
            else if(sum < 0)
                sum = 0;
        }
        return max;
    }
}
