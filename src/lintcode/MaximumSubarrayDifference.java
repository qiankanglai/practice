package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/7/2.
 */
public class MaximumSubarrayDifference {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() < 2)
            return 0;
        int positive_from_left[] = new int[nums.size()];
        int negative_from_left[] = new int[nums.size()];
        int positive_from_right[] = new int[nums.size()];
        int negative_from_right[] = new int[nums.size()];

        int runningSum1 = 0, runningSum2 = 0;
        int sum1 = nums.get(0), sum2 = nums.get(0);
        for(int i = 0; i < nums.size(); i++){
            runningSum1 += nums.get(i);
            runningSum2 += nums.get(i);

            if(runningSum1 > sum1)
                sum1 = runningSum1;
            else if(runningSum1 < 0)
                runningSum1 = 0;
            positive_from_left[i] = sum1;

            if(runningSum2 < sum2)
                sum2 = runningSum2;
            else if(runningSum2 > 0)
                runningSum2 = 0;
            negative_from_left[i] = sum2;
        }

        runningSum1 = 0;
        runningSum2 = 0;
        sum1 = nums.get(nums.size()-1);
        sum2 = nums.get(nums.size()-1);
        for(int i = nums.size()-1; i >= 0; i--){
            runningSum1 += nums.get(i);
            runningSum2 += nums.get(i);

            if(runningSum1 > sum1)
                sum1 = runningSum1;
            else if(runningSum1 < 0)
                runningSum1 = 0;
            positive_from_right[i] = sum1;

            if(runningSum2 < sum2)
                sum2 = runningSum2;
            else if(runningSum2 > 0)
                runningSum2 = 0;
            negative_from_right[i] = sum2;
        }

        int max = positive_from_left[0] - negative_from_right[1];
        for(int i = 0; i < nums.size()-1; i++){
            int t1 = positive_from_left[i] - negative_from_right[i+1];
            int t2 = positive_from_right[i+1] - negative_from_left[i];
            max = Math.max(max, Math.max(t1, t2));
        }
        return max;
    }

    public static void main(String args[]){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(2);
        nums.add(-3);
        nums.add(1);
        System.out.println(new MaximumSubarrayDifference().maxDiffSubArrays(nums));
    }
}
