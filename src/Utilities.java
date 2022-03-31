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
}
