package implementations;

import interfaces.INode;

/**
 * Node interface implementation.
 * */
public class Node implements INode {

    private String code;
    private String renderer;

    /**
     * All-args constructor.
     *
     * @param code code value to set for this Node.
     * @param renderer renderer value to set for this Node.
     * */
    public Node(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }
}
