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
            System.out.println(insertSort(ar));
        }
    }
    //线段树
    static class TreeNode2{
        long start = 0, end = 0, count = 0;
        TreeNode2 left = null, right = null;
        public TreeNode2(long s, long e){
            start = s;
            end = e;
        }
    }
    public static long insertSort(int[] ar)
    {
        long count = 0;
        TreeNode2 root = new TreeNode2(1, 1000000);
        for(int i = 0; i < ar.length; i++){
            TreeNode2 p = root;
            long small_than_this = 0;
            while(p.start < p.end){
                p.count++;
                long mid = (p.start+p.end)/2;
                if(ar[i] <= mid){
                    if(p.left == null){
                        p.left = new TreeNode2(p.start, mid);
                    }
                    p = p.left;
                }
                else{
                    if(p.left != null){
                        small_than_this += p.left.count;
                    }

                    if(p.right == null){
                        p.right = new TreeNode2(mid+1, p.end);
                    }
                    p = p.right;
                }
            }
            p.count++;
            small_than_this += (p.count-1);
            count += (i - small_than_this);
        }
        return count;
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
