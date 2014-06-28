package lintcode;

import java.util.Arrays;

/**
 * Created by anthony on 6/29/14.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null || inorder.length == 0 || preorder.length != inorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int idx = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                idx = i;
                break;
            }
        }
        if(idx < 0){
            return null;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx + 1, inorder.length));
        return root;
    }
}
