import java.util.ArrayList;

public class Node {
    private static int counter = 0;
    private int id;
    private ArrayList<ArrayList<Integer>> matrix;
    private int cost;
    private ArrayList<String> directions;
    private int depth;

    public Node() {
        this.setId(++counter);
        this.matrix = new ArrayList<ArrayList<Integer>>();
        this.cost = 0;
        this.directions = new ArrayList<String>();
        this.depth = 0;
    }

    public Node(ArrayList<ArrayList<Integer>> matrix, int cost, ArrayList<String> directions) {
        this.setId(++counter);
        this.matrix = matrix;
        this.cost = cost;
        this.directions = directions;
        this.depth = this.directions.size();
    }

    public int getId() {
        return this.id;
    }

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

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDirections(ArrayList<String> directions) { this.directions = directions; }

    public void setDepth(int depth) { this.depth = depth; }

    public void addDirections(String direction) {
        this.directions.add(direction);
    }

    public void displayMatrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

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
