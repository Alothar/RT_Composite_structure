import implementations.CompositeNode;
import implementations.MyStructure;
import implementations.Node;
import interfaces.ICompositeNode;
import interfaces.INode;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;


public class MyStructureTest {

    public INode node = new Node("Node", "Renderer");
    public INode node1 = new Node("Node1", "Renderer1");
    public INode node_nulls = new Node(null, null);
    public ICompositeNode compositeNode = new CompositeNode("CompositeNode", "CompositeRenderer", Arrays.asList(node, node1));
    public ICompositeNode compositeNode1 = new CompositeNode("CompositeNode1", "CompositeRenderer1", Arrays.asList(node, node1, compositeNode));
    public MyStructure structure = new MyStructure(null);

    @Test
    public void countTest_NoNodesPresent_mustReturnZero(){
        Assertions.assertEquals(0, structure.count());

        structure = new MyStructure(new ArrayList<>());

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

    @Test
    public void findByCodeTest_NoNodesPresent_mustReturnNull(){
        structure = new MyStructure(new ArrayList<>());

        Assertions.assertNull(structure.findByCode(null));
    }

    @Test
    public void findByCodeTest_OnlySimpleNodesPresent_mustReturnSimpleNodes(){
        structure = new MyStructure(Arrays.asList(node, node1, node_nulls));

        Assertions.assertEquals(node_nulls, structure.findByCode(null));
        Assertions.assertEquals(node, structure.findByCode("Node"));
        Assertions.assertEquals(node1, structure.findByCode("Node1"));
    }

    @Test
    public void findByCodeTest_ComplexPresent_mustReturnSimpleNodes(){
        structure = new MyStructure(Arrays.asList(compositeNode, node, node1, node_nulls));

        Assertions.assertEquals(node_nulls, structure.findByCode(null));
        Assertions.assertEquals(node, structure.findByCode("Node"));
        Assertions.assertEquals(node1, structure.findByCode("Node1"));
    }

    @Test
    public void findByCodeTest_ComplexPresent_mustReturnComplexNodes(){
        structure = new MyStructure(Arrays.asList(compositeNode, compositeNode1, node, node1, node_nulls));

        Assertions.assertEquals(compositeNode, structure.findByCode("CompositeNode"));
        Assertions.assertEquals(compositeNode1, structure.findByCode("CompositeNode1"));
    }

    @Test
    public void findByRendererTest_NoNodesPresent_mustReturnNull(){
        structure = new MyStructure(new ArrayList<>());

        Assertions.assertNull(structure.findByCode(null));
    }

    @Test
    public void findByRendererTest_OnlySimpleNodesPresent_mustReturnSimpleNodes(){
        structure = new MyStructure(Arrays.asList(node, node1, node_nulls));

        Assertions.assertEquals(node_nulls, structure.findByCode(null));
        Assertions.assertEquals(node, structure.findByCode("Renderer"));
        Assertions.assertEquals(node1, structure.findByCode("Renderer1"));
    }

    @Test
    public void findByRendererTest_ComplexPresent_mustReturnSimpleNodes(){
        structure = new MyStructure(Arrays.asList(compositeNode, node, node1, node_nulls));

        Assertions.assertEquals(node_nulls, structure.findByCode(null));
        Assertions.assertEquals(node, structure.findByCode("Renderer"));
        Assertions.assertEquals(node1, structure.findByCode("Renderer1"));
    }

    @Test
    public void findByRendererTest_ComplexPresent_mustReturnComplexNodes(){
        structure = new MyStructure(Arrays.asList(compositeNode, compositeNode1, node, node1, node_nulls));

        Assertions.assertEquals(compositeNode, structure.findByCode("CompositeRenderer"));
        Assertions.assertEquals(compositeNode1, structure.findByCode("CompositeRenderer1"));
    }
}
