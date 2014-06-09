package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 6/9/14.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null)
            return null;
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        else{
            TreeNode root = new TreeNode(preorder[0]);
            int k = 0;
            while(inorder[k] != preorder[0])
                k++;

            root.left = buildTree(Arrays.copyOfRange(preorder, 1, k+1),
                    Arrays.copyOfRange(inorder, 0, k));
            root.right = buildTree(Arrays.copyOfRange(preorder, k+1, preorder.length),
                    Arrays.copyOfRange(inorder, k+1, inorder.length));
            return root;
        }
    }
}
