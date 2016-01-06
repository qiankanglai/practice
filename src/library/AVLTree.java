package library;

import java.util.ArrayList;
import java.util.List;

/**
 * An AVL tree is a self-balancing binary search tree, and it was the first such
 * data structure to be invented. In an AVL tree, the heights of the two child
 * subtrees of any node differ by at most one. AVL trees are often compared with
 * red-black trees because they support the same set of operations and because
 * red-black trees also take O(log n) time for the basic operations. Because AVL
 * trees are more rigidly balanced, they are faster than red-black trees for
 * lookup intensive applications. However, red-black trees are faster for
 * insertion and removal.
 * 
 * http://en.wikipedia.org/wiki/AVL_tree
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    private enum Balance {
        LEFT_LEFT, LEFT_RIGHT, RIGHT_LEFT, RIGHT_RIGHT
    };

    @Override
    public boolean add(T value) {
        AVLNode<T> newNode = new AVLNode<T>(null, value);
        return (this.addValue(newNode) != null);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    protected Node<T> addValue(Node<T> newNode) {
        Node<T> nodeToReturn = super.addValue(newNode);
        AVLNode<T> nodeAdded = (AVLNode<T>) nodeToReturn;

        while (nodeAdded != null) {
            nodeAdded.updateHeight();
            balanceAfterInsert(nodeAdded);
            nodeAdded = (AVLNode<T>) nodeAdded.parent;
        }

        return nodeToReturn;
    }

    /**
     * Balance the tree according to the AVL post-insert algorithm.
     * 
     * @param node
     *            Root of tree to balance.
     */
    private void balanceAfterInsert(AVLNode<T> node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor > 1 || balanceFactor < -1) {
            AVLNode<T> parent = null;
            AVLNode<T> child = null;
            Balance balance = null;
            if (balanceFactor < 0) {
                parent = (AVLNode<T>) node.left;
                balanceFactor = parent.getBalanceFactor();
                if (balanceFactor < 0) {
                    child = (AVLNode<T>) parent.left;
                    balance = Balance.LEFT_LEFT;
                } else {
                    child = (AVLNode<T>) parent.right;
                    balance = Balance.LEFT_RIGHT;
                }
            } else {
                parent = (AVLNode<T>) node.right;
                balanceFactor = parent.getBalanceFactor();
                if (balanceFactor < 0) {
                    child = (AVLNode<T>) parent.left;
                    balance = Balance.RIGHT_LEFT;
                } else {
                    child = (AVLNode<T>) parent.right;
                    balance = Balance.RIGHT_RIGHT;
                }
            }

            if (balance == Balance.LEFT_RIGHT) {
                // Left-Right (Left rotation, right rotation)
                rotateLeft(parent);
                rotateRight(node);
            } else if (balance == Balance.RIGHT_LEFT) {
                // Right-Left (Right rotation, left rotation)
                rotateRight(parent);
                rotateLeft(node);
            } else if (balance == Balance.LEFT_LEFT) {
                // Left-Left (Right rotation)
                rotateRight(node);
            } else {
                // Right-Right (Left rotation)
                rotateLeft(node);
            }

            node.updateHeight(); // New child node
            child.updateHeight(); // New child node
            parent.updateHeight(); // New Parent node
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node<T> removeValue(T value) {
        // Find node to remove
        Node<T> nodeToRemoved = this.getNode(value);
        if (nodeToRemoved != null) {
            // Find the replacement node
            Node<T> replacementNode = this.getReplacementNode(nodeToRemoved);

            // Find the parent of the replacement node to re-factor the
            // height/balance of the tree
            AVLNode<T> nodeToRefactor = null;
            if (replacementNode != null)
                nodeToRefactor = (AVLNode<T>) replacementNode.parent;
            if (nodeToRefactor == null)
                nodeToRefactor = (AVLNode<T>) nodeToRemoved.parent;
            if (nodeToRefactor != null && nodeToRefactor.equals(nodeToRemoved))
                nodeToRefactor = (AVLNode<T>) replacementNode;

            // Replace the node
            replaceNodeWithNode(nodeToRemoved, replacementNode);

            // Re-balance the tree all the way up the tree
            if (nodeToRefactor != null) {
                while (nodeToRefactor != null) {
                    nodeToRefactor.updateHeight();
                    balanceAfterDelete(nodeToRefactor);
                    nodeToRefactor = (AVLNode<T>) nodeToRefactor.parent;
                }
            }
        }
        return nodeToRemoved;
    }

    /**
     * Balance the tree according to the AVL post-delete algorithm.
     * 
     * @param node
     *            Root of tree to balance.
     */
    private void balanceAfterDelete(AVLNode<T> node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor == -2 || balanceFactor == 2) {
            if (balanceFactor == -2) {
                AVLNode<T> ll = (AVLNode<T>) node.left.left;
                int lesser = (ll != null) ? ll.height : 0;
                AVLNode<T> lr = (AVLNode<T>) node.left.right;
                int greater = (lr != null) ? lr.height : 0;
                if (lesser >= greater) {
                    rotateRight(node);
                    node.updateHeight();
                    if (node.parent != null)
                        ((AVLNode<T>) node.parent).updateHeight();
                } else {
                    rotateLeft(node.left);
                    rotateRight(node);

                    AVLNode<T> p = (AVLNode<T>) node.parent;
                    if (p.left != null)
                        ((AVLNode<T>) p.left).updateHeight();
                    if (p.right != null)
                        ((AVLNode<T>) p.right).updateHeight();
                    p.updateHeight();
                }
            } else if (balanceFactor == 2) {
                AVLNode<T> rr = (AVLNode<T>) node.right.right;
                int greater = (rr != null) ? rr.height : 0;
                AVLNode<T> rl = (AVLNode<T>) node.right.left;
                int lesser = (rl != null) ? rl.height : 0;
                if (greater >= lesser) {
                    rotateLeft(node);
                    node.updateHeight();
                    if (node.parent != null)
                        ((AVLNode<T>) node.parent).updateHeight();
                } else {
                    rotateRight(node.right);
                    rotateLeft(node);

                    AVLNode<T> p = (AVLNode<T>) node.parent;
                    if (p.left != null)
                        ((AVLNode<T>) p.left).updateHeight();
                    if (p.right != null)
                        ((AVLNode<T>) p.right).updateHeight();
                    p.updateHeight();
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean validateNode(Node<T> node) {
        boolean bst = super.validateNode(node);
        if (!bst)
            return false;

        AVLNode<T> avlNode = (AVLNode<T>) node;
        int balanceFactor = avlNode.getBalanceFactor();
        if (balanceFactor > 1 || balanceFactor < -1) {
            return false;
        }
        if (avlNode.isLeaf()) {
            if (avlNode.height != 1)
                return false;
        } else {
            AVLNode<T> avlNodeLesser = (AVLNode<T>) avlNode.left;
            int lesserHeight = 1;
            if (avlNodeLesser != null)
                lesserHeight = avlNodeLesser.height;

            AVLNode<T> avlNodeGreater = (AVLNode<T>) avlNode.right;
            int greaterHeight = 1;
            if (avlNodeGreater != null)
                greaterHeight = avlNodeGreater.height;

            if (avlNode.height == (lesserHeight + 1) || avlNode.height == (greaterHeight + 1))
                return true;
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return AVLTreePrinter.getString(this);
    }

    protected static class AVLNode<T extends Comparable<T>> extends Node<T> {

        protected int height = 1;

        /**
         * Constructor for an AVL node
         * 
         * @param parent
         *            Parent of the node in the tree, can be NULL.
         * @param value
         *            Value of the node in the tree.
         */
        protected AVLNode(Node<T> parent, T value) {
            super(parent, value);
        }

        /**
         * Determines is this node is a leaf (has no children).
         * 
         * @return True if this node is a leaf.
         */
        protected boolean isLeaf() {
            return ((left == null) && (right == null));
        }

        /**
         * Updates the height of this node based on it's children.
         */
        protected void updateHeight() {
            int lesserHeight = 0;
            int greaterHeight = 0;
            if (left != null) {
                AVLNode<T> lesserAVLNode = (AVLNode<T>) left;
                lesserHeight = lesserAVLNode.height;
            }
            if (right != null) {
                AVLNode<T> greaterAVLNode = (AVLNode<T>) right;
                greaterHeight = greaterAVLNode.height;
            }

            if (lesserHeight > greaterHeight) {
                height = lesserHeight + 1;
            } else {
                height = greaterHeight + 1;
            }
        }

        /**
         * Get the balance factor for this node.
         * 
         * @return An integer representing the balance factor for this node. It
         *         will be negative if the left branch is longer than the
         *         right branch.
         */
        protected int getBalanceFactor() {
            int lesserHeight = 0;
            int greaterHeight = 0;
            if (left != null) {
                AVLNode<T> lesserAVLNode = (AVLNode<T>) left;
                lesserHeight = lesserAVLNode.height;
            }
            if (right != null) {
                AVLNode<T> greaterAVLNode = (AVLNode<T>) right;
                greaterHeight = greaterAVLNode.height;
            }
            return greaterHeight - lesserHeight;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "value=" + value + " height=" + height + " parent=" + ((parent != null) ? parent.value : "NULL")
                    + " left=" + ((left != null) ? left.value : "NULL") + " right="
                    + ((right != null) ? right.value : "NULL");
        }
    }

    protected static class AVLTreePrinter {

        public static <T extends Comparable<T>> String getString(AVLTree<T> tree) {
            if (tree.root == null)
                return "Tree has no nodes.";
            return getString((AVLNode<T>) tree.root, "", true);
        }

        public static <T extends Comparable<T>> String getString(AVLNode<T> node) {
            if (node == null)
                return "Sub-tree has no nodes.";
            return getString(node, "", true);
        }

        private static <T extends Comparable<T>> String getString(AVLNode<T> node, String prefix, boolean isTail) {
            StringBuilder builder = new StringBuilder();

            builder.append(prefix + (isTail ? "└── " : "├── ") + "(" + node.height + ") " + node.value + "\n");
            List<Node<T>> children = null;
            if (node.left != null || node.right != null) {
                children = new ArrayList<Node<T>>(2);
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            if (children != null) {
                for (int i = 0; i < children.size() - 1; i++) {
                    builder.append(getString((AVLNode<T>) children.get(i), prefix + (isTail ? "    " : "│   "), false));
                }
                if (children.size() >= 1) {
                    builder.append(getString((AVLNode<T>) children.get(children.size() - 1), prefix
                            + (isTail ? "    " : "│   "), true));
                }
            }

            return builder.toString();
        }
    }
}
