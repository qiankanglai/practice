package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != elem){
                A[count] = A[i];
                count++;
            }
        }
        return count;
    }
}
