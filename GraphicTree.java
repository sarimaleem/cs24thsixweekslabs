public class GraphicTree {

    GraphicBinaryNode root;

    public void add(GraphicBinaryNode node) {
        if (root == null) {
            root = node;
        } else {
            insert(root, node);
        }
    }

    public void insert(GraphicBinaryNode node, GraphicBinaryNode toInsert) {
        if (toInsert.getValue() < node.getValue()) { //insert left node
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

    public int getNumLevels() {
        return getNumLevels(root);
    }

    public int getNumLevels(GraphicBinaryNode node) {

        if(node == null) return 0;

        return 1 + Math.max(getNumLevels(node.getLeft()), getNumLevels(node.getRight()));
    }
}
