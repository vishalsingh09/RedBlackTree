import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

  @Test
  void test1() {
    RedBlackTree tree1 = new RedBlackTree();
    tree1.insert(7);
    tree1.insert(14);
    tree1.insert(18);
    
    assertEquals(tree1.findNodeWithData(7).blackHeight, 0);
    assertEquals(tree1.findNodeWithData(14).blackHeight, 1);
    assertEquals(tree1.findNodeWithData(18).blackHeight, 0);
  }
  
  @Test
  /**
   * Tests insertion with a red uncle
   */
  void test2() {
    //tests red node on the same side of parent with a red uncle [LEFT]
    {
      RedBlackTree tree1 = new RedBlackTree();
      
      tree1.insert(7);
      tree1.insert(14);
      tree1.insert(18);
      tree1.insert(3);
      
      assertEquals(tree1.findNodeWithData(7).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(14).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(18).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(3).blackHeight, 0);
   
    }
    //tests red node on the different side of parent with a red uncle [LEFT]
    {
      RedBlackTree tree1 = new RedBlackTree();
      
      tree1.insert(7);
      tree1.insert(14);
      tree1.insert(18);
      tree1.insert(10);
      
      assertEquals(tree1.findNodeWithData(7).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(14).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(18).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(10).blackHeight, 0);
    }
    //tests red node on the same side of parent with a red uncle [RIGHT]
    {
      RedBlackTree tree1 = new RedBlackTree();
      
      tree1.insert(7);
      tree1.insert(14);
      tree1.insert(18);
      tree1.insert(20);
      
      assertEquals(tree1.findNodeWithData(7).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(14).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(18).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(20).blackHeight, 0);
   
    }
    //tests red node on the different side of parent with a red uncle [RIGHT]
    {
      RedBlackTree tree1 = new RedBlackTree();
      
      tree1.insert(7);
      tree1.insert(14);
      tree1.insert(18);
      tree1.insert(15);
      
      assertEquals(tree1.findNodeWithData(7).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(14).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(18).blackHeight, 1);
      assertEquals(tree1.findNodeWithData(15).blackHeight, 0);
    }
  }
  
  @Test
  /**
   * Tests an insertion with a black uncle
   */
  void test3() {
    RedBlackTree tree1 = new RedBlackTree();
    tree1.insert(45);
    tree1.insert(26);
    tree1.insert(72);
    
    //System.out.println(tree1.toLevelOrderString());
    tree1.findNodeWithData(45).blackHeight = 1;
    tree1.findNodeWithData(26).blackHeight = 0;
    tree1.findNodeWithData(72).blackHeight = 1;
    
    tree1.insert(18);
    //System.out.println(tree1.toLevelOrderString());
    assertEquals(tree1.findNodeWithData(45).blackHeight, 0);
    assertEquals(tree1.findNodeWithData(26).blackHeight, 1);
    assertEquals(tree1.findNodeWithData(72).blackHeight, 1);
    assertEquals(tree1.findNodeWithData(18).blackHeight, 0);
  }
  
}
