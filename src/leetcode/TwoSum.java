package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 5/6/14.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(numbers2);
        for(int i = 0; i < numbers2.length; i++){
            int a = numbers2[i];
            int b = target - numbers2[i];
            if(Arrays.binarySearch(numbers2, b) >= 0){
                int index1 = -1, index2 = -1;
                //in case "a==b"
                for(int j = 0; j < numbers.length; j++){
                    if(numbers[j] == a){
                        index1 = j;
                        break;
                    }
                }
                for(int j = numbers.length-1; j>=0; j--){
                    if(numbers[j] == b){
                        index2 = j;
                        break;
                    }
                }
                if(index1 > index2){
                    int temp = index1;
                    index1 = index2;
                    index2 = temp;
                }
                return new int[]{index1+1,index2+1};
            }
        }
        return null;
    }

    public static void main(String[] args){
        int []arr = new int[]{2, 7, 11, 15};
        TwoSum w = new TwoSum();
        System.out.println(w.twoSum(arr, 9));
    }
}
