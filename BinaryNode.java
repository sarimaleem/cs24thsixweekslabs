public class BinaryNode {

    String value;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public String toString() {
        return "Value:" + getValue() + ", Left:" + getLeft() + ", Right:" + getRight();
    }

}
