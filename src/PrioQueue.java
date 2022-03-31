import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    public void push(Node elmt) {
        // Add the element to the back of the array
        this.prioQueue.add(elmt);

        // Sort the priority queue
        Collections.sort(this.prioQueue, Comparator.comparingInt(Node::getCost));
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

    public void displayQueue() {
        System.out.print("[");
        for (int i = 0; i < this.prioQueue.size(); i++) {
            System.out.print("(");
            System.out.print(this.prioQueue.get(i).getId() + "," + this.prioQueue.get(i).getCost());
            System.out.print(")");
        }
        System.out.println("]");
    }
}
