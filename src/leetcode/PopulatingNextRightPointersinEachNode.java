package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class PopulatingNextRightPointersinEachNode {
    void connect(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null)
        {
            root.left.next = root.right;
            connect(root.left);
        }
        if(root.right != null)
        {
            if(root.next != null)
                root.right.next = root.next.left;
            connect(root.right);
        }
    }
}
