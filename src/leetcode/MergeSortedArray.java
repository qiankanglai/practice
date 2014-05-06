package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        m--;
        n--;
        for(int i = m+n+1; i>=0; i--){
            if(m >= 0 && (n < 0 || A[m]>B[n])){
                A[i] = A[m];
                m--;
            }
            else{
                A[i] = B[n];
                n--;
            }
        }
    }
    public static void main(String args[]){
        new MergeSortedArray().merge(new int[]{2}, 1, new int[]{1}, 1);
    }
}
