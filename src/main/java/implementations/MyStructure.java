package implementations;

import interfaces.IMyStructure;
import interfaces.INode;

import java.util.List;

public class MyStructure implements IMyStructure {

    private List<INode> nodes;

    public INode findByCode(String code) {
        return null;
    }

    public INode findByRenderer(String renderer) {
        return null;
    }

    public int count() {
        return 0;
    }
}
