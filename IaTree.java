public class IaTree {

    private IaNode root = null;

    public IaTree() {

    }

    public void add(I_a fish) {
        root = add(root, fish);
    }

    private IaNode add(IaNode node, I_a fish) {
        if (node == null) {
            return new IaNode(fish, 1, null, null);
        }
        else if  (fish.name.compareTo(node.getKey()) == 0) {
            throw new IaTreeException("Duplicate fish.");
        }
        else if (fish.name.compareTo(node.getKey()) < 0) {
            node.setLChild(this.add(node.getLChild(), fish));
            return node;
        }
        else {
             node.setRChild(this.add(node.getRChild(), fish));
            return node;
        }
    }

    public I_a get (I_a searchKey) {
        return this.get(root, searchKey);
    }

    public I_a get(I_a searchKey) {
        return this.get(root, searchKey);
    }

    private I_a get(IaNode node, I_a searchKey) {

        if (node.getKey().equals(searchKey.getName())) {
            return node.getIa();
        }
        else if (searchKey.compareTo(node.getIa()) < 0) {
            get(node.getLChild(), searchKey);
        }
        else if (searchKey.compareTo(node.getIa()) > 0) {
            get(node.getRChild(), searchKey);
        } 
        else {
            throw new IaTreeException("Ia not found in tree.")
        }
    }
    public class IaTreeException extends RuntimeException{

    }
}