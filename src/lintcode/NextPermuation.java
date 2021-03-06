package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/1/14.
 */
public class NextPermuation {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
        if(nums == null)
            return null;
        if(nums.size() <= 1){
            return nums;
        }
        int len = nums.size(), i = len-2;
        for(; i >= 0; i--){
            if(nums.get(i) < nums.get(i+1))
                break;
        }
        if(i < 0){
            //reverse all
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(i = len-1; i >= 0; i--){
                res.add(nums.get(i));
            }
            return res;
        }
        int t = nums.get(i);
        int j = len-1;
        while(nums.get(j) <= t){
            j--;
        }
        nums.set(i, nums.get(j));
        nums.set(j, t);

        //make reverse order
        i++;
        j = len-1;
        while(i < j){
            t = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, t);
            i++;
            j--;
        }

        return nums;
    }
}
