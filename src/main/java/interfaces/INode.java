package interfaces;

import java.util.stream.Stream;

/**
 * Node interface.
 * Every interface implementation
 * should have code and renderer
 * fields.
* */
public interface INode {
    /**
     * Method returns
     * node-specific
     * code.
     *
     * @return code value.
     * */
    String getCode();
    /**
     * Method returns
     * node-specific
     * renderer.
     *
     * @return renderer value.
     * */
    String getRenderer();
    /**
     * Default method
     * returns stream
     * of this object.
     *
     * @return stream of this object.
     * */
    default Stream<INode> toStream() {
        return Stream.of(this);
    }
}
