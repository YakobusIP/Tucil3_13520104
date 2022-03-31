import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Input {
    public static ArrayList<ArrayList<Integer>> createRandomMatrix() {
        ArrayList<Integer> randomNumber = new ArrayList<Integer>();
        for (int i = 0; i < 16; i++) {
            randomNumber.add(i);
        }

        Collections.shuffle(randomNumber);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        int index = 0;
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> matrixRow = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                matrixRow.add(randomNumber.get(index));
                index++;
            }
            matrix.add(matrixRow);
        }

        return matrix;
    }

    public static ArrayList<ArrayList<Integer>> readFromFile(String path) throws FileNotFoundException {
        Scanner input = new Scanner(new File(path));
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < 4; i++) {
            ArrayList<Integer> matrixRow = new ArrayList<Integer>();
            for (int j = 0; j < 4; j++) {
                if (input.hasNextInt()) {
                    matrixRow.add(input.nextInt());
                }
            }
            matrix.add(matrixRow);
        }
        return matrix;
    }
}
