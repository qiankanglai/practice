package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anthony on 7/1/14.
 */
public class PermutationsII {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0)
            return res;

        int flags[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++)
            flags[i] = nums.get(i);
        Arrays.sort(flags);

        while(true){
            ArrayList<Integer> current = new ArrayList<Integer>();
            for(int i = 0; i < nums.size(); i++){
                current.add(flags[i]);
            }
            res.add(current);
            int i = nums.size()-2;
            while(i >= 0 && flags[i] >= flags[i+1]){
                i--;
            }
            if(i < 0){
                break;
            }
            int j = nums.size()-1;
            while(flags[j] <= flags[i])
                j--;

            int t = flags[i];
            flags[i] = flags[j];
            flags[j] = t;

            i++;
            j = nums.size()-1;
            while(i < j){
                t = flags[i];
                flags[i] = flags[j];
                flags[j] = t;
                i++;
                j--;
            }
        }

        return res;
    }
}
