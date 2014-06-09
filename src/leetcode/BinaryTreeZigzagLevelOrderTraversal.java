package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anthony on 2014/6/9.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public void dfs(TreeNode node, int depth, ArrayList<List<Integer>> res){
        if(node == null)
            return;
        if(res.size() <= depth){
            res.add(new ArrayList<Integer>());
        }
        if(depth % 2 == 0){
            res.get(depth).add(node.val);
        }
        else{
            res.get(depth).add(0, node.val);
        }
        dfs(node.left, depth+1, res);
        dfs(node.right, depth+1, res);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        dfs(root, 0, res);
        return res;
    }
}
