package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/25/14.
 */
public class BinaryTreeLevelOrderTraversalII {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        levelOrderButtom(root, 0, res);
        return res;
    }
    private void levelOrderButtom(TreeNode root, int level, ArrayList<ArrayList<Integer>> res) {
        if(root == null)
            return;
        if(res.size() <= level)
            res.add(0, new ArrayList<Integer>());
        res.get(res.size() - 1 - level).add(root.val);
        levelOrderButtom(root.left, level+1, res);
        levelOrderButtom(root.right, level+1, res);
    }
}
