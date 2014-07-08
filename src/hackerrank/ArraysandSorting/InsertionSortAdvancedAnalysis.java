package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class InsertionSortAdvancedAnalysis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=in.nextInt();
            }
            System.out.println(insertSort_bst(ar));
        }
    }

    //使用BST做超时，需要考虑AVL
    static class TreeNode{
        long val = 0;
        long equal_or_small = 1;
        TreeNode left = null, right = null;
        public TreeNode(long v){
            val = v;
        }
    }
    public static int insertSort_bst(int[] ar)
    {
        int len = ar.length;
        int count = 0;
        TreeNode root = new TreeNode(ar[0]);
        for(int i = 1; i < len; i++){
            TreeNode p = root;
            int small_than_this = 0;
            while(true){
                if(p.val <= ar[i]){
                    small_than_this += p.equal_or_small;
                    if(p.right != null){
                        p = p.right;
                    }
                    else{
                        p.right = new TreeNode(ar[i]);
                        break;
                    }
                }
                else{
                    p.equal_or_small++;
                    if(p.left != null){
                        p = p.left;
                    }
                    else{
                        p.left = new TreeNode(ar[i]);
                        break;
                    }
                }
            }
            count += (i - small_than_this);
        }
        return count;
    }
}
