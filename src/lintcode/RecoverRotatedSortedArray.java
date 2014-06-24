package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/25/14.
 */
public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0)
            return;
        int len = nums.size(), i = 0;
        for(; i+1 < len; i++){
            if(nums.get(i) > nums.get(i+1)){
                break;
            }
        }
        for(int k1 = 0, k2 = i; k1 < k2; k1++, k2--){
            int t = nums.get(k1);
            nums.set(k1, nums.get(k2));
            nums.set(k2, t);
        }
        for(int k1 = i+1, k2 = len-1; k1 < k2; k1++, k2--){
            int t = nums.get(k1);
            nums.set(k1, nums.get(k2));
            nums.set(k2, t);
        }
        for(int k1 = 0, k2 = len-1; k1 < k2; k1++, k2--){
            int t = nums.get(k1);
            nums.set(k1, nums.get(k2));
            nums.set(k2, t);
        }
    }
}
