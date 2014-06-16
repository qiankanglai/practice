package CCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Anthony on 2014/6/13.
 */
public class Chapter4 {
    //4.1
    public int isBalanced_depth(TreeNode root){
        if(root == null)
            return 0;
        int d1 = isBalanced_depth(root.left);
        int d2 = isBalanced_depth(root.left);
        if(d1 < 0 || d2 < 0)
            return -1;
        if(Math.abs(d1-d2) > 1)
            return -1;
        return Math.max(d1, d2);
    }
    public boolean isBalanced(TreeNode root){
        return isBalanced_depth(root) >= 0;
    }

    //4.2
    public boolean search(Graph g, GraphNode start, GraphNode end){
        HashSet<GraphNode> visited = new HashSet<GraphNode>();
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();

        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            GraphNode p = queue.removeFirst();
            if(p == end)
                return true;
            if(visited.contains(p))
                continue;
            visited.add(p);
            for(GraphNode n : p.adjacent){
                if(!visited.contains(n))
                    queue.add(n);
            }
        }
        return false;
    }

    //4.3
    public TreeNode createMinimalBST(int[] arr, int start, int end){
        if(start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
    public TreeNode createMinimalBST(int[] arr){
        if(arr == null || arr.length == 0)
            return null;
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    //4.4
    public void createLevelLinkedList(TreeNode root, ArrayList<ArrayList<TreeNode>> lists, int level){
        if(root == null)
            return;
        if(lists.size() <= level){
            lists.add(new ArrayList<TreeNode>());
        }
        lists.get(level).add(root);
        createLevelLinkedList(root.left, lists, level+1);
        createLevelLinkedList(root.right, lists, level+1);
    }
    public ArrayList<ArrayList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    //4.5
    public boolean ckeckBST_wrong(TreeNode root){   //这个代码是错的!检查的范围不够细
        if(root == null)
            return true;
        if(root.left != null){
            if(root.left.val > root.val || !ckeckBST_wrong(root.left))
                return false;
        }
        if(root.right != null){
            if(root.right.val < root.val || !ckeckBST_wrong(root.right))
                return false;
        }
        return true;
    }
    public boolean checkBST(TreeNode root, int min, int max){
        if(root == null)
            return true;
        if(root.val < min || root.val > max)
            return false;
        return (checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max));
    }
    public boolean checkBST(TreeNode root){
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //4.6
    public TreeNode inorderSucc(TreeNode n){
        if(n == null)
            return n;
        if(n.right != null){
            n = n.right;
            while(n.left != null) {
                n = n.left;
            }
            return n;
        }
        else{
            while(n.right == null){
                TreeNode n2 = n.parent;
                if(n2 == null)
                    return null;
                if(n2.right == n) {
                    break;
                }
                else
                    n = n2;
            }
            return n.parent;
        }
    }

    //4.7
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //找到带p,q的最深节点(如果是null就只要找另一个)
        if(root == null)
            return null;
        if(p == null){
            if(root == q){
                return root;
            }
            else{
                TreeNode n = commonAncestor(root.left, null, q);
                if(n != null)
                    return n;
                n = commonAncestor(root.right, null, q);
                if(n != null)
                    return n;
                return null;
            }
        }
        else if(q == null){
            if(root == p){
                return root;
            }
            else{
                TreeNode n = commonAncestor(root.left, null, p);
                if(n != null)
                    return n;
                n = commonAncestor(root.right, null, p);
                if(n != null)
                    return n;
                return null;
            }
        }
        else{
            //p != null, q != null
            if(root == q && root == p)
                return root;
            TreeNode tmp = commonAncestor(root.left, p, q);
            if(tmp != null)
                return tmp;
            tmp = commonAncestor(root.right, p, q);
            if(tmp != null)
                return tmp;
            //这边的重复计算有点多，最好是一遍搜索
            if(commonAncestor(root.left, p, null) != null && commonAncestor(root.right, null, q) != null)
                return root;
            if(commonAncestor(root.right, p, null) != null && commonAncestor(root.left, null, q) != null)
                return root;
            return null;
        }
    }

    //4.8
    public TreeNode subTree(TreeNode t1, TreeNode t2){
        if(t1 == null)
            return null;
        if(t1.val == t2.val && matchTree(t1, t2))
            return t1;
        TreeNode tmp = subTree(t1.left, t2);
        if(tmp != null)
            return tmp;
        tmp = subTree(t1.right, t2);
        if(tmp != null)
            return tmp;
        return null;
    }
    public boolean matchTree(TreeNode t1, TreeNode t2){
        if(t1 == null){
            return t2 == null;
        }
        if(t2 == null)
            return false;
        if(t1.val != t2.val)
            return false;
        return matchTree(t1.left, t2.left)&&matchTree(t1.right, t2.right);
    }
    public boolean containsTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return subTree(t1, t2) != null;
    }

    //4.9
    //我感觉答案是错误的，只考虑了从上到下的
    public ArrayList<ArrayList<Integer>> dfs(TreeNode root, int sum){
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> left = dfs(root.left, sum);
        ArrayList<ArrayList<Integer>> right = dfs(root.left, sum);
        for(ArrayList<Integer> _left : left){
            for(ArrayList<Integer> _right : right){
                if(_left.get(0) + root.val + _right.get(0) == sum){
                    //print _left, root, _right
                }
            }
        }
        for(ArrayList<Integer> _left : left){
            if(_left.get(0) + root.val == sum){
                //print root, _left
            }
            _left.set(0, _left.get(0) + root.val);
            _left.add(1, root.val);
            result.add(_left);
        }
        for(ArrayList<Integer> _right : right){
            if(_right.get(0) + root.val == sum){
                //print root, _left
            }
            _right.set(0, _right.get(0) + root.val);
            _right.add(1, root.val);
            result.add(_right);
        }
        if(root.val == sum){
            //print root
        }
        ArrayList<Integer> mid = new ArrayList<Integer>();
        mid.add(root.val);
        mid.add(root.val);
        result.add(mid);
        return result;
    }
    public void findSum(TreeNode root, int sum){
        dfs(root, sum);
    }
}
