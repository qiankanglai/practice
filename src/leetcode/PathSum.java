package leetcode;

/**
 * Created by Anthony on 2014/5/16.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left==null && root.right==null){
            return (root.val==sum);
        }
        else{
            return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
        }
    }
}
