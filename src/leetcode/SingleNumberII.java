package leetcode;

/**
 * Created by anthony on 4/22/14.
 */
public class SingleNumberII {
    static final int MAXBIT=32;
    public int singleNumber1(int[] A) {
        byte result[] = new byte[MAXBIT];
        byte result2[] = new byte[MAXBIT];
        for(int i = 0; i < MAXBIT; i++){
            result[i] = 0;
            result2[i] = 0;
        }
        for(int p = 0; p < A.length; p++){
            int t = A[p];
            for(int i = 0; i < MAXBIT && t > 0; i++){
                result2[i] = (byte)(t%3);
                t = t/3;
            }
            for(int i = 0; i < MAXBIT; i++){
                result[i] = (byte)((result[i]+result2[i])%3);
                result2[i] = 0;
            }
        }
        int r = 0;
        for(int i = MAXBIT-1; i >= 0; i--){
            r = (r*3)+result[i];
        }
        return r;
    }

    public int singleNumber(int[] A) {
        int one = 0, two = 0, zero = 0xffffffff;
        for(int i = 0; i < A.length; i++){
            int _two = two;
            two = (two & ~A[i]) | (one & A[i]);
            one = (one & ~A[i]) | (zero & A[i]);
            zero = (zero & ~A[i]) | (_two & A[i]);
        }
        return one;
    }

    public static void main(String[] args){
        SingleNumberII w = new SingleNumberII();
        System.out.println(w.singleNumber(new int[]{-2,-2,1,1,-3,1,-3,-3,-4,-2}));
        //System.out.println(w.singleNumber(new int[]{2,2,3,2}));
    }
}
