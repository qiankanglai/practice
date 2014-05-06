package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(i+1 < A.length && A[i]==A[i+1]){
                continue;
            }
            A[count] = A[i];
            count++;
        }
        return count;
    }
}
