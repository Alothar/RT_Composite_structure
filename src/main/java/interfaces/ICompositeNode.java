package interfaces;

import java.util.List;
import java.util.stream.Stream;

public interface ICompositeNode extends INode {
    List<INode> getNodes();

    @Override
    default Stream<INode> toStream() {
        return Stream.concat(INode.super.toStream(),
                this.getNodes().stream().flatMap(INode::toStream));
    }
}
