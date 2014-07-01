package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/28/14.
 */
public class SearchInsertPosition {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(ArrayList<Integer> A, int target) {
        if(A == null || A.size() == 0){
            return 0;
        }
        int start = 0, end = A.size()-1, mid = 0;
        while(start <= end){
            mid = (start+end) / 2;
            int t = A.get(mid);
            if(t == target){
                return mid;
            }
            else if(t < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        if(A.get(mid) < target){
            mid++;
        }
        else if(mid > 0 && A.get(mid-1) > target)
            mid--;
        return mid;
    }

    public static void main(String args[]){
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(6);
        nums.add(8);
        nums.add(9);
        new SearchInsertPosition().searchInsert(nums, 7);
    }
}
