import java.util.ArrayList;

public class Node {
    private static int counter = 0;
    private int id;
    private ArrayList<ArrayList<Integer>> matrix;
    private int cost;

    public Node() {
        this.setId(++counter);
        this.matrix = new ArrayList<ArrayList<Integer>>();
        this.cost = 0;
    }

    public Node(ArrayList<ArrayList<Integer>> matrix, int cost) {
        this.setId(++counter);
        this.matrix = matrix;
        this.cost = cost;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void displayMatrix() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(this.matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
