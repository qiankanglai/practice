package leetcode;

/**
 * Created by Anthony on 2014/6/5.
 */
public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        int v1 = -1, v2 = -1;
        if(A == null)
            return new int[]{v1, v2};

        int low = 0, high = A.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            int v = A[mid];
            if(v < target){
                low = mid+1;
            }
            else if(v > target){
                high = mid-1;
            }
            else{
                v1 = mid;
                high = mid-1;
            }
        }

        low = 0;
        high = A.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            int v = A[mid];
            if(v < target){
                low = mid+1;
            }
            else if(v > target){
                high = mid-1;
            }
            else{
                v2 = mid;
                low = mid+1;
            }
        }

        return new int[]{v1, v2};
    }

    public static void main(String args[]){
        System.out.println(new SearchforaRange().searchRange(new int[]{8}, 8));
    }
}
