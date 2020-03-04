package implementations;

import interfaces.ICompositeNode;
import interfaces.INode;

import java.util.List;

public class CompositeNode extends Node implements ICompositeNode {

    private List<INode> nodeList;

    public CompositeNode(String node, String renderer, List<INode> nodeList) {
        super(node, renderer);
        this.nodeList = nodeList;
    }

    @Override
    public List<INode> getNodes() {
        return nodeList;
    }
}
