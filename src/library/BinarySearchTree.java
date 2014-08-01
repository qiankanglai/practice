package library;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Queue;
import java.util.Set;


/**
 * A binary search tree (BST), which may sometimes also be called an ordered or
 * sorted binary tree, is a node-based binary tree data structure which has the
 * following properties: 1) The left subtree of a node contains only nodes with
 * keys less than the node's key. 2) The right subtree of a node contains only
 * nodes with keys right than the node's key. 3) Both the left and right
 * subtrees must also be binary search trees.
 * 
 * http://en.wikipedia.org/wiki/Binary_search_tree
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<T extends Comparable<T>> {

    private int modifications = 0;

    protected static final Random RANDOM = new Random();

    protected enum Position {
        LEFT, RIGHT
    };

    protected Node<T> root = null;
    protected int size = 0;

    public enum DepthFirstSearchOrder {
        inOrder, preOrder, postOrder
    };

    /**
     * Default constructor.
     */
    public BinarySearchTree() { }

    /**
     * {@inheritDoc}
     */
    public boolean add(T value) {
        Node<T> newNode = new Node<T>(null, value);
        return (this.addValue(newNode) != null);
    }

    /**
     * Add value to the tree and return the Node that was added. Tree can
     * contain multiple equal values.
     * 
     * @param newNode
     *            T to add to the tree.
     * @return Node<T> which was added to the tree.
     */
    protected Node<T> addValue(Node<T> newNode) {
        // If root is null, assign
        if (root == null) {
            root = newNode;
            size++;
            return newNode;
        }

        Node<T> node = root;
        while (node != null) {
            if (newNode.value.compareTo(node.value) <= 0) {
                // Less than or equal to goes left
                if (node.left == null) {
                    // New left node
                    node.left = newNode;
                    newNode.parent = node;
                    size++;
                    return newNode;
                }
                node = node.left;
            } else {
                // Greater than goes right
                if (node.right == null) {
                    // New right node
                    node.right = newNode;
                    newNode.parent = node;
                    size++;
                    return newNode;
                }
                node = node.right;
            }
        }

        return newNode;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(T value) {
        Node<T> node = getNode(value);
        return (node != null);
    }

    /**
     * Locate T in the tree.
     * 
     * @param value
     *            T to locate in the tree.
     * @return Node<T> representing first reference of value in tree or NULL if
     *         not found.
     */
    protected Node<T> getNode(T value) {
        Node<T> node = root;
        while (node != null && node.value != null) {
            if (value.compareTo(node.value) == 0) {
                return node;
            } else if (value.compareTo(node.value) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    /**
     * Rotate tree left at sub-tree rooted at node.
     * 
     * @param node
     *            Root of tree to rotate left.
     */
    protected void rotateLeft(Node<T> node) {
        Position parentPosition = null;
        Node<T> parent = node.parent;
        if (parent != null) {
            if (node.equals(parent.left)) {
                // Lesser
                parentPosition = Position.LEFT;
            } else {
                // Greater
                parentPosition = Position.RIGHT;
            }
        }

        Node<T> greater = node.right;
        node.right = null;
        Node<T> lesser = greater.left;

        greater.left = node;
        node.parent = greater;

        node.right = lesser;
        if (lesser != null)
            lesser.parent = node;

        if (parentPosition != null) {
            if (parentPosition == Position.LEFT) {
                parent.left = greater;
            } else {
                parent.right = greater;
            }
            greater.parent = parent;
        } else {
            root = greater;
            greater.parent = null;
        }
    }

    /**
     * Rotate tree right at sub-tree rooted at node.
     * 
     * @param node
     *            Root of tree to rotate left.
     */
    protected void rotateRight(Node<T> node) {
        Position parentPosition = null;
        Node<T> parent = node.parent;
        if (parent != null) {
            if (node.equals(parent.left)) {
                // Lesser
                parentPosition = Position.LEFT;
            } else {
                // Greater
                parentPosition = Position.RIGHT;
            }
        }

        Node<T> lesser = node.left;
        node.left = null;
        Node<T> greater = lesser.right;

        lesser.right = node;
        node.parent = lesser;

        node.left = greater;
        if (greater != null)
            greater.parent = node;

        if (parentPosition != null) {
            if (parentPosition == Position.LEFT) {
                parent.left = lesser;
            } else {
                parent.right = lesser;
            }
            lesser.parent = parent;
        } else {
            root = lesser;
            lesser.parent = null;
        }
    }

    public T getGreatest() {
        Node<T> node = getGreatest(root);
        if(node == null)
            return null;
        else
            return node.value;
    }
    public T getLeast() {
        Node<T> node = getLeast(root);
        if(node == null)
            return null;
        else
            return node.value;
    }

    /**
     * Get greatest node in sub-tree rooted at startingNode. The search does not
     * include startingNode in it's results.
     * 
     * @param startingNode
     *            Root of tree to search.
     * @return Node<T> which represents the greatest node in the startingNode
     *         sub-tree or NULL if startingNode has no right children.
     */
    protected Node<T> getGreatest(Node<T> startingNode) {
        if (startingNode == null)
            return null;

        Node<T> greater = startingNode;
        while (greater != null && greater.value != null) {
            Node<T> node = greater.right;
            if (node != null && node.value != null)
                greater = node;
            else
                break;
        }
        return greater;
    }

    /**
     * Get least node in sub-tree rooted at startingNode. The search does not
     * include startingNode in it's results.
     * 
     * @param startingNode
     *            Root of tree to search.
     * @return Node<T> which represents the least node in the startingNode
     *         sub-tree or NULL if startingNode has no left children.
     */
    protected Node<T> getLeast(Node<T> startingNode) {
        if (startingNode == null)
            return null;

        Node<T> lesser = startingNode;
        while (lesser != null && lesser.value != null) {
            Node<T> node = lesser.left;
            if (node != null && node.value != null)
                lesser = node;
            else
                break;
        }
        return lesser;
    }

    /**
     * {@inheritDoc}
     */
    public T remove(T value) {
        Node<T> nodeToRemove = this.removeValue(value);
        return ((nodeToRemove!=null)?nodeToRemove.value :null);
    }

    /**
     * Remove first occurrence of value in the tree.
     * 
     * @param value
     *            T to remove from the tree.
     * @return Node<T> which was removed from the tree.
     */
    protected Node<T> removeValue(T value) {
        Node<T> nodeToRemoved = this.getNode(value);
        if (nodeToRemoved != null) nodeToRemoved = removeNode(nodeToRemoved);
        return nodeToRemoved;
    }

    /**
     * Remove the node using a replacement
     * 
     * @param nodeToRemoved
     *            Node<T> to remove from the tree.
     * @return nodeRemove
     *            Node<T> removed from the tree, it can be different
     *            then the parameter in some cases.
     */
    protected Node<T> removeNode(Node<T> nodeToRemoved) {
        if (nodeToRemoved != null) {
            Node<T> replacementNode = this.getReplacementNode(nodeToRemoved);
            replaceNodeWithNode(nodeToRemoved, replacementNode);
        }
        return nodeToRemoved;
    }

    /**
     * Get the proper replacement node according to the binary search tree
     * algorithm from the tree.
     * 
     * @param nodeToRemoved
     *            Node<T> to find a replacement for.
     * @return Node<T> which can be used to replace nodeToRemoved. nodeToRemoved
     *         should NOT be NULL.
     */
    protected Node<T> getReplacementNode(Node<T> nodeToRemoved) {
        Node<T> replacement = null;
        if (nodeToRemoved.left != null && nodeToRemoved.right == null) {
            // Using the less subtree
            replacement = nodeToRemoved.left;
        } else if (nodeToRemoved.right != null && nodeToRemoved.left == null) {
            // Using the right subtree (there is no left subtree, no
            // refactoring)
            replacement = nodeToRemoved.right;
        } else if (nodeToRemoved.right != null && nodeToRemoved.left != null) {
            // Two children
            // Add some randomness to deletions, so we don't always use the
            // greatest/least on deletion
            if (modifications % 2 != 0) {
                replacement = this.getGreatest(nodeToRemoved.left);
                if (replacement == null)
                    replacement = nodeToRemoved.left;
            } else {
                replacement = this.getLeast(nodeToRemoved.right);
                if (replacement == null)
                    replacement = nodeToRemoved.right;
            }
            modifications++;
        }
        return replacement;
    }

    /**
     * Replace nodeToRemoved with replacementNode in the tree.
     * 
     * @param nodeToRemoved
     *            Node<T> to remove replace in the tree. nodeToRemoved should
     *            NOT be NULL.
     * @param replacementNode
     *            Node<T> to replace nodeToRemoved in the tree. replacementNode
     *            can be NULL.
     */
    protected void replaceNodeWithNode(Node<T> nodeToRemoved, Node<T> replacementNode) {
        if (replacementNode != null) {
            // Save for later
            Node<T> replacementNodeLesser = replacementNode.left;
            Node<T> replacementNodeGreater = replacementNode.right;

            // Replace replacementNode's branches with nodeToRemove's branches
            Node<T> nodeToRemoveLesser = nodeToRemoved.left;
            if (nodeToRemoveLesser != null && !nodeToRemoveLesser.equals(replacementNode)) {
                replacementNode.left = nodeToRemoveLesser;
                nodeToRemoveLesser.parent = replacementNode;
            }
            Node<T> nodeToRemoveGreater = nodeToRemoved.right;
            if (nodeToRemoveGreater != null && !nodeToRemoveGreater.equals(replacementNode)) {
                replacementNode.right = nodeToRemoveGreater;
                nodeToRemoveGreater.parent = replacementNode;
            }

            // Remove link from replacementNode's parent to replacement
            Node<T> replacementParent = replacementNode.parent;
            if (replacementParent != null && !replacementParent.equals(nodeToRemoved)) {
                Node<T> replacementParentLesser = replacementParent.left;
                Node<T> replacementParentGreater = replacementParent.right;
                if (replacementParentLesser != null && replacementParentLesser.equals(replacementNode)) {
                    replacementParent.left = replacementNodeGreater;
                    if (replacementNodeGreater != null)
                        replacementNodeGreater.parent = replacementParent;
                } else if (replacementParentGreater != null && replacementParentGreater.equals(replacementNode)) {
                    replacementParent.right = replacementNodeLesser;
                    if (replacementNodeLesser != null)
                        replacementNodeLesser.parent = replacementParent;
                }
            }
        }

        // Update the link in the tree from the nodeToRemoved to the
        // replacementNode
        Node<T> parent = nodeToRemoved.parent;
        if (parent == null) {
            // Replacing the root node
            root = replacementNode;
            if (root != null)
                root.parent = null;
        } else if (parent.left != null && (parent.left.value.compareTo(nodeToRemoved.value) == 0)) {
            parent.left = replacementNode;
            if (replacementNode != null)
                replacementNode.parent = parent;
        } else if (parent.right != null && (parent.right.value.compareTo(nodeToRemoved.value) == 0)) {
            parent.right = replacementNode;
            if (replacementNode != null)
                replacementNode.parent = parent;
        }
        size--;
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public boolean validate() {
        if (root == null) return true;
        return validateNode(root);
    }

    /**
     * Validate the node for all Binary Search Tree invariants.
     * 
     * @param node
     *            Node<T> to validate in the tree. node should NOT be NULL.
     * @return True if the node is valid.
     */
    protected boolean validateNode(Node<T> node) {
        Node<T> lesser = node.left;
        Node<T> greater = node.right;

        boolean lesserCheck = true;
        if (lesser != null && lesser.value != null) {
            lesserCheck = (lesser.value.compareTo(node.value) <= 0);
            if (lesserCheck)
                lesserCheck = validateNode(lesser);
        }
        if (!lesserCheck)
            return false;

        boolean greaterCheck = true;
        if (greater != null && greater.value != null) {
            greaterCheck = (greater.value.compareTo(node.value) > 0);
            if (greaterCheck)
                greaterCheck = validateNode(greater);
        }
        return greaterCheck;
    }

    /**
     * Get an array representation of the tree in breath first search order.
     * 
     * @return breath first search sorted array representing the tree.
     */
    public T[] getBFS() {
        Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
        T[] values = (T[]) new Comparable[size];
        int count = 0;
        Node<T> node = root;
        while (node != null) {
            values[count++] = node.value;
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            if (!queue.isEmpty())
                node = queue.remove();
            else
                node = null;
        }
        return values;
    }

    /**
     * Get an array representation of the tree in level order.
     * 
     * @return level order sorted array representing the tree.
     */
    public T[] getLevelOrder() {
        return getBFS();
    }

    /**
     * Get an array representation of the tree in-order.
     * 
     * @return in-order sorted array representing the tree.
     */
    public T[] getDFS(DepthFirstSearchOrder order) {
        Set<Node<T>> added = new HashSet<Node<T>>(2);
        T[] nodes = (T[]) new Comparable[size];
        int index = 0;
        Node<T> node = root;
        while (index < size && node != null) {
            Node<T> parent = node.parent;
            Node<T> lesser = (node.left != null && !added.contains(node.left)) ? node.left : null;
            Node<T> greater = (node.right != null && !added.contains(node.right)) ? node.right : null;

            if (parent == null && lesser == null && greater == null) {
                if (!added.contains(node))
                    nodes[index++] = node.value;
                break;
            }

            if (order == DepthFirstSearchOrder.inOrder) {
                if (lesser != null) {
                    node = lesser;
                } else {
                    if (!added.contains(node)) {
                        nodes[index++] = node.value;
                        added.add(node);
                    }
                    if (greater != null) {
                        node = greater;
                    } else if (added.contains(node)) {
                        node = parent;
                    } else {
                        // We should not get here. Stop the loop!
                        node = null;
                    }
                }
            } else if (order == DepthFirstSearchOrder.preOrder) {
                if (!added.contains(node)) {
                    nodes[index++] = node.value;
                    added.add(node);
                }
                if (lesser != null) {
                    node = lesser;
                } else if (greater != null) {
                    node = greater;
                } else if (added.contains(node)) {
                    node = parent;
                } else {
                    // We should not get here. Stop the loop!
                    node = null;
                }
            } else {
                // post-Order
                if (lesser != null) {
                    node = lesser;
                } else {
                    if (!added.contains(node)) {
                        nodes[index++] = node.value;
                        added.add(node);
                    }
                    if (greater != null) {
                        node = greater;
                    } else if (added.contains(node)) {
                        node = parent;
                    } else {
                        // We should not get here. Stop the loop!
                        node = null;
                    }
                }
            }
        }
        return nodes;
    }

    /**
     * Get an array representation of the tree in sorted order.
     * 
     * @return sorted array representing the tree.
     */
    public T[] getSorted() {
        // Depth first search to traverse the tree in-order sorted.
        return getDFS(DepthFirstSearchOrder.inOrder);
    }

    @Override
    public String toString() {
        return TreePrinter.getString(this);
    }

    protected static class Node<T extends Comparable<T>> {

        protected T value = null;
        protected Node<T> parent = null;
        protected Node<T> left = null;
        protected Node<T> right = null;

        /**
         * Node constructor.
         * 
         * @param parent
         *            Parent link in tree. parent can be NULL.
         * @param id
         *            T representing the node in the tree.
         */
        protected Node(Node<T> parent, T id) {
            this.parent = parent;
            this.value = id;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "value =" + value + " parent=" + ((parent != null) ? parent.value : "NULL") + " left="
                    + ((left != null) ? left.value : "NULL") + " right=" + ((right != null) ? right.value : "NULL");
        }
    }

    protected static class TreePrinter {

        public static <T extends Comparable<T>> String getString(BinarySearchTree<T> tree) {
            if (tree.root == null)
                return "Tree has no nodes.";
            return getString(tree.root, "", true);
        }

        private static <T extends Comparable<T>> String getString(Node<T> node, String prefix, boolean isTail) {
            StringBuilder builder = new StringBuilder();

            if (node.parent != null) {
                String side = "left";
                if (node.equals(node.parent.right))
                    side = "right";
                builder.append(prefix + (isTail ? "└── " : "├── ") + "(" + side + ") " + node.value + "\n");
            } else {
                builder.append(prefix + (isTail ? "└── " : "├── ") + node.value + "\n");
            }
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
                    builder.append(getString(children.get(i), prefix + (isTail ? "    " : "│   "), false));
                }
                if (children.size() >= 1) {
                    builder.append(getString(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "),
                            true));
                }
            }

            return builder.toString();
        }
    }
}
