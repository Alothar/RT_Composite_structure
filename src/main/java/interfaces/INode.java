package interfaces;

import java.util.stream.Stream;

public interface INode {
    String getCode();
    String getRenderer();

    default Stream<INode> toStream() {
        return Stream.of(this);
    }
}
