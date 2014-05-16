package leetcode;

import java.util.ArrayList;

/**
 * Created by anthony on 5/10/14.
 */
public class BinaryTreeLevelOrderTraversal {
    public void go(TreeNode node,ArrayList<ArrayList<Integer>> res, int level){
        if(node == null) return;
        if(res.size() <= level)
            res.add(new ArrayList<Integer>());
        res.get(level).add(node.val);
        go(node.left, res, level+1);
        go(node.right, res, level+1);
    }
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        go(root, res, 0);
        return res;
    }
}
