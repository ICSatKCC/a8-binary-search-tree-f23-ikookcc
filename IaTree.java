/**
 * IaTree class.
 * @author Adam Bell and Koo In Mo
 * @since 11/27/2023
 * 
 */ 
public class IaTree {

   /**
 * Initializing the root node.
 */
   private IaNode root = null;

   /**
 *  Empty Tree Constructor.
 */
   public IaTree() {
   
   }

   /**
    * Public wrapper method for add.
    * @param fish Is the I_a object to be added to the Tree.
    */
   public void add(I_a fish) {
      root = add(root, fish);
   }

   /**
 * @param node The Root node of the Tree.
 * @param fish The I_a object to be added to the Tree.
 * @return The Node that stores the new I_a object.
 */
   private IaNode add(IaNode node, I_a fish) {
      if (node == null) {
         return new IaNode(fish, 1, null, null);
      }
      if (fish.name.compareTo(node.getKey()) == 0) {
         node.increaseCount();
      }
      else if (fish.name.compareTo(node.getKey()) < 0) {
         node.setLChild(this.add(node.getLChild(), fish));
      }
      else {
         node.setRChild(this.add(node.getRChild(), fish));
      }
      return node;
   }

/**
 * Public wrapper get method.
 * @param fish Is the the fish to be retrieved.
 * @return I_a object.
 */
   public I_a get(I_a fish) {
      return this.get(root, fish);
   }

/**
 * Private get method.
 * @param node Is the root node of the tree.
 * @param fish Is the I_a object to be retrieved.
 * @return I_a object to be found in tree.
 */
   private I_a get(IaNode node, I_a fish) {
   
      if (node == null) {
         throw new IaTreeException("Ia not found in tree.");
      }
      if (node.getKey().equals(fish.getName())) {
         return node.getI_a();
      }
      else if (fish.compareTo(node.getI_a()) < 0) {
         get(node.getLChild(), fish);
      }
      else {
         get(node.getRChild(), fish);
      } 
      return node.getI_a();
   }

/**
 * Public wrapper remove method.
 * @param fish Is the I_a object to be removed.
 */
   public void remove(I_a fish) {
      remove(root, fish);
   }

   /**
 * @param node Is the root node of the Tree.
 * @param fish Is the I_a object to be removed.
 * @return the Node that stores the I_a object to be removed.
 */
   private IaNode remove(IaNode node, I_a fish) {
   
      if (node == null) {
         throw new IaTreeException("Item not found!");
      }
      else if (fish.compareTo(node.getI_a()) < 0) {
         node.setLChild(this.remove(node.getLChild(), node.getI_a()));
         return node;
      }
      else if (fish.compareTo(node.getI_a()) > 0) {
         node.setRChild(this.remove(node.getRChild(), node.getI_a()));
         return node;
      }
      else {
         if (node.getCount() > 1) {
            node.decreaseCount(); 
         } else {
            node = this.remove(node);
         }
         return node;
      }
   }

   /**
 * @param node Is the empty node to be removed from the Tree.
 * @return The node to be removed.
 */
   private IaNode remove(IaNode node) {
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      else {
         IaNode minimumIaNode = findMinimumIaNode(node.getRChild());
         node.setI_a(minimumIaNode.getI_a());
         node.setRChild(remove(node.getRChild(), minimumIaNode.getI_a()));
      }
      return node;
   }

   /**
 * @param node Is the root node to explore the subtree and find the minimum node.
 * @return The minimum IaNode.
 */
   private IaNode findMinimumIaNode(IaNode node) {
      while (node.getLChild() != null) {
         node = node.getLChild();
      }
      return node;
   }

/**
 * Public wrapper method to print the Ia Tree.
 */
   public void printIaTree() {
      print(root);
   }

/**
 * @param node Is the root node of the IaTree to be printed.
 * Prints all nodes in the Tree in in-order traversal.
 */
   private void print(IaNode node) {
      if (node != null) {
         print(node.getLChild());
         System.out.println(node.getKey() + " Count: " + node.getCount());
         print(node.getRChild());
      }
   }
}