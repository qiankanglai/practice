package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/29/14.
 */
public class MajorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int size = nums.size();
        int t = nums.get(0), count = 1;
        for(int i = 1; i < size; i++){
            if(nums.get(i) == t){
                count++;
            }
            else{
                count--;
                if(count == 0){
                    t = nums.get(i);
                    count = 1;
                }
            }
        }
        return t;
    }
}
