package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 5/10/14.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length == 0) return digits;

        boolean one = true;
        for(int i = digits.length-1; i>=0; i--){
            if(one) {
                digits[i]++;
            }
            if(digits[i] >= 10){
                one = true;
                digits[i] -= 10;
            }
            else
                one = false;
        }
        if(one){
            int[] newdigits = new int[digits.length+1];
            newdigits[0] = 1;
            for(int i = 0; i < digits.length; i++)
                newdigits[i+1] = digits[i];
            return newdigits;
        }
        return digits;
    }

    public static void main(String args[]){
        new PlusOne().plusOne(new int[]{0});
    }
}
