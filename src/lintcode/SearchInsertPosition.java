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
        int start = 0, end = A.size()-1;
        while(start <= end){
            int mid = (start+end) / 2;
            if(A.get(mid) == target){
                return mid;
            }
            else if(A.get(mid) < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return 0;
    }
}
