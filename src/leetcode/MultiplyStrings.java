package leetcode;

import datastructure.BigNumber;

/**
 * Created by anthony on 6/6/14.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        return BigNumber.multiply(new BigNumber(num1), new BigNumber(num2)).toString();
    }

    public static void main(String args[]){
        System.out.println(new MultiplyStrings().multiply("9","9"));
    }
}
