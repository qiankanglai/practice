package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode build(int[] num, int start, int end){
        if(start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = build(num, start, mid-1);
        node.right = build(num, mid+1, end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] num) {
        return build(num, 0, num.length-1);
    }
}
