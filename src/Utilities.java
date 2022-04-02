import java.util.ArrayList;
import java.util.HashSet;

public class Utilities {
    // Function to add all the elements within an array
    public static int sumArray(ArrayList<Integer> array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

    // Function to find the opposite of a direction (e.g. the opposite of "UP" is "DOWN")
    public static String getReverseDirection(String direction) {
        if (direction.equals("UP")) {
            return "DOWN";
        }
        if (direction.equals("DOWN")) {
            return "UP";
        }
        if (direction.equals("LEFT")) {
            return "RIGHT";
        }
        if (direction.equals("RIGHT")) {
            return "LEFT";
        }
        return "None";
    }

    // Function to copy a matrix to another matrix
    public static ArrayList<ArrayList<Integer>> copyMatrix(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> outputRow = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                outputRow.add(input.get(i).get(j));
            }
            output.add(outputRow);
        }
        return output;
    }

    // Function to copy a list to another list
    public static ArrayList<String> copyList(ArrayList<String> originalList) {
        return new ArrayList<String>(originalList);
    }

    // Function to convert a list to a matrix
    public static ArrayList<ArrayList<Integer>> convertListToMatrix(ArrayList<Integer> list) {
        int counter = 0;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> matrixRow = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                matrixRow.add(list.get(counter));
                counter++;
            }
            matrix.add(matrixRow);
        }

        return matrix;
    }

    // Function to convert a matrix to a list
    public static ArrayList<Integer> convertMatrixToList(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                list.add(matrix.get(i).get(j));
            }
        }
        return list;
    }

    // Function to find a repeating node within an arraylist
    // If there is a repeating nodes, function will return true
    public static boolean checkRepeatingNodes(ArrayList<Node> nodeList, Node elmt) {
        for (Node node : nodeList) {
            if (node.getMatrix().equals(elmt.getMatrix())) {
                return false;
            }
        }
        return true;
    }

    // Function to find a repeating element within a matrix
    // If there is a repeating element, function will return false
    public static boolean checkRepeatingElement(ArrayList<ArrayList<Integer>> matrix) {
        HashSet<Integer> setChecker = new HashSet<Integer>(convertMatrixToList(matrix));
        return (setChecker.size() == matrix.size());
    }

    // Function to format a matrix output
    public static String formatMatrixOutput(ArrayList<ArrayList<Integer>> matrix) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                output.append(matrix.get(i).get(j) + " ");
            }
            output.append("\n");
        }
        output.append("\n");
        return output.toString();
    }

    // Function to display goal states within the GUI
    public static String displayGoalStates(ArrayList<ArrayList<Integer>> root, ArrayList<Node> goalState) {
        ArrayList<ArrayList<Integer>> currentMatrix = copyMatrix(root);
        StringBuilder output = new StringBuilder();
        ArrayList<String> direction = goalState.get(0).getDirections();
        for (int i = 0; i < direction.size(); i++) {
            ArrayList<ArrayList<Integer>> printChild = Algorithm.createNewChild(currentMatrix, direction.get(i));
            if (i == direction.size() - 1) {
                output.append("Goal State: \n");
                output.append("Direction taken: " + direction.get(i) + "\n");
                output.append(formatMatrixOutput(printChild));
            } else {
                output.append("Direction taken: " + direction.get(i) + "\n");
                output.append(formatMatrixOutput(printChild));
            }
            currentMatrix = copyMatrix(printChild);
        }
        output.append("Directions Taken: \n");
        output.append(goalState.get(0).getDirections());
        return output.toString();
    }
}