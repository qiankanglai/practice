package leetcode;

/**
 * Created by Anthony on 2014/5/9.
 */
public class SortColors {
    public void sortColors(int[] A) {
        int i0=0,i1=0,i2=0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 2)
                i2 ++;
            else if(A[i] == 1){
                A[i2] = 2;
                i2++;
                A[i1] = 1;
                i1++;
            }
            else if(A[i] == 0){
                A[i2] = 2;
                i2++;
                A[i1] = 1;
                i1++;
                A[i0] = 0;
                i0++;
            }
        }
    }

    public static void main(String args[]){
        new SortColors().sortColors(new int[]{2,1,0,1});
    }
}
