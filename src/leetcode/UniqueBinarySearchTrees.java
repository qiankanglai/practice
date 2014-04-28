package leetcode;

public class UniqueBinarySearchTrees{
    public int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= i; j++)
                sum += res[j-1] * res[i-j];
            res[i] = sum;
        }
        return res[n];
    }

    public static void main(String[] args){
        System.out.println(new UniqueBinarySearchTrees().numTrees(3));
    }

}