package leetcode;

/**
 * Created by anthony on 6/6/14.
 */
public class FirstMissingPositive {
    //https://oj.leetcode.com/discuss/4220/a-very-nice-solution-from-ants-aasma-%40stackoverflow
    //没想到in place利用内存
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] > n) {
                    break;
                }
                int ptr2 = A[i]-1;
                int t = A[ptr2];
                if(t == A[i])
                    break;  //the same number
                A[ptr2] = A[i];
                A[i] = t;
            }
        }
        for(int i = 0; i < n; i++)
            if(A[i] != i+1)
                return i+1;
        return n+1;
    }

    public static void main(String args[]){
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{1,1}));
    }
}
