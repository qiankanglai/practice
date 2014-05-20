package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class FlattenBinaryTreetoLinkedList {
    public TreeNode doit(TreeNode node){
        TreeNode left = node.left, right = node.right;
        node.left = null;
        node.right = null;
        TreeNode tail = node;
        if(left != null){
            tail.right = left;
            tail = doit(left);
        }
        if(right != null){
            tail.right = right;
            tail = doit(right);
        }
        return tail;
    }
    public void flatten(TreeNode root) {
        if(root != null)
            doit(root);
    }
}
