package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class BalancedBinaryTree {
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int d1 = dfs(root.left), d2 = dfs(root.right);
        if(d1 < 0 || d2 < 0)
            return -1;
        if(Math.abs(d1-d2)>1)
            return -1;
        return Math.max(d1,d2)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return dfs(root)>=0;
    }
}
