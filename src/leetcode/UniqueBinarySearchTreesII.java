package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 2014/6/8.
 */
public class UniqueBinarySearchTreesII {
    public TreeNode dfsCopy(TreeNode n){
        if(n == null)
            return null;
        else{
            TreeNode _n = new TreeNode(n.val);
            _n.left = dfsCopy(n.left);
            _n.right = dfsCopy(n.right);
            return _n;
        }
    }
    public List<TreeNode> generateTreesWithOffset(int n, int offset) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(n <= 0) {
            result.add(null);
            return result;
        }
        else if(n == 1){
            result.add(new TreeNode(offset+1));
            return result;
        }
        for(int i = 1; i <= n; i++){
            List<TreeNode> left = generateTreesWithOffset(i-1, offset);
            List<TreeNode> right = generateTreesWithOffset(n-i, i+offset);
            for(TreeNode n1:left){
                for(TreeNode n2:right){
                    TreeNode node = new TreeNode(i+offset);
                    node.left = dfsCopy(n1);
                    node.right = dfsCopy(n2);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateTreesWithOffset(n, 0);
    }

    public static void main(String args[]){
        new UniqueBinarySearchTreesII().generateTrees(3);
    }
}
