package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/5/9.
 */
public class BinaryTreeLevelOrderTraversalII {
    ArrayList<ArrayList<Integer>> res;
    public void go(TreeNode node, int depth){
        if(node == null) return;
        if(res.size() <= depth)
            res.add(new ArrayList<Integer>());
        res.get(depth).add(node.val);
        go(node.left, depth+1);
        go(node.right, depth+1);
    }
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<ArrayList<Integer>>();
        go(root, 0);

        for (int i = 0; i < res.size()/2; i++)
        {
            ArrayList<Integer> temp = res.get(i);
            res.set(i, res.get(res.size()-i-1));
            res.set(res.size()-i-1, temp);
        }
        return res;
    }
}
