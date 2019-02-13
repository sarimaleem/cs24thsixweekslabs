import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

import static java.lang.System.*;

public class BinaryTree {

    static int[] vals = new int[] {80, 85, 70, 100, 98, 120};
    static HashMap<Boolean, String> map = new HashMap<>();
    public static void main(String[] args) {

        map.put(true, "full");
        map.put(false, "not full");

        TreeNode root = new TreeNode(90);
        for (int val : vals) {
            insert(root, val);
        }

        out.println("IN ORDER");
        inOrder(root);
        printLines();

        out.println("PRE ORDER");
        preOrder(root);
        printLines();

        out.println("POST ORDER");
        postOrder(root);
        printLines();

        out.println("REVERSE ORDER");
        revOrder(root);
        printLines();

        out.println("Number of Leaves is " + getNumLeaves(root));
        out.println("Number of Levels is " + getNumLevels(root));
        out.println("The Tree Height is " + getHeight(root));
        out.println("Number of nodes is " + getNumNodes(root));
        out.println("The Tree is full " + map.get(isFull(root)));
        out.println("Tree Width is " + getWidth(root));

    }

    public static void printLines() {
        out.println();
        out.println();
    }

    public static void insert(TreeNode node, int value) {
        if (value < node.getValue()) { //insert left node
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else { //insert right node
            if (node.getRight() == null) {
                node.setRight(new TreeNode(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    public static void inOrder(TreeNode node) {
        if (node.getLeft() != null) {
            inOrder(node.getLeft());
        }

        out.print(node.getValue() + " ");

        if (node.getRight() != null) {
            inOrder(node.getRight());
        }
    }

    public static void preOrder(TreeNode node) {

        out.print(node.getValue() + " ");

        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrder(node.getRight());
        }
    }

    public static void postOrder(TreeNode node) {

        if (node.getLeft() != null) {
            postOrder(node.getLeft());
        }

        if (node.getRight() != null) {
            postOrder(node.getRight());
        }

        out.print(node.getValue() + " ");
    }

    public static void revOrder(TreeNode node) {

        if (node.getRight() != null) {
            revOrder(node.getRight());
        }

        out.print(node.getValue() + " ");

        if (node.getLeft() != null) {
            revOrder(node.getLeft());
        }
    }

    public static int getNumLeaves(TreeNode node) {

        if(node == null) return 0;

        if (node.getLeft() == null && node.getRight() == null) return 1;

        return getNumLeaves(node.getLeft()) + getNumLeaves(node.getRight());
    }

    public static int getNumLevels(TreeNode node) {

        if(node == null) return 0;

        return 1 + Math.max(getNumLevels(node.getLeft()), getNumLevels(node.getRight()));
    }

    public static int getHeight(TreeNode node) {
        return getNumLevels(node) - 1;
    }

    public static int getWidth(TreeNode node) {

        if(node == null) return 0;

        int nodeWidth = getNumLevels(node.getLeft()) + getNumLevels(node.getRight()) + 1;
        int leftWidth = getWidth(node.getLeft());
        int rightWidth = getWidth(node.getRight());

        return Math.max(nodeWidth, Math.max(leftWidth, rightWidth));

    }

    public static int getNumNodes(TreeNode node) {

        if(node == null) return 0;

        return 1 + getNumNodes(node.getLeft()) + getNumNodes(node.getRight());
    }

    public static boolean isFull(TreeNode node) {

        if(node.getLeft() == null ^ node.getRight() == null)
            return false;
        else if(node.getRight() == null && node.getLeft()== null)
            return true;
        return isFull(node.getLeft()) && isFull(node.getRight());

    }
}

class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int val) {
        setVal(val);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        setVal(val);
        setLeft(left);
        setRight(right);
    }

    public int getValue() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}