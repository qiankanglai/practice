package leetcode;

/**
 * Created by Anthony on 2014/6/8.
 */
public class ValidateBinarySearchTree {
    public boolean check(TreeNode root, int min, int max) {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
