import java.util.ArrayList;

public class Node {
    private static int counter = 0;
    private int id;
    private ArrayList<ArrayList<Integer>> matrix;
    private int cost;
    private ArrayList<String> directions;
    private int depth;

    // Default constructor
    public Node() {
        this.setId(++counter);
        this.matrix = new ArrayList<ArrayList<Integer>>();
        this.cost = 0;
        this.directions = new ArrayList<String>();
        this.depth = 0;
    }

    // User defined constructor
    public Node(ArrayList<ArrayList<Integer>> matrix, int cost, ArrayList<String> directions) {
        this.setId(++counter);
        this.matrix = matrix;
        this.cost = cost;
        this.directions = directions;
        this.depth = this.directions.size();
    }

    // Getter and setter
    public ArrayList<ArrayList<Integer>> getMatrix() {
        return this.matrix;
    }

    public int getCost() {
        return this.cost;
    }

    public ArrayList<String> getDirections() { return this.directions; }

    public int getDepth() { return this.depth; }

    public void setId(int id) {
        this.id = id;
    }

    // Function to display the matrix within a node
    public void displayMatrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    // Function to display in-depth information about a node
    public void displayIndividualNodes() {
        System.out.println("Id: " + this.id);
        System.out.println("Matrix: ");
        this.displayMatrix();
        System.out.println("Cost: " + this.cost);
        System.out.println("Directions taken: " + this.directions.toString());
        System.out.println("Depth: " + this.depth);
        System.out.println();
    }
}
