package leetcode;

/**
 * Created by anthony on 5/16/14.
 */
public class SearchinRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(A[mid]==target) return true;
            if(A[low] < A[mid]){
                if(target<=A[mid] && target>=A[low])
                    high=mid-1;
                else
                    low=mid+1;
                continue;
            }
            if(A[mid] < A[high]){
                if(target>=A[mid] && target<=A[high])
                    low=mid+1;
                else
                    high=mid-1;
                continue;
            }
            if(A[low]==target) return true;
            low++;  //worse case...
        }
        return false;
    }
}
