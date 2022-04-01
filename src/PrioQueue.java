import java.util.ArrayList;

public class PrioQueue {
    private ArrayList<Node> prioQueue;

    public PrioQueue() {
        this.prioQueue = new ArrayList<Node>();
    }

    public PrioQueue(ArrayList<Node> prioQueue) {
        this.prioQueue = prioQueue;
    }

    public PrioQueue(PrioQueue prioQueue) {
        this.prioQueue = prioQueue.prioQueue;
    }

    public ArrayList<Node> getPrioQueue() {
        return this.prioQueue;
    }

    public int getNodeId(int i) {
        return this.prioQueue.get(i).getId();
    }

    public ArrayList<ArrayList<Integer>> getNodeMatrix(int i) {
        return this.prioQueue.get(i).getMatrix();
    }

    public int getNodeCost(int i) {
        return this.prioQueue.get(i).getCost();
    }

    // Push elements to the priority queue based on its cost
    // The lower the cost, the earlier its placement
    public void push(ArrayList<Node> nodeList, Node elmt) {
        // If the element already exists in the node list, don't add it
        if (!Utilities.checkRepeatance(nodeList, elmt)) {
            // If priority queue is still empty, just add the element
            if (this.prioQueue.isEmpty()) {
                this.prioQueue.add(elmt);
            } else {
                int index = -999;
                boolean foundIndex = false;
                // If priority queue has an element, find the correct position for it
                for (int i = 0; i < this.prioQueue.size() && !foundIndex; i++) {
                    // If found an item with higher cost than element cost,
                    // move the element in front of the item
                    if (elmt.getCost() < this.prioQueue.get(i).getCost()) {
                        index = i;
                        foundIndex = true;
                    }
                }
                if (index != -999) {
                    this.prioQueue.add(index, elmt);
                } else {
                    this.prioQueue.add(elmt);
                }
            }
        }
    }

    // Pop the front element of the queue
    public void pop() {
        this.prioQueue.remove(0);
    }

    public Node peek() {
        return this.prioQueue.get(0);
    }

    public int length() {
        return this.prioQueue.size();
    }

    public void removeLowerPriority(Node e_node) {
        for (int i = this.length() - 1; i >= 0; i--) {
            if (this.prioQueue.get(i).getCost() > e_node.getCost()) {
                this.pop();
            }
        }
    }

    public void clearPrioQueue() {
        this.prioQueue.clear();
    }

    public void displayQueue() {
        for (int i = 0; i < this.prioQueue.size(); i++) {
            this.prioQueue.get(i).displayIndividualNodes();
        }
    }
}
