package leetcode;

/**
 * Created by Anthony on 2014/5/28.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1)
            return;

        int i = num.length-2;
        while(i >= 0 && num[i] > num[i+1])
            i--;
        if(i < 0)
            return; //got to the end
        int ii = i+1, j = num.length-1;
        while(num[i] > num[j])
            j--;
        //swap
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        //reverse
        int start = ii, end = num.length-1;
        for(int p = start, pe = (start+end); 2*p < pe; p++){
            temp = num[p];
            num[p] = num[pe-p];
            num[pe-p] = temp;
        }
    }
}
