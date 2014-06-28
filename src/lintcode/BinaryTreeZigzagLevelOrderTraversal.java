package lintcode;

import java.util.ArrayList;

/**
 * Created by anthony on 6/25/14.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        zigzagLevelOrder(root, 0, res);
        return res;
    }
    private void zigzagLevelOrder(TreeNode root, int level, ArrayList<ArrayList<Integer>> res) {
        if(root == null)
            return;
        if(res.size() <= level)
            res.add(new ArrayList<Integer>());
        if(level % 2 == 0)
            res.get(level).add(root.val);
        else
            res.get(level).add(0, root.val);
        zigzagLevelOrder(root.left, level+1, res);
        zigzagLevelOrder(root.right, level+1, res);
    }
}
