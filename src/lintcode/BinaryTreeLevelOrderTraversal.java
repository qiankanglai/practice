package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/25/14.
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        levelOrder(root, 0, res);
        return res;
    }
    private void levelOrder(TreeNode root, int level, ArrayList<ArrayList<Integer>> res) {
        if(root == null)
            return;
        if(res.size() <= level)
            res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        levelOrder(root.left, level+1, res);
        levelOrder(root.right, level+1, res);
    }
}
