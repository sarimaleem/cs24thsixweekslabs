public class RedBlackTree {
    RedBlackNode root;

    public RedBlackTree() {
        root = null;
    }

    public void add(RedBlackNode node) {
        if (root == null) {
            root = node;
            root.setColor("black");
            return;
        }
    }

    public void bstInsert(RedBlackNode node, RedBlackNode toInsert) {
        if (toInsert.getValue().compareTo(node.getValue()) < 0) { //insert left node
            if (node.getLeft() == null) {
                node.setLeft(toInsert);
            } else {
                bstInsert(node.getLeft(), toInsert);
            }
        } else { //insert right node
            if (node.getRight() == null) {
                node.setRight(toInsert);
            } else {
                bstInsert(node.getRight(), toInsert);
            }
        }
    }

    public RedBlackNode getUncle(RedBlackNode node) {
        RedBlackNode grandparent = root;

        while (true) {
            if(grandparent.getLeft().getLeft() == node || grandparent.getLeft().getRight() == node)
                return grandparent.getRight();
            else if (grandparent.getRight().getRight() == node || grandparent.getRight().getLeft() == node)
                return grandparent.getLeft();

            if (grandparent.getValue().compareTo(node.getValue()) < 0)
                grandparent = grandparent.getLeft();
            else
                grandparent = grandparent.getRight();
        }
    }

    public RedBlackNode getGrandParent(RedBlackNode node) {
        RedBlackNode grandparent = root;

        while (true) {
            if(grandparent.getLeft().getLeft() == node || grandparent.getLeft().getRight() == node)
                return grandparent;
            else if (grandparent.getRight().getRight() == node || grandparent.getRight().getLeft() == node)
                return grandparent;

            if (grandparent.getValue().compareTo(node.getValue()) < 0)
                grandparent = grandparent.getLeft();
            else
                grandparent = grandparent.getRight();
        }
    }

    public RedBlackNode getParent (RedBlackNode node) {
        RedBlackNode grandparent = root;

        while (true) {
            if(grandparent.getLeft().getLeft() == node || grandparent.getLeft().getRight() == node)
                return grandparent.getLeft();
            else if (grandparent.getRight().getRight() == node || grandparent.getRight().getLeft() == node)
                return grandparent.getRight();

            if (grandparent.getValue().compareTo(node.getValue()) < 0)
                grandparent = grandparent.getLeft();
            else
                grandparent = grandparent.getRight();
        }
    }

}
