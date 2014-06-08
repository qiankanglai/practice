package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/8.
 */
public class PermutationSequence {
    public int Factorial(int n){
        int r = 1;
        for(int i = 1; i <= n; i++)
            r *= i;
        return r;
    }

    public String getPermutation(int n, int k) {
        ArrayList<Character> arr = new ArrayList<Character>();
        for(int i = 0; i < n; i++)
            arr.add((char)('1'+i));
        StringBuilder sb = new StringBuilder();
        k--;
        for(int i = 0; i < n; i++){
            int f = Factorial(n - 1 - i);
            int idx = k / f;
            sb.append(arr.get(idx));
            arr.remove(idx);
            k = k % f;
        }
        return sb.toString();
    }

    public String getPermutation_old(int n, int k) {
        int []arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = i;
        for(int _k = 1; _k < k; _k++){
            //copy from Permutations.java
            int i = n-2;
            while(i >= 0 && arr[i] > arr[i+1])
                i--;
            if(i < 0)
                break;
            int ii = i+1, j = n-1;
            while(arr[i] > arr[j])
                j--;
            //swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            //reverse
            int start = ii, end = n-1;
            for(int p = start, pe = (start+end); 2*p < pe; p++){
                temp = arr[p];
                arr[p] = arr[pe-p];
                arr[pe-p] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append((char)('1'+arr[i]));
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(new PermutationSequence().getPermutation(3, 1));
    }
}
