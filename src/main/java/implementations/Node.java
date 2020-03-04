package implementations;

import interfaces.INode;

public class Node implements INode {

    private String node;
    private String renderer;

    public Node(String node, String renderer) {
        this.node = node;
        this.renderer = renderer;
    }

    @Override
    public String getNode() {
        return node;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }
}
