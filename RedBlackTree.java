public class RedBlackTree {
    RedBlackNode root;

    public void add()

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


}
