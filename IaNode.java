/**
* Ia Node class.
* @author Adam Bell and Koo In Mo
* @since 11/26/2023
*/

public class IaNode {
    private I_a fish;
    private int fishCount;
    private IaNode lChild;
    private IaNode rChild;

    public IaNode(I_a fish, int fishCount, IaNode lChild, IaNode rChild) {
        this.fish = fish;
        this.fishCount = fishCount;
    }

    public I_a getIa() {
        return fish;
    }

    public String getKey() {
        return this.fish.name;
    }

    public int getCount() {
        return this.fishCount;
    }

    public IaNode getLChild() {
        return this.lChild;
    }

    public IaNode getRChild() {
        return this.rChild;
    }

    public void increaseCount() {
        this.fishCount++;
    }

    public void decreaseCount() {
        this.fishCount--;
    }

    public void setLChild(IaNode newLChild) {
        this.lChild = newLChild;
    }

    public void setRChild(IaNode newRChild) {
        this.rChild = newRChild;
    }

    public void setFish(I_a newFish) {
        this.fish = newFish;
    }
}