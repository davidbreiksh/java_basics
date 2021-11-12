import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private List<Node<T>> children;
    private Node<T> parent = null;
    private final String url;

    public Node(String url) {
        this.url = url;
        children = new ArrayList<>();
    }

    public Node<T> addChild(Node<T> child) {
        if (!children.contains(child) && child.getUrl().startsWith(url)) {
            child.setParent(this);
            this.children.add(child);
        }
        return child;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        this.children = children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }
}