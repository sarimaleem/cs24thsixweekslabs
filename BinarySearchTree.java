import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(BinaryNode node) {
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    public void insert(BinaryNode node, BinaryNode toInsert) {
        if (toInsert.getValue().compareTo(node.getValue()) < 0) { //insert left node
            if (node.getLeft() == null) {
                node.setLeft(toInsert);
            } else {
                insert(node.getLeft(), toInsert);
            }
        } else { //insert right node
            if (node.getRight() == null) {
                node.setRight(toInsert);
            } else {
                insert(node.getRight(), toInsert);
            }
        }
    }

    public String preOrder() {
        return preOrder(root);
    }

    public String preOrder(BinaryNode node) {

        String temp = "";

        temp += node.getValue() + " ";

        if (node.getLeft() != null) {
            temp += preOrder(node.getLeft()) + " ";
        }

        if (node.getRight() != null) {
            temp += preOrder(node.getRight()) + " ";
        }
        return temp.trim();
    }

    public String postOrder() {
        return postOrder(root);
    }

    public String postOrder(BinaryNode node) {
        String temp = "";

        if (node.getLeft() != null) {
            temp += postOrder(node.getLeft()) + " ";
        }

        if (node.getRight() != null) {
            temp += postOrder(node.getRight()) + " ";
        }

        temp += node.getValue() + " ";

        return temp.trim();
    }

    public String inOrder() {
        return inOrder(root);
    }

    public String inOrder(BinaryNode node) {
        String temp = "";

        if (node.getLeft() != null) {
            temp += inOrder(node.getLeft()) + " ";
        }

        temp += node.getValue() + " ";

        if (node.getRight() != null) {
            temp += inOrder(node.getRight()) + " ";
        }

        return temp.trim();
    }

    public String reverseOrder() {
        return reverseOrder(root);
    }

    public String reverseOrder(BinaryNode node) {
        String temp = "";


        if (node.getRight() != null) {
            temp += reverseOrder(node.getRight()) + " ";
        }

        temp += node.getValue() + " ";

        if (node.getLeft() != null) {
            temp += reverseOrder(node.getLeft()) + " ";
        }

        return temp.trim();
    }

    public int getNumLeaves() {
        return getNumLeaves(root);
    }

    public int getNumLeaves(BinaryNode node) {

        if(node == null) return 0;

        if (node.getLeft() == null && node.getRight() == null) return 1;

        return getNumLeaves(node.getLeft()) + getNumLeaves(node.getRight());
    }

    public int getNumLevels() {
        return getNumLevels(root);
    }

    public int getNumLevels(BinaryNode node) {

        if(node == null) return 0;

        return 1 + Math.max(getNumLevels(node.getLeft()), getNumLevels(node.getRight()));
    }

    public int getWidth() {
        return getWidth(root);
    }

    public  int getWidth(BinaryNode node) {

        if(node == null) return 0;

        int nodeWidth = getNumLevels(node.getLeft()) + getNumLevels(node.getRight()) + 1;
        int leftWidth = getWidth(node.getLeft());
        int rightWidth = getWidth(node.getRight());

        return Math.max(nodeWidth, Math.max(leftWidth, rightWidth));

    }

    public int getHeight() {
        return getNumLevels() -1;
    }

    public int getNumNodes() {
        return getNumNodes(root);
    }

    public int getNumNodes(BinaryNode node) {

        if(node == null) return 0;

        return 1 + getNumNodes(node.getLeft()) + getNumNodes(node.getRight());
    }

    public boolean isFull() {
        return isFull(root);
    }

    public static boolean isFull(BinaryNode node) {

        if(node.getLeft() == null ^ node.getRight() == null)
            return false;
        else if(node.getRight() == null && node.getLeft()== null)
            return true;
        return isFull(node.getLeft()) && isFull(node.getRight());
    }

    public boolean contains(String val) {
        Queue<BinaryNode> binaryNodes = new LinkedList<>();

        binaryNodes.add(root);

        while (!binaryNodes.isEmpty()) {
            BinaryNode temp = binaryNodes.poll();

            if (temp.getValue().equals(val)) {
                return true;
            }

            if (temp.getLeft() != null) {
                binaryNodes.add(temp.getLeft());
            }

            if (temp.getRight() != null) {
                binaryNodes.add(temp.getRight());
            }
        }

        return false;

    }

    public String getLargest() {
        BinaryNode temp = root;

        while (temp.getRight() != null) {
            temp = temp.getRight();
        }

        return temp.getValue();
    }

    public String getSmallest() {
        BinaryNode temp = root;

        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }

        return temp.getValue();
    }

    public String levelOrder() {

        Queue<BinaryNode> nodes = new LinkedList<>();
        Stack<String> levelOrder = new Stack<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {

            BinaryNode parent = nodes.poll();
            levelOrder.push(parent.getValue());

            if (parent.getLeft() != null) {
                nodes.offer(parent.getLeft());
            }

            if (parent.getRight() != null) {
                nodes.offer(parent.getRight());
            }
        }

        return levelOrder.toString();

    }

    public BinaryNode remove(String val) {
        BinaryNode temp = searchNode(val);

        if (temp == null) {
            return temp;
        }


        if (temp.getLeft() == null && temp.getRight() == null) {
            temp = null;
            return new BinaryNode(val);
        }

        if (temp.getLeft() == null && temp.getRight() != null) {
            temp = temp.getRight();
            return new BinaryNode(val);
        }

        if (temp.getLeft() != null && temp.getRight() == null) {
            temp = temp.getLeft();
            return new BinaryNode(val);
        }

        BinaryNode min = getMax(temp.getLeft());
        temp.setValue(min.getValue());
        min = null;
        return new BinaryNode(val);

    }

    public BinaryNode searchNode(String val) {

        Queue<BinaryNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            BinaryNode temp = nodes.poll();

            if (temp.getValue().equals(val))
                return temp;

            if (temp.getLeft() != null)
                nodes.offer(temp.getLeft());

            if (temp.getRight() != null)
                nodes.offer(temp.getRight());
        }
        return null;
    }

    public BinaryNode getMax(BinaryNode root) {


        while (root.right != null)
        {
            root = root.right;
        }

        return root;
    }








    public String toString() {
        return inOrder();
    }
}
