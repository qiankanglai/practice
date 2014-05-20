package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int m1 = maxDepth(root.left), m2 = maxDepth(root.right);
        return (m1>m2)?m1+1:m2+1;
    }
}
