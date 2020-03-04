import implementations.CompositeNode;
import implementations.MyStructure;
import implementations.Node;
import interfaces.ICompositeNode;
import interfaces.INode;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;


public class MyStructureTest {

    public INode node = new Node("Node", "Renderer");
    public INode node1 = new Node("Node1", "Renderer1");
    public ICompositeNode compositeNode = new CompositeNode("CompositeNode", "CompositeRenderer", Arrays.asList(node, node1));
    public ICompositeNode compositeNode1 = new CompositeNode("CompositeNode1", "CompositeRenderer1", Arrays.asList(node, node1, compositeNode));
    public MyStructure structure = new MyStructure(null);

    @Test
    public void countTest_NoNodesPresent_mustReturnZero(){
        Assertions.assertEquals(0, structure.count());
    }

    @Test
    public void countTest_OnlySimpleNodesPresent_mustReturnSimpleNodesCount(){
        structure = new MyStructure(Arrays.asList(node, node1));

        Assertions.assertEquals(2, structure.count());
    }

    @Test
    public void countTest_ComplexPresent_mustReturnAllInnerNodesCount(){
        structure = new MyStructure(Arrays.asList(node, node1, compositeNode));

        Assertions.assertEquals(5, structure.count());
    }

    @Test
    public void countTest_ComplexInsideOfComplexPresent_mustReturnAllInnerNodesCount(){
        structure = new MyStructure(Arrays.asList(node, node1, compositeNode, compositeNode1));

        Assertions.assertEquals(11, structure.count());
    }
}
