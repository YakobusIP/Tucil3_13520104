import java.util.ArrayList;

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

    public static boolean checkRepeatance(ArrayList<Node> nodeList, Node elmt) {
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).getMatrix().equals(elmt.getMatrix())) {
                return true;
            }
        }
        return false;
    }

    public static String displayGoalStates(ArrayList<Node> goalState) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < goalState.size() - 1; i++) {
            if (i == goalState.size() - 2) {
                output.append("Final State: \n");
                output.append(goalState.get(i).displayNodesMatrixInString());
            } else {
                output.append("Matrix: \n");
                output.append(goalState.get(i).displayNodesMatrixInString());
            }

        }
        return output.toString();
    }
}
