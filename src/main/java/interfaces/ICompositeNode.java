package interfaces;

import java.util.List;
import java.util.stream.Stream;

/**
 * CompositeNode interface.
 * Extends Node interface
 * by implementing composite
 * Nodes structure. (List of Nodes
 * as it's variable)
 * */
public interface ICompositeNode extends INode {
    /**
     * Method returns List
     * of Nodes that object holds.
     *
     * @return List of nested Nodes.
     * */
    List<INode> getNodes();
    /**
     * Overridden default Node method.
     * Method returns stream of this object
     * by concatenating stream of this object
     * and all Nodes that object holds.
     * (Recursion involved)
     * */
    @Override
    default Stream<INode> toStream() {
        return Stream.concat(INode.super.toStream(),
                this.getNodes().stream().flatMap(INode::toStream));
    }
}
