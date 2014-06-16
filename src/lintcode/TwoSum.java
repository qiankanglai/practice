package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anthony on 6/11/14.
 */
public class TwoSum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1,index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return new int[0];
        }
        for(int i1 = 0; i1 < numbers.length; i1++){
            for(int i2 = i1+1; i2 < numbers.length; i2++){
                if(numbers[i1]+numbers[i2]==target){
                    int r[] = new int[2];
                    r[0] = i1+1;
                    r[1] = i2+1;
                    return r;
                }
            }
        }
        return new int[0];
    }
}
