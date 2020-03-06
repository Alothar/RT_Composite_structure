package implementations;

import interfaces.IMyStructure;
import interfaces.INode;

import java.util.List;

/**
 * MyStructure interface implementation.
 * */
public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    /**
     * All-args constructor.
     *
     * @param nodes nested Node List to set for this Structure.
     * */
    public MyStructure(List<INode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public INode findByCode(String code) {
        if(code == null)
            return nodes.stream().flatMap(INode::toStream)
                    .filter(n -> n.getCode() == null)
                    .findFirst().orElse(null);
        return nodes.stream().flatMap(INode::toStream)
                .filter(n -> code.equals(n.getCode()))
                .findFirst().orElse(null);
    }

    @Override
    public INode findByRenderer(String renderer) {
        if(renderer == null)
            return nodes.stream().flatMap(INode::toStream)
                    .filter(n -> n.getRenderer() == null)
                    .findFirst().orElse(null);
        return nodes.stream().flatMap(INode::toStream)
                .filter(n -> renderer.equals(n.getRenderer()))
                .findFirst().orElse(null);
    }

    @Override
    public int count() {
        if(nodes == null)
            return 0;
        return (int)nodes.stream().flatMap(INode::toStream).count();
    }

}
