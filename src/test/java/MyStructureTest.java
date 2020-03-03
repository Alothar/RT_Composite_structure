import implementations.MyStructure;
import interfaces.ICompositeNode;
import interfaces.INode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Arrays;

import static org.mockito.Mockito.when;

public class MyStructureTest {

    @Mock   private MyStructure mockedStructure;
    @Mock   private INode mockedNode;
    @Mock   private INode mockedNode2;
    @Mock   private ICompositeNode mockedCompositeNode;

    @Test
    void countTest_NoNodesPresent_mustReturnZero(){
        mockedStructure = new MyStructure();
        Assertions.assertEquals(0, mockedStructure.count());
    }

    @Test
    void countTest_OnlySimpleNodesPresent_mustReturnSimpleNodesCount(){
        when(mockedNode.getNode()).thenReturn("Node1");
        when(mockedNode.getRenderer()).thenReturn("Renderer1");
        when(mockedNode2.getNode()).thenReturn("Node2");
        when(mockedNode2.getRenderer()).thenReturn("Renderer2");
        Whitebox.setInternalState(mockedStructure, "nodes", Arrays.asList(mockedNode, mockedNode2));

        Assertions.assertEquals(2, mockedStructure.count());
    }

    @Test
    void countTest_ComplexPresent_mustReturnAllInnerNodesCount(){
        when(mockedNode.getNode()).thenReturn("Node1");
        when(mockedNode.getRenderer()).thenReturn("Renderer1");
        when(mockedNode2.getNode()).thenReturn("Node2");
        when(mockedNode2.getRenderer()).thenReturn("Renderer2");
        when(mockedCompositeNode.getNode()).thenReturn("CompositeNode");
        when(mockedCompositeNode.getRenderer()).thenReturn("CompositeRenderer");
        when(mockedCompositeNode.getNodes()).thenReturn(Arrays.asList(mockedNode, mockedNode2));
        Whitebox.setInternalState(mockedStructure, "nodes", Arrays.asList(mockedNode, mockedNode2, mockedCompositeNode));

        Assertions.assertEquals(5, mockedStructure.count());
    }
}
