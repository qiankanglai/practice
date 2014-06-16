package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anthony on 6/11/14.
 */
public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for(int i1 = 0; i1 < numbers.length; i1++){
            if(numbers[i1]*3 > 0) break;
            if(i1 > 0 && numbers[i1] == numbers[i1-1])
                continue;
            for(int i2 = i1 + 1; i2 < numbers.length; i2++){
                if(numbers[i1] + numbers[i2]*2 > 0) break;
                if(i2 > i1+1 && numbers[i2] == numbers[i2-1])
                    continue;
                for(int i3 = i2 + 1; i3 < numbers.length; i3++){
                    if(numbers[i1]+numbers[i2]+numbers[i3] > 0) break;
                    if(i3 > i2+1 && numbers[i3] == numbers[i3-1])
                        continue;
                    if(numbers[i1]+numbers[i2]+numbers[i3] == 0){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(numbers[i1]);
                        temp.add(numbers[i2]);
                        temp.add(numbers[i3]);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}
