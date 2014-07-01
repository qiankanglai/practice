package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/1/14.
 */
public class PartitionArray {
    /**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(ArrayList<Integer> nums, int k) {
        if(nums == null || nums.size() == 0)
            return 0;
        int ptr = 0;
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i) < k){
                int t = nums.get(ptr);
                nums.set(ptr, nums.get(i));
                nums.set(i, t);
                ptr++;
            }
        }
        return ptr;
    }
}
