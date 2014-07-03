package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/3/14.
 */
public class MaximumSubarrayIII {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        return maxSubArray(nums, k, nums.size()-1);
    }
    public int maxSubArray(ArrayList<Integer> nums, int k, int l) {
        if(k == 0){
            return 0;
        }
        while(l >= 0 && nums.get(l) <= 0){
            l--;
        }
        if(l < 0 || k > l+1){
            return 0;
        }
        int t1 = Math.max(maxSubArray(nums, k-1, l-1) + nums.get(l), maxSubArray(nums, k, l-1));
        int temp = nums.get(l);
        for(int l2 = l-1; l2 >= 0; l2--){
            temp += nums.get(l2);
            int t2 = maxSubArray(nums, k-1, l2-1) + temp;
            if(t2 > t1){
                t1 = t2;
            }
        }
        return t1;
    }

    public static void main(String args[]){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(-1);
        nums.add(4);
        nums.add(-2);
        nums.add(3);
        nums.add(-2);
        nums.add(3);
        System.out.println(new MaximumSubarrayIII().maxSubArray(nums, 2));
    }
}
