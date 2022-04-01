import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {
    // Function to find X in KURANG(i) + X
    public static int findX(int i, int j) {
        int x;
        if (i % 2 == 0) {
            if (j % 2 != 0) {
                x = 1;
            } else {
                x = 0;
            }
        } else {
            if (j % 2 == 0) {
                x = 1;
            } else {
                x = 0;
            }
        }
        return x;
    }

    // Get the goal matrix
    public static ArrayList<ArrayList<Integer>> getGoalMatrix() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        int element = 1;
        for(int i = 0; i < 4; i++) {
            ArrayList<Integer> matrixRow = new ArrayList<Integer>();
            for(int j = 0; j < 4; j++) {
                if (i == 3 && j == 3) {
                    matrixRow.add(0);
                } else {
                    matrixRow.add(element);
                    element++;
                }
            }
            matrix.add(matrixRow);
        }
        return matrix;
    }

    // Function to count the amount of difference between matrices
    public static int getDifference(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> goal = getGoalMatrix();
        int difference = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!matrix.get(i).get(j).equals(goal.get(i).get(j))) {
                    difference++;
                }
            }
        }

        if (difference > 0) {
            return difference - 1;
        } else {
            return 0;
        }
    }

    // Check if goal is reachable
    public static List<Object> isGoalReachable(ArrayList<ArrayList<Integer>> matrix) {
        int addition, counter, result;
        boolean goal;
        ArrayList<Integer> incorrectPos = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) {
            incorrectPos.add(0);
        }

        addition = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int testElmt = matrix.get(i).get(j);
                if (testElmt != 0) {
                    counter = 0;
                    for (int x = 0; x < 4; x++) {
                        for (int y = 0; y < 4; y++) {
                            if (matrix.get(x).get(y) < testElmt && matrix.get(x).get(y) != 0) {
                                if (x > i) {
                                    counter++;
                                } else if (x == i && y > j) {
                                    counter++;
                                }
                            }
                        }
                    }
                    incorrectPos.add(testElmt - 1, counter);
                } else {
                    counter = 0;
                    addition = findX(i, j);
                    for (int x = 0; x < 4; x++) {
                        for (int y = 0; y < 4; y++) {
                            if (x > i) {
                                counter++;
                            } else if (x == i && y > j) {
                                counter++;
                            }
                        }
                    }
                    incorrectPos.add(15, counter);
                }
            }
        }

        result = Utilities.sumArray(incorrectPos) + addition;
        if (result % 2 == 0) {
            goal = true;
        } else {
            goal = false;
        }
        return Arrays.asList(goal, result);
    }

    public static ArrayList<String> checkDirectionPossibilities(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<String> possibilities = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (matrix.get(i).get(j).equals(0)) {
                    if (i - 1 >= 0) {
                        possibilities.add("UP");
                    }
                    if (i + 1 <= 3) {
                        possibilities.add("DOWN");
                    }
                    if (j - 1 >= 0) {
                        possibilities.add("LEFT");
                    }
                    if (j + 1 <= 3) {
                        possibilities.add("RIGHT");
                    }
                }
            }
        }
        return possibilities;
    }

    public static ArrayList<ArrayList<Integer>> createNewChild(ArrayList<ArrayList<Integer>> root, String direction) {
        ArrayList<ArrayList<Integer>> newChild = Utilities.copyMatrix(root);
        boolean newMatrixCreated = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (root.get(i).get(j).equals(0) && !newMatrixCreated) {
                    if (direction.equals("UP")) {
                        newChild.get(i).set(j, root.get(i - 1).get(j));
                        newChild.get(i - 1).set(j, 0);
                        newMatrixCreated = true;
                    } else if (direction.equals("DOWN")) {
                        newChild.get(i).set(j, root.get(i + 1).get(j));
                        newChild.get(i + 1).set(j, 0);
                        newMatrixCreated = true;
                    } else if (direction.equals("LEFT")) {
                        newChild.get(i).set(j, root.get(i).get(j - 1));
                        newChild.get(i).set(j - 1, 0);
                        newMatrixCreated = true;
                    } else if (direction.equals("RIGHT")) {
                        newChild.get(i).set(j, root.get(i).get(j + 1));
                        newChild.get(i).set(j + 1, 0);
                        newMatrixCreated = true;
                    }
                }
            }
        }
        return newChild;
    }

    public static ArrayList<Node> branchAndBoundAlgorithm(Node root) {
        List<Object> reachableResult = isGoalReachable(root.getMatrix());
        boolean goal = (boolean)reachableResult.get(0);
        int result = (int)reachableResult.get(1);
        ArrayList<Node> goalStates = new ArrayList<Node>();
        ArrayList<Node> allStates = new ArrayList<Node>();
        if (goal) {
            System.out.println("Function KURANG(i) + X result is " + result + " which is even");
            PrioQueue liveNodes = new PrioQueue();
            Node e_node;
            boolean finish = false;
            int counter = 0;
            while (!finish) {
                if (liveNodes.getPrioQueue().isEmpty()) {
                    e_node = root;
                    goalStates.add(e_node);
                    if (!Utilities.checkRepeatance(allStates, e_node)) {
                        allStates.add(e_node);
                    }
                } else {
                    e_node = liveNodes.peek();
                    goalStates.add(e_node);
                    liveNodes.pop();
                    if (!Utilities.checkRepeatance(allStates, e_node)) {
                        allStates.add(e_node);
                    }
                }
                System.out.println("Current e-node: ");
                e_node.displayIndividualNodes();

                // If the current e_node is the goal state
                if (getDifference(e_node.getMatrix()) == 0) {
                    System.out.println("Found solution!");
                    // Add the node to the goal state list
                    goalStates.add(e_node);
                    // Remove nodes with higher cost (lower priority) than the e_node
                    //liveNodes.removeLowerPriority(e_node);

                    liveNodes.removeLowerPriority(e_node);

                    // If no more live nodes exists, break the loop
                    if (liveNodes.getPrioQueue().isEmpty()) {
                        finish = true;
                    }
                } else {
                    ArrayList<String> availableDirection = checkDirectionPossibilities(e_node.getMatrix());
                    ArrayList<String> directionList = e_node.getDirections();
                    for (String direction : availableDirection) {
                        // If e_node directionList is empty, add all directions
                        if (directionList.isEmpty()) {
                            // Create new child matrix based on a direction
                            ArrayList<ArrayList<Integer>> newChildMatrix = createNewChild(e_node.getMatrix(), direction);

                            // Create new direction list for new child
                            ArrayList<String> childDirectionList = Utilities.copyList(directionList);

                            // Calculate differences and cost
                            int difference = getDifference(newChildMatrix);
                            int cost = difference + e_node.getDepth() + 1;

                            // Add direction to the directionList
                            childDirectionList.add(direction);
                            Node newChild = new Node(newChildMatrix, cost, childDirectionList);

                            // Add newChild to liveNodes
                            liveNodes.push(allStates, newChild);
                            allStates.add(newChild);
                        } else {
                            // Skipping the creation of recurring matrices (e.g. after moving "DOWN", skip adding moving "UP")
                            if (!direction.equals(Utilities.getReverseDirection(directionList.get(e_node.getDepth() - 1)))) {
                                // Create new child matrix based on a direction
                                ArrayList<ArrayList<Integer>> newChildMatrix = createNewChild(e_node.getMatrix(), direction);

                                // Create new direction list for new child
                                ArrayList<String> childDirectionList = Utilities.copyList(directionList);

                                // Calculate differences and cost
                                int difference = getDifference(newChildMatrix);
                                int cost = difference + e_node.getDepth() + 1;

                                // Add direction to the directionList
                                childDirectionList.add(direction);
                                Node newChild = new Node(newChildMatrix, cost, childDirectionList);

                                // Add newChild to liveNodes
                                liveNodes.push(allStates, newChild);
                                allStates.add(newChild);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Goal is not reachable!");
            System.out.println("Function KURANG(i) + X result is " + result + " which is odd");
        }
        return goalStates;
    }
}
