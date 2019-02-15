public class RedBlackNode {

    String color;
    String value;
    RedBlackNode left;
    RedBlackNode right;
    RedBlackNode parent;

    public RedBlackNode(String value) {
        color = "red";
        setValue(value);
        left = right = null;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setValue(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }

    public RedBlackNode getLeft() {
        return left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public RedBlackNode getParent() {
        return parent;
    }

    public RedBlackNode getGrandParent() {
        return getParent().getParent();
    }

    public RedBlackNode getSibling() {
        if (getParent().getLeft() == this)
            return getParent().getRight();
        return getParent().getLeft();
    }

    public RedBlackNode getUncle() {
        return getParent().getSibling();
    }

    public String toString() {
        return "Value: " + getValue() + getColor();
    }
}
