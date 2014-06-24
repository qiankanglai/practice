package lintcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Anthony on 2014/6/24.
 */
public class FourSum {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        //write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numbers.length - 3; i++){
            for(int j = i+1; j < numbers.length - 2; j++){
                for(int k = j+1; k < numbers.length - 1; k++){
                    int t = target - (numbers[i] + numbers[j] + numbers[k]);
                    int idx = Arrays.binarySearch(numbers, k+1, numbers.length, t);
                    if(idx >= 0){
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(numbers[i]);
                        r.add(numbers[j]);
                        r.add(numbers[k]);
                        r.add(t);
                        res.add(r);
                    }
                    while(k < numbers.length - 1 && numbers[k] == numbers[k+1]) {
                        k++;
                    }
                }
                while(j < numbers.length - 2 && numbers[j] == numbers[j+1]) {
                    j++;
                }
            }
            while(i < numbers.length - 3 && numbers[i] == numbers[i+1]) {
                i++;
            }
        }

        return res;
    }

    public static void main(String args[]){
        new FourSum().fourSum(new int[]{-8,-0,-7,-101,-123,-1,-2,1,1,4,-2,0,-1,0,-1111,0,-1,-2,-3,-4,-5,-6,-100,-98,-111,-1}, -111);
    }
}
