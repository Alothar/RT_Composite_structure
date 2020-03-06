package interfaces;

/**
 * Structure interface, represents multi level nested
 * data structure.
 * */
public interface IMyStructure {
    /**
     * Method returns Node
     * of given code.
     *
     * @param code code of the sought Node.
     *
     * @return Node of given code or null if no Node found.
     * */
    INode findByCode(String code);
    /**
     * Method returns Node
     * of given renderer.
     *
     * @param renderer code of the sought Node.
     *
     * @return Node of given renderer or null if no Node found.
     * */
    INode findByRenderer(String renderer);
    /**
     * Method returns Nodes count.
     *
     * @return int Nodes count.
     * */
    int count();
}
