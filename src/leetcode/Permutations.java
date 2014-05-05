package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 14-4-29.
 */
public class Permutations {
    public static ArrayList<Integer> convert(int []num, int []arr){
        ArrayList<Integer> res = new ArrayList<Integer>(num.length);
        for(int i = 0; i < num.length; i++)
            res.add(num[arr[i]]);
        return res;
    }

    //http://daoluan.net/blog/stl-algorithm-full-array/
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int []arr = new int[num.length];
        for(int i = 0; i < num.length; i++)
            arr[i] = i;
        res.add(convert(num, arr));
        while(true){
            int i = arr.length-2;
            while(i >= 0 && arr[i] > arr[i+1])
                i--;
            if(i < 0)
                break;
            int ii = i+1, j = arr.length-1;
            while(arr[i] > arr[j])
                j--;
            //swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            //reverse
            int start = ii, end = arr.length-1;
            for(int p = start, pe = (start+end); 2*p < pe; p++){
                temp = arr[p];
                arr[p] = arr[pe-p];
                arr[pe-p] = temp;
            }
            res.add(convert(num, arr));
        }
        return res;
    }

    public static void main(String[] args){
        int []arr = new int[]{0,-1,1};
        Permutations w = new Permutations();
        System.out.println(w.permute(arr));
    }
}
