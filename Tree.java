import java.util.*;

public class Tree {

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Binary Search Tree (BST)
    static class BinarySearchTree {
        private TreeNode root;

        public BinarySearchTree() {
            this.root = null;
        }

        public void insert(int val) {
            root = insertNode(root, val);
        }

        private TreeNode insertNode(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insertNode(root.left, val);
            } else if (val > root.val) {
                root.right = insertNode(root.right, val);
            }
            return root;
        }
    }

    // AVL Tree
    static class AVLTree {
        private TreeNode root;

        public AVLTree() {
            this.root = null;
        }

        public void insert(int val) {
            root = insertNode(root, val);
        }

        private TreeNode insertNode(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insertNode(root.left, val);
            } else if (val > root.val) {
                root.right = insertNode(root.right, val);
            }
            // Update height and balance factor
            updateHeightAndBalance(root);
            // Perform rotations if necessary
            return balance(root);
        }

        private int height(TreeNode node) {
            return node == null ? -1 : Math.max(height(node.left), height(node.right)) + 1;
        }

        private int balanceFactor(TreeNode node) {
            return height(node.left) - height(node.right);
        }

        private void updateHeightAndBalance(TreeNode node) {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            node.val = Math.max(leftHeight, rightHeight) + 1;
            node.val = balanceFactor(node);
        }

        private TreeNode rotateRight(TreeNode y) {
            TreeNode x = y.left;
            TreeNode T2 = x.right;
            x.right = y;
            y.left = T2;
            updateHeightAndBalance(y);
            updateHeightAndBalance(x);
            return x;
        }

        private TreeNode rotateLeft(TreeNode x) {
            TreeNode y = x.right;
            TreeNode T2 = y.left;
            y.left = x;
            x.right = T2;
            updateHeightAndBalance(x);
            updateHeightAndBalance(y);
            return y;
        }

        private TreeNode balance(TreeNode node) {
            if (balanceFactor(node) > 1) {
                if (balanceFactor(node.left) < 0) {
                    node.left = rotateLeft(node.left);
                }
                return rotateRight(node);
            }
            if (balanceFactor(node) < -1) {
                if (balanceFactor(node.right) > 0) {
                    node.right = rotateRight(node.right);
                }
                return rotateLeft(node);
            }
            return node;
        }
    }

    // Red-Black Tree
    static class RedBlackTree {
        private static final boolean RED = true;
        private static final boolean BLACK = false;

        static class Node {
            int val;
            Node left, right;
            boolean color;

            Node(int val, boolean color) {
                this.val = val;
                this.color = color;
            }
        }

        private Node root;

        public RedBlackTree() {
            this.root = null;
        }

        private boolean isRed(Node x) {
            if (x == null) return false;
            return x.color == RED;
        }

        public void insert(int val) {
            root = insert(root, val);
            root.color = BLACK; // Ensure root is always black
        }

        private Node insert(Node h, int val) {
            if (h == null) return new Node(val, RED);

            if (val < h.val) h.left = insert(h.left, val);
            else if (val > h.val) h.right = insert(h.right, val);
            else h.val = val;

            if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
            if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
            if (isRed(h.left) && isRed(h.right)) flipColors(h);

            return h;
        }

        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = h.color;
            h.color = RED;
            return x;
        }

        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.color = h.color;
            h.color = RED;
            return x;
        }

        private void flipColors(Node h) {
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }
    }

    public static void main(String[] args) {
        // Binary Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Binary Search Tree (BST)
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(2);
        bst.insert(4);

        // AVL Tree
        AVLTree avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(3);
        avlTree.insert(8);
        avlTree.insert(2);
        avlTree.insert(4);

        // Red-Black Tree
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(5);
        redBlackTree.insert(3);
        redBlackTree.insert(8);
        redBlackTree.insert(2);
        redBlackTree.insert(4);
   
