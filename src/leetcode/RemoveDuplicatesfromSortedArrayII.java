package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] A) {
        int count = 0;
        boolean flag = false;
        for(int i = 0; i < A.length; i++){
            if(i+1 < A.length && A[i]==A[i+1]){
                if(flag)
                    continue;
                else
                    flag = true;
            }
            else
                flag = false;
            A[count] = A[i];
            count++;
        }
        return count;
    }
}
