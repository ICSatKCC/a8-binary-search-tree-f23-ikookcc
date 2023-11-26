import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
* Junit test for IaNode Objects
* @author Lisa Miller from student work
* @since 4/13/22
*/

public class IaNodeTest {
   
   /** I_a constants. */
   static final I_a PUA_AMA = new Pua_ama();
      /** I_a constants. */
   static final I_a KAHAHA = new Kahaha();
   /** I_a constants. */
   static final I_a AMA_AMA = new Ama_ama();

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }



   
   
   /** Tests getting the Ia stored in the node. */
   @Test public void getI_aTest() {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      
      Assert.assertEquals("getI_A should return the stored fish but did not.", PUA_AMA, root.getI_a());
   }
   
   /** Tests getting the stored fish's number. */
   @Test public void getKeyTest() {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      String rightName = "Pua'ama";
      
      Assert.assertTrue("getKey should return the stored fish's Hawaiian name but did not.",
           rightName.equals(root.getKey()));
   }
   
   /** Tests getting the node's catch count. */
   @Test public void getCountTest() {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      
      Assert.assertTrue("The root node's count should be 1 but getNode returned something else.", 1 == root.getCount());
   }
   
   /** Tests getting left child node. */
   @Test public void getLeftChildTest() {
      IaNode leftChild = new IaNode(KAHAHA, 1, null, null);
      IaNode rightChild = new IaNode(AMA_AMA, 1, null, null);
      IaNode root = new IaNode(PUA_AMA, 1, leftChild, rightChild);
      
      Assert.assertTrue("root.getLChild.getI_a() return is incorrect", 
            leftChild.getI_a().equals(root.getLChild().getI_a()));
      Assert.assertTrue("root.getLChild().getLChild() should be null but isn't", 
            leftChild.getLChild() == null && root.getLChild().getLChild() == null);
      Assert.assertTrue("root.getLChild().getRChild() should be null but isn't", 
            leftChild.getRChild() == null && root.getLChild().getRChild() == null);
   }
   
   /** Tests getting right child node. */
   @Test public void getRightChildTest() {
      IaNode leftChild = new IaNode(KAHAHA, 1, null, null);
      IaNode rightChild = new IaNode(AMA_AMA, 1, null, null);
      IaNode root = new IaNode(PUA_AMA, 1, leftChild, rightChild);
      
      Assert.assertTrue("root.getRChild().getI_a() return is incorrect", 
            rightChild.getI_a().equals(root.getRChild().getI_a()));
      Assert.assertTrue("root.getRChild().getLChild() should be null but isn't", 
            rightChild.getLChild() == null && root.getRChild().getLChild() == null);
      Assert.assertTrue("root.getRChild().getRChild() should be null but isn't", 
            rightChild.getRChild() == null && root.getRChild().getRChild() == null);
   }
   
   /** Tests setting the node's catch count. */
   @Test public void setCountTest() {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      root.setCount(5);
      
      Assert.assertTrue("The node's count should be set to 5 but wasn't.", 5 == root.getCount());
   }
   
   /** Tests incrementing the node's catch count. */
   @Test public void increaseCountTest() {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      root.increaseCount();
      
      Assert.assertTrue("The node's count should be increased to 2 but wasn't.", 2 == root.getCount());
   }
   
   /** Tests decrementing the node's catch count. */
   @Test public void decreaseCountTest() {
      IaNode root = new IaNode(PUA_AMA, 5, null, null);
      root.decreaseCount();
      
      Assert.assertTrue("The node's count should be decreased from 5 to 4 but wasn't.", 4 == root.getCount());
   }
   
  /**
  * Test IaNodeException throwing if count goes negative
  */
  
  @Test(expected=IaNodeException.class)
  public void testExceptionForNegativeCount() throws IaNodeException {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      root.decreaseCount();
  }

   
   /** Tests setting left child node. */
   @Test public void setLeftChildTest() {
      IaNode leftChild = new IaNode(KAHAHA, 1, null, null);
      IaNode newLeftChild = new IaNode(AMA_AMA, 1, null, null);
      IaNode root = new IaNode(PUA_AMA, 1, leftChild, null);
      
      root.setLChild(newLeftChild);
      
      Assert.assertTrue("setLChild error, new left child's and root's left child's stored fish not equal", 
            newLeftChild.getI_a().equals(root.getLChild().getI_a()));
      Assert.assertTrue("setLChild error: new left child's left child is not correct.", 
            newLeftChild.getLChild() == null && root.getLChild().getLChild() == null);
      Assert.assertTrue("setLChild error: new left child's right child is not correct.", 
            newLeftChild.getRChild() == null && root.getLChild().getRChild() == null);
   }
   
   /** Tests setting right child node. */
   @Test public void setRightChildTest() {
      IaNode rightChild = new IaNode(KAHAHA, 1, null, null);
      IaNode newRightChild = new IaNode(AMA_AMA, 1, null, null);
      IaNode root = new IaNode(PUA_AMA, 1, null, rightChild);
      
      root.setRChild(newRightChild);
      
      Assert.assertTrue("setRChild error: new right child's and root's right child's stored fish are not equal", 
            newRightChild.getI_a().equals(root.getRChild().getI_a()));
      Assert.assertTrue("setRChild error: New right child's left child is not correct.", 
            newRightChild.getLChild() == null && root.getRChild().getLChild() == null);
      Assert.assertTrue("setRChild error: New right child's right child is not correct.", 
            newRightChild.getRChild() == null && root.getRChild().getRChild() == null);
   }
   
   /** Tests setting node I_a. */
   @Test public void setI_aTest() {
      IaNode root = new IaNode(PUA_AMA, 1, null, null);
      
      root.setI_a(AMA_AMA);
      
      Assert.assertTrue("setI_a() error: Ama_ama is not being set as the new I_a", 
            AMA_AMA.equals(root.getI_a()));
   }
}
