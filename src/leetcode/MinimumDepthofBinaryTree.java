package leetcode;

/**
 * Created by anthony on 5/16/14.
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int d1 = minDepth(root.left), d2 = minDepth(root.right);
        if(d1 == 0)
            return d2+1;
        else if(d2 == 0)
            return d1+1;
        else
            return Math.min(d1,d2)+1;
    }
}
