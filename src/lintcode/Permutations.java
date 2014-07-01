package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/1/14.
 */
public class Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size() == 0)
            return res;

        int flags[] = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++)
            flags[i] = i;
        while(true){
            ArrayList<Integer> current = new ArrayList<Integer>();
            for(int i = 0; i < nums.size(); i++){
                current.add(nums.get(flags[i]));
            }
            res.add(current);
            int i = nums.size()-2;
            while(i >= 0 && flags[i] > flags[i+1]){
                i--;
            }
            if(i < 0){
                break;
            }
            int j = nums.size()-1;
            while(flags[j] < flags[i])
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
