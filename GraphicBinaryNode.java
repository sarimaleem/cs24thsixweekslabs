public class GraphicBinaryNode {
     GraphicBinaryNode left;
     GraphicBinaryNode right;
     int value;

    public GraphicBinaryNode(int value) {
        setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(GraphicBinaryNode left) {
        this.left = left;
    }

    public void setRight(GraphicBinaryNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public GraphicBinaryNode getLeft() {
        return left;
    }

    public GraphicBinaryNode getRight() {
        return right;
    }

}
