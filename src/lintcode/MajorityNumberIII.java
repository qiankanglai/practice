package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anthony on 7/3/14.
 */
public class MajorityNumberIII {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        int num[] = new int[k];
        int candidates[] = new int[k];
        for(Integer n : nums){
            int i = 0;
            for(; i < k; i++){
                if(candidates[i] > 0 && num[i] == n){
                    break;
                }
            }
            if(i < k){
                candidates[i]++;
                continue;
            }

            i = 0;
            for(; i < k; i++){
                if(candidates[i] <= 0){
                    break;
                }
            }
            if(i < k){
                num[i] = n;
                candidates[i] = 1;
                continue;
            }

            for(i = 0; i < k; i++){
                candidates[i] --;
            }
        }
        int idx = 0;

        /*Arrays.fill(candidates, 0);
        for(Integer n : nums){
            for(int i = 0; i < k; i++){
                if(num[i] == n) {
                    candidates[i]++;
                }
            }
        }*/

        for(int i = 0; i < k; i++){
            if(candidates[i] > candidates[idx])
                idx = i;
        }
        return num[idx];
    }

    public static void main(String args[]){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(3);
        nums.add(4);
        nums.add(4);
        nums.add(4);
        System.out.println(new MajorityNumberIII().majorityNumber(nums, 3));
    }
}
