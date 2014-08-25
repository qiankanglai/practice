package leetcode;

/**
 * Created by anthony on 8/23/14.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(A[mid] == target){
                return mid;
            }
            else if(A[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        if(high < 0)
            high = 0;
        while(high < A.length && A[high] < target)
            high++;
        return high;
    }
}
