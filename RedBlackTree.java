import java.util.Queue;
import java.util.LinkedList;

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

        bstInsert(root, node);
        checkViolations(node);

    }

    public void checkViolations(RedBlackNode node) {

        if (node.getParent() == null) { //root node
            node.setColor("black");
            return;
        }



        if (node.getColor().equals("red") && node.getParent().getColor().equals("black"))
            return;

        if (node.getColor().equals("black") && node.getParent().getColor().equals("red"))
            return;

        if (node.getUncle() != null) { //both parent and uncle are red case
            if (node.getParent().getColor().equals("red") && node.getUncle().getColor().equals("red")) {
                node.getParent().setColor("black");
                node.getUncle().setColor("black");
                node.getGrandParent().setColor("red");
                checkViolations(node.getGrandParent());
                return;
            }
        }


        if (node.getValue().compareTo(node.getGrandParent().getValue()) < 0) {
            if (node.getValue().compareTo(node.getParent().getValue()) < 0) {
                leftLeftCase(node);
            } else {
                leftRightCase(node);
            }
        }  else {
            if (node.getValue().compareTo(node.getParent().getValue()) < 0) {
                rightLeftCase(node);
            } else {
                rightRightCase(node);
            }
        }


    }

    public void leftLeftCase(RedBlackNode node) {
        RedBlackNode grandparent = node.getGrandParent();
        rotateRight(grandparent);
        swapColors(grandparent, grandparent.getParent());
    }

    public void leftRightCase(RedBlackNode node) {
        rotateLeft(node.parent);
        leftLeftCase(node.getLeft());
    }

    public void rightLeftCase(RedBlackNode node) {
        rotateRight(node.parent);
        rightRightCase(node.getRight());
    }

    public void rightRightCase(RedBlackNode node) {
        RedBlackNode grandparent = node.getGrandParent();
        rotateLeft(grandparent);
        swapColors(grandparent, grandparent.getParent());
    }

    public void swapColors(RedBlackNode a, RedBlackNode b) {
        String temp = a.getColor();
        a.setColor(b.getColor());
        b.setColor(temp);
    }

    public void rotateLeft(RedBlackNode h) {
        RedBlackNode x = h.getRight();
        x.setParent(h.getParent());

        if(x.getParent()!= null)
            if(x.getValue().compareTo(x.getParent().getValue()) < 0)
                x.getParent().setLeft(x);
            else
                x.getParent().setRight(x);


        h.setRight(x.getLeft());

        if(h.getRight() != null) h.getRight().setParent(h);

        x.setLeft(h);
        h.setParent(x);

        if (x.getParent() == null)
            root = x;

    }

    public void rotateRight(RedBlackNode h) {
        RedBlackNode x = h.getLeft();
        x.setParent(h.getParent());

        if(x.getParent()!= null)
            if(x.getValue().compareTo(x.getParent().getValue()) < 0)
                x.getParent().setLeft(x);
            else
                x.getParent().setRight(x);;

        h.setLeft(x.getRight());

        if(h.getLeft()!= null)
            h.getLeft().setParent(h);

        x.setRight(h);
        h.setParent(x);

        if (x.getParent() == null)
            root = x;

    }

    public void bstInsert(RedBlackNode node, RedBlackNode toInsert) {
        if (toInsert.getValue().compareTo(node.getValue()) < 0) { //insert left node
            if (node.getLeft() == null) {
                node.setLeft(toInsert);
                toInsert.setParent(node);
            } else {
                bstInsert(node.getLeft(), toInsert);
            }
        } else { //insert right node
            if (node.getRight() == null) {
                node.setRight(toInsert);
                toInsert.setParent(node);
            } else {
                bstInsert(node.getRight(), toInsert);
            }
        }
    }

    public String getLevelOrder() {
        Queue<RedBlackNode> nodes = new LinkedList<>();
        Queue<String> levelOrder = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()) {

            RedBlackNode parent = nodes.poll();
            levelOrder.offer(parent.getValue()+parent.getColor());

            if (parent.getLeft() != null) {
                nodes.offer(parent.getLeft());
            }

            if (parent.getRight() != null) {
                nodes.offer(parent.getRight());
            }
        }

        return levelOrder.toString();
    }
}