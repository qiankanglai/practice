package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/29/14.
 */
public class SearchforaRange {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A == null || A.size() == 0){
            res.add(-1);
            res.add(-1);
            return res;
        }
        int start = 0, end = A.size()-1, mid = 0, last = -1;
        while(start <= end){
            mid = (start+end) / 2;
            if(A.get(mid) >= target){
                if(A.get(mid) == target){
                    last = mid;
                }
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        res.add(last);
        start = 0;
        end = A.size() - 1;
        last = -1;
        while(start <= end){
            mid = (start+end) / 2;
            if(A.get(mid) > target){
                end = mid - 1;
            }
            else {
                if (A.get(mid) == target) {
                    last = mid;
                }
                start = mid + 1;
            }
        }
        res.add(last);
        return  res;
    }
}
