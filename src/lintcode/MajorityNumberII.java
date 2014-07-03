package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 7/3/14.
 */
public class MajorityNumberII {
    /*
    http://cs.ucsb.edu/~koc/cs130a/notes/08-Celebrity.txt
2. Extension to K elements, each appearing at least n/(k+1) times.
   Maintain k candidates and counters.
   When considering xi, if xi equals one of the cands, increment it;
			if xi different and some counter available,
				set xi as that cand, and M = 1;
			if xi different from all, and all cands full;
				decrement them all.
     */

    /**
     * @param nums: A list of integers
     * @return: Find a  majority number that is the number that occurs more than 1/3 of the size of the array
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int num1 = 0, candidate1 = 0;
        int num2 = 0, candidate2 = 0;
        for(Integer n : nums){
            //found
            if(candidate1 > 0 && num1 == n){
                candidate1++;
                continue;
            }
            if(candidate2 > 0 && num2 == n){
                candidate2++;
                continue;
            }
            //add to
            if(candidate1 <= 0){
                num1 = n;
                candidate1 = 1;
                continue;
            }
            if(candidate2 <= 0){
                num2 = n;
                candidate2 = 1;
                continue;
            }
            candidate1--;
            candidate2--;
        }
        return (candidate1>candidate2)?num1:num2;
    }
}
