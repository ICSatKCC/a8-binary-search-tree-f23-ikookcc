/**
 * Ia Node class.
 * @author Adam Bell and Koo In Mo
 * @since 11/26/2023
 */

public class IaNode {
    /** I_a fish field within IaNode. */
   private I_a fish;
   /** Int fishCount to count number of fish added to the node. */
   private int fishCount;
   /** IaNode left child. */
   private IaNode lChild;
   /** IaNode right child.*/
   private IaNode rChild;

/**
 * IaNode constructor.
 * @param fish The I_a object to be added to the node.
 * @param fishCount The number of times that I_a object has been added to the node.
 * @param lChild The left child of the node.
 * @param rChild The right child of the node.
 */
   public IaNode(I_a fish, int fishCount, IaNode lChild, IaNode rChild) {
      this.fish = fish;
      this.fishCount = fishCount;
      this.lChild = lChild;
      this.rChild = rChild;
   }

/**
 * @return I_a object within node.
 */
   public I_a getI_a() {
      return fish;
   }

   /**
 * @return Fish's name.
 */
   public String getKey() {
      return this.fish.name;
   }

   /**
 * @return Number of fish within node.
 */
   public int getCount() {
      return this.fishCount;
   }
   
   /**
 * @param count The updated fish count.
 */
   public void setCount(int count) {
      this.fishCount = count;
   }

   /**
 * @return Current node's left child.
 */
   public IaNode getLChild() {
      return this.lChild;
   }

   /**
 * @return Current node's right child.
 */
   public IaNode getRChild() {
      return this.rChild;
   }

   /**
 * Increments current node's fish count.
 */
   public void increaseCount() {
      this.fishCount++;
   }

   /**
 * Decrements current node's fish count.
 */
   public void decreaseCount() {
      this.fishCount--;
      if (fishCount < 1) {
         throw new IaNodeException("Fish count must be 1 or greater.");
      }
   }

   /**
 * @param newLChild The updated left child of the current node.
 */
   public void setLChild(IaNode newLChild) {
      this.lChild = newLChild;
   }

   /**
 * @param newRChild The updated right child of the current node.
 */
   public void setRChild(IaNode newRChild) {
      this.rChild = newRChild;
   }

   /**
 * @param newFish The new I_a object to be stored within node.
 */
   public void setI_a(I_a newFish) {
      this.fish = newFish;
   }
}