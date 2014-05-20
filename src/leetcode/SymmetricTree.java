package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class SymmetricTree {
    public boolean compare(TreeNode left, TreeNode right)
    {
        if(left == null && right != null)
            return false;
        if(left != null && right == null)
            return false;
        if(left == null && right == null)
            return true;
        if(left.val != right.val)
            return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return compare(root.left, root.right);
    }
}
