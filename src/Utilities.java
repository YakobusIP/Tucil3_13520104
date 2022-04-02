import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Utilities {
    public static int sumArray(ArrayList<Integer> array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        return sum;
    }

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

    public static void displayNodes(ArrayList<Node> listOfNodes) {
        for (int i = 0; i < listOfNodes.size(); i++) {
            listOfNodes.get(i).displayIndividualNodes();
        }
    }

    public static ArrayList<String> copyList(ArrayList<String> originalList) {
        ArrayList<String> resultList = new ArrayList<String>();
        for (int i = 0; i < originalList.size(); i++) {
            resultList.add(originalList.get(i));
        }
        return resultList;
    }

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

    public static ArrayList<Integer> convertMatrixToList(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                list.add(matrix.get(i).get(j));
            }
        }
        return list;
    }

    public static boolean checkNodeRepeatance(ArrayList<Node> nodeList, Node elmt) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).getMatrix().equals(elmt.getMatrix())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkElementRepeatance(ArrayList<ArrayList<Integer>> matrix) {
        HashSet<Integer> setChecker = new HashSet<Integer>(convertMatrixToList(matrix));
        return (setChecker.size() == matrix.size());
    }

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
