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
        int l = nums.size();
        int cache[][] = new int[k+1][l+1];
        for(int _k = 1; _k <= k; _k++){
            {
                int sum = 0;
                for(int i = 0; i < _k; i++){
                    sum += nums.get(i);
                }
                cache[_k][_k] = sum;
            }
            for(int _l = _k+1; _l <= l; _l++){
                int t = cache[_k][_l-1];
                int temp = 0, l2 = _l;
                while(l2-1 >= _k-1){
                    temp += nums.get(l2-1);
                    int t2 = cache[_k-1][l2-1] + temp;
                    if(t2 > t){
                        t = t2;
                    }
                    l2--;
                }
                cache[_k][_l] = t;
            }
        }
        return cache[k][l];
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
