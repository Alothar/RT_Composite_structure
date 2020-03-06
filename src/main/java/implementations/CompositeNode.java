package implementations;

import interfaces.ICompositeNode;
import interfaces.INode;

import java.util.List;

/**
 * CompositeNode interface implementation, extends Node.
 * */
public class CompositeNode extends Node implements ICompositeNode {

    private List<INode> nodeList;

    /**
     * All-args constructor.
     *
     * @param code code value to set for this CompositeNode.
     * @param renderer renderer value to set for this CompositeNode.
     * @param nodeList nested Node List to set for this CompositeNode.
     * */
    public CompositeNode(String code, String renderer, List<INode> nodeList) {
        super(code, renderer);
        this.nodeList = nodeList;
    }

    @Override
    public List<INode> getNodes() {
        return nodeList;
    }
}
