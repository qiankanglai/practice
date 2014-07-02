package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/7/2.
 */
public class MaximumSubarrayII {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() < 2)
            return 0;
        int positive_from_left[] = new int[nums.size()];
        int positive_from_right[] = new int[nums.size()];

        int runningSum1 = 0;
        int sum1 = nums.get(0);
        for(int i = 0; i < nums.size(); i++) {
            runningSum1 += nums.get(i);

            if (runningSum1 > sum1)
                sum1 = runningSum1;
            else if (runningSum1 < 0)
                runningSum1 = 0;
            positive_from_left[i] = sum1;
        }
        runningSum1 = 0;
        sum1 = nums.get(nums.size()-1);
        for(int i = nums.size()-1; i >= 0; i--){
            runningSum1 += nums.get(i);

            if(runningSum1 > sum1)
                sum1 = runningSum1;
            else if(runningSum1 < 0)
                runningSum1 = 0;
            positive_from_right[i] = sum1;
        }
        int max = positive_from_left[0] + positive_from_right[1];
        for(int i = 0; i < nums.size()-1; i++){
            int t = positive_from_left[i] + positive_from_right[i+1];
            max = Math.max(max, t);
        }
        return max;
    }
}
