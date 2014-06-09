package leetcode;

/**
 * Created by Anthony on 2014/6/9.
 */
public class BinaryTreeMaximumPathSum {
    int max = 0;

    public int dfs(TreeNode root){
        //_max保存从root开始的最大路径
        //_max2是缓存，用来计算其中可能的max出现的方式
        int _max = root.val;
        int _max2 = root.val;
        if(root.left != null){
            int l = dfs(root.left);
            if(l+root.val > _max)
                _max = l+root.val;

            if(l > max)
                max = l;
            if(l>0)
                _max2 += l;
        }
        if(root.right != null){
            int r = dfs(root.right);
            if(r+root.val > _max)
                _max = r+root.val;

            if(r > max)
                max = r;
            if(r>0)
                _max2 += r;
        }
        if(_max2 > max)
            max = _max2;
        return _max;
    }

    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        max = root.val;
        dfs(root);
        return max;
    }
}
