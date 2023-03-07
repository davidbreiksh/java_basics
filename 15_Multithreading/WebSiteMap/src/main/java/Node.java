import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.RecursiveTask;

public class Node  {
    private String url;
    private volatile Node parent;
    private volatile int depth;
    private volatile CopyOnWriteArraySet<Node> sublinks;

    public Node(String url) {
        this.url = url;
        sublinks = new CopyOnWriteArraySet<>();
        depth = 0;
        parent = null;

    }

    public void addSublinks(Node sublink) {
        if (!sublinks.contains(sublink) && sublink.getUrl().startsWith(url)) {
            this.sublinks.add(sublink);
            sublink.setParent(this);
        }
    }

    private void setParent(Node siteMapNode) {
        synchronized (this) {
            this.parent = siteMapNode;
            this.depth = setDepth();
        }
    }

    public int getDepth() {
        return depth;
    }

    private int setDepth() {
        if (parent == null) {
            return 0;
        }
        return 1 + parent.getDepth();
    }

    public CopyOnWriteArraySet<Node> getSublinks() {
        return sublinks;
    }

    public String getUrl() {
        return url;
    }
}