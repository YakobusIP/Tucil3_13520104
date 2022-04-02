import java.util.ArrayList;

public class PrioQueue {
    private ArrayList<Node> prioQueue;

    // Default Constructor
    public PrioQueue() {
        this.prioQueue = new ArrayList<Node>();
    }

    // Getter
    public ArrayList<Node> getPrioQueue() {
        return this.prioQueue;
    }

    // Push elements to the priority queue based on its cost
    // The lower the cost, the earlier its placement
    public void push(ArrayList<Node> nodeList, Node elmt) {
        // If the element already exists in the node list, don't add it
        if (Utilities.checkRepeatingNodes(nodeList, elmt)) {
            // If priority queue is still empty, just add the element
            if (this.prioQueue.isEmpty()) {
                this.prioQueue.add(elmt);
            } else {
                int index = -999;
                boolean foundIndex = false;
                // If priority queue has an element, find the correct position for it
                for (int i = 0; i < this.prioQueue.size() && !foundIndex; i++) {
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

    // Peek the front element of the queue without popping it
    public Node peek() {
        return this.prioQueue.get(0);
    }

    // Function to get the priority queue length
    public int length() {
        return this.prioQueue.size();
    }

    // Function to remove elements that have a higher cost than the E-node
    public void removeLowerPriority(Node e_node) {
        for (int i = this.length() - 1; i >= 0; i--) {
            if (this.prioQueue.get(i).getCost() > e_node.getCost()) {
                this.pop();
            }
        }
    }
}
