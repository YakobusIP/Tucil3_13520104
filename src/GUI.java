import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    // Creating frame objects
    private JFrame frame;

    // Creating label objects
    private JLabel intro1;
    private JLabel intro2;
    private JLabel intro3;
    private JLabel intro4;
    private JLabel errorLabel;
    private JLabel resetLabel;
    private JLabel timeTaken;

    // Creating button objects
    private JButton button_file_input;
    private JButton button_random_input;
    private JButton button_start;
    private JButton button_reset;

    // Creating text objects
    private JTextField matrixTextField;

    // Creating text area
    private JTextArea outputArea;
    private JTextArea exampleMatrix;

    // Creating scroll bar
    private JScrollPane scrollVertical;

    // Creating panel objects
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel matrixInputPanel;

    // Create array of text fields
    private ArrayList<JTextField> listOfTextFields;

    // Required ArrayLists for the algorithm
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<Node> goalStates;

    // Global integer
    private long startTime;
    private long endTime;

    // Global boolean
    private boolean inputExists;
    private boolean usingFile;
    private boolean usingRandom;

    public GUI() {
        this.listOfTextFields = new ArrayList<JTextField>();
        this.matrix = new ArrayList<ArrayList<Integer>>();

        this.inputExists = false;
        this.usingFile = false;
        this.usingRandom = false;

        frame = new JFrame();

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Create a panel on the left side
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());

        // Creating large text area on the left
        outputArea = new JTextArea();
        outputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        outputArea.setEditable(false);
        GridBagConstraints cTextArea = new GridBagConstraints();
        cTextArea.fill = GridBagConstraints.BOTH;
        cTextArea.gridx = 0;
        cTextArea.gridy = 0;
        cTextArea.gridheight = 12;
        cTextArea.ipadx = 400;
        leftPanel.add(outputArea, cTextArea);

        scrollVertical = new JScrollPane(outputArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        GridBagConstraints cScrollPanel = new GridBagConstraints();
        cScrollPanel.fill = GridBagConstraints.BOTH;
        cScrollPanel.gridx = 0;
        cScrollPanel.gridy = 1;
        cScrollPanel.gridheight = 12;
        cScrollPanel.ipadx = 400;
        cScrollPanel.ipady = 400;
        leftPanel.add(scrollVertical, cScrollPanel);

        GridBagConstraints cLeftPane = new GridBagConstraints();
        cLeftPane.fill = GridBagConstraints.BOTH;
        cLeftPane.gridx = 0;
        cLeftPane.gridy = 0;
        cLeftPane.gridheight = 12;
        cLeftPane.insets = new Insets(20, 20, 20, 10);
        mainPanel.add(leftPanel, cLeftPane);

        // Objects on the right
        // Label Objects
        intro1 = new JLabel("Welcome to 15-Puzzle Problem Solver using Branch and Bound Algorithm");
        GridBagConstraints cLabel1 = new GridBagConstraints();
        cLabel1.gridx = 1;
        cLabel1.gridy = 0;
        cLabel1.insets = new Insets(20, 10, 0, 20);
        mainPanel.add(intro1, cLabel1);

        intro2 = new JLabel("Please insert your matrix number (Empty slots are indicated by 0)");
        GridBagConstraints cLabel2 = new GridBagConstraints();
        cLabel2.gridx = 1;
        cLabel2.gridy = 1;
        cLabel2.insets = new Insets(2, 10, 2, 20);
        mainPanel.add(intro2, cLabel2);

        intro3 = new JLabel("Example:");
        GridBagConstraints cLabel3 = new GridBagConstraints();
        cLabel3.gridx = 1;
        cLabel3.gridy = 2;
        cLabel3.insets = new Insets(2, 10, 2, 20);
        mainPanel.add(intro3, cLabel3);

        intro4 = new JLabel("Or you can get the matrix using these");
        GridBagConstraints cLabel4 = new GridBagConstraints();
        cLabel4.gridx = 1;
        cLabel4.gridy = 5;
        cLabel4.insets = new Insets(2, 10, 2, 20);
        mainPanel.add(intro4, cLabel4);

        errorLabel = new JLabel("Error: No Error Found!");
        GridBagConstraints cErrorLabel = new GridBagConstraints();
        cErrorLabel.gridx = 1;
        cErrorLabel.gridy = 8;
        cErrorLabel.insets = new Insets(5, 10, 5, 20);
        mainPanel.add(errorLabel, cErrorLabel);

        resetLabel = new JLabel("Click the reset button to use another method");
        GridBagConstraints cResetLabel = new GridBagConstraints();
        cResetLabel.gridx = 1;
        cResetLabel.gridy = 10;
        cResetLabel.insets = new Insets(5, 10, 5, 20);
        mainPanel.add(resetLabel, cResetLabel);

        timeTaken = new JLabel("Time elapsed: 0 ms");
        GridBagConstraints cTimeTaken = new GridBagConstraints();
        cTimeTaken.gridx = 0;
        cTimeTaken.gridy = 12;
        cTimeTaken.gridwidth = 2;
        cTimeTaken.insets = new Insets(5, 20,20, 20);
        mainPanel.add(timeTaken, cTimeTaken);

        // Text area for example matrix
        exampleMatrix = new JTextArea();
        exampleMatrix.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        exampleMatrix.setEditable(false);
        exampleMatrix.setText(
                "1 2 3 4\n" + "5 6 0 8\n" + "9 10 7 11\n" + "13 14 15 12"
        );
        GridBagConstraints cExampleMatrix = new GridBagConstraints();
        cExampleMatrix.gridx = 1;
        cExampleMatrix.gridy = 3;
        cExampleMatrix.insets = new Insets(10, 10, 10, 20);
        mainPanel.add(exampleMatrix, cExampleMatrix);

        // Matrix input area
        matrixInputPanel = new JPanel();
        matrixInputPanel.setLayout(new GridLayout(4,4, 2, 2));

        // Create text objects
        for (int i = 0; i < 16; i++) {
            matrixTextField = new JTextField();
            matrixInputPanel.add(matrixTextField);
            this.listOfTextFields.add(matrixTextField);
        }
        GridBagConstraints cMatrixArea = new GridBagConstraints();
        cMatrixArea.fill = GridBagConstraints.BOTH;
        cMatrixArea.gridx = 1;
        cMatrixArea.gridy = 4;
        cMatrixArea.insets = new Insets(10, 10, 10, 20);
        mainPanel.add(matrixInputPanel, cMatrixArea);

        // Buttons
        // File input button
        button_file_input = new JButton("Input matrix from file");
        GridBagConstraints cButtonFile = new GridBagConstraints();
        cButtonFile.gridx = 1;
        cButtonFile.gridy = 6;
        cButtonFile.insets = new Insets(2, 10, 2, 20);
        mainPanel.add(button_file_input, cButtonFile);

        // Random input button
        button_random_input = new JButton("Use random matrix");
        GridBagConstraints cButtonRandom = new GridBagConstraints();
        cButtonRandom.gridx = 1;
        cButtonRandom.gridy = 7;
        cButtonRandom.insets = new Insets(2, 10, 2, 20);
        mainPanel.add(button_random_input, cButtonRandom);

        // Start button
        button_start = new JButton("Start");
        GridBagConstraints cButtonStart = new GridBagConstraints();
        cButtonStart.gridx = 1;
        cButtonStart.gridy = 9;
        cButtonStart.insets = new Insets(2, 10, 2, 20);
        mainPanel.add(button_start, cButtonStart);

        // Reset button
        button_reset = new JButton("Reset");
        GridBagConstraints cButtonReset = new GridBagConstraints();
        cButtonReset.gridx = 1;
        cButtonReset.gridy = 11;
        cButtonReset.insets = new Insets(2, 10, 20, 20);
        mainPanel.add(button_reset, cButtonReset);

        // Action listener
        button_file_input.addActionListener(e -> fileButtonPressed());
        button_random_input.addActionListener(e -> randomButtonPressed());
        button_start.addActionListener(e -> startButtonPressed());
        button_reset.addActionListener(e -> resetButtonPressed());

        // Add Frame
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("15 Puzzle Problem Solver");
        frame.pack();
        frame.setVisible(true);
    }

    // Action when file button is pressed
    public void fileButtonPressed() {
        if (!inputExists) {
            JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
            int status = fileChooser.showOpenDialog(frame);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file == null) {
                    return;
                }

                String fileName = fileChooser.getSelectedFile().getPath();
                System.out.println("Path: " + fileName);
                String convertedFileName = fileName.replace("\\", "\\\\");
                System.out.println("New Path: " + convertedFileName);
                try {
                    matrix = Input.readFromFile(convertedFileName);
                    if (Utilities.checkRepeatingElement(matrix)) {
                        printErrorMessage("Not all matrix elements are distinct!");
                    } else {
                        inputExists = true;
                        usingFile = true;
                        int counter = 0;
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                listOfTextFields.get(counter).setText(matrix.get(i).get(j).toString());
                                listOfTextFields.get(counter).setEditable(false);
                                counter++;
                            }
                        }
                    }

                } catch (Exception e) {
                    printErrorMessage("File not found!");
                }
            }
        } else {
            printErrorMessage("Choose only one method to get the matrix!");
        }
    }

    // Action when random button is pressed
    public void randomButtonPressed() {
        if (!inputExists) {
            boolean reachableMatrix = false;
            while (!reachableMatrix) {
                matrix = Input.createRandomMatrix();
                List<Object> reachableResult = Algorithm.isGoalReachable(matrix);
                boolean goal = (boolean)reachableResult.get(0);
                if (goal) {
                    reachableMatrix = true;
                }
            }

            inputExists = true;
            usingRandom = true;
            int counter = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    listOfTextFields.get(counter).setText(matrix.get(i).get(j).toString());
                    listOfTextFields.get(counter).setEditable(false);
                    counter++;
                }
            }
        } else {
            printErrorMessage("Choose only one method to get the matrix! Click the reset button to use another method");
        }
    }

    // Action when start button is pressed
    @SuppressWarnings("unchecked")
    public void startButtonPressed() {
        boolean correct = true;
        // If user didn't use a file or create a random matrix, then read the entry from the text fields
        if (!usingFile && !usingRandom) {
            correct = false;
            ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
            for (JTextField textFields : listOfTextFields) {
                textFields.setEditable(false);
                String strNumber = textFields.getText();
                Integer number = Integer.valueOf(strNumber);
                listOfNumbers.add(number);
            }
            System.out.println(listOfNumbers);
            matrix = Utilities.convertListToMatrix(listOfNumbers);
            if (Utilities.checkRepeatingElement(matrix)) {
                printErrorMessage("Not all matrix elements are distinct!");
            } else {
                correct = true;
            }
        }

        if (correct) {
            // Create a root node to start the algorithm
            startTime = System.nanoTime();
            ArrayList<String> direction = new ArrayList<String>();
            Node root = new Node(matrix, 0, direction);
            int result = (int)Algorithm.isGoalReachable(matrix).get(1);
            List<Object> algorithmResult = Algorithm.branchAndBoundAlgorithm(root);
            goalStates = (ArrayList<Node>) algorithmResult.get(0);
            int nodeCount = (int)algorithmResult.get(1);
            endTime = System.nanoTime();
            // If goalStates is empty, then function KURANG(X) + i result is odd
            if (goalStates.isEmpty()) {
                StringBuilder output = new StringBuilder();
                output.append("Goal state is not reachable!\n");
                output.append("Function KURANG(i) + X result is ").append(result).append(" which is odd");
                printTextOutput(output.toString());
            } else {
                String text = "KURANG(i) + X = " + result + "\n" + "\n";
                text += Utilities.displayGoalStates(matrix, goalStates);
                text += "\nGenerated " + nodeCount + " node(s)";
                printTextOutput(text);
                long difference = (endTime - startTime);
                float timeElapsed = (float)difference / 1000000;
                timeTaken.setText("Time elapsed: " + timeElapsed + " ms");
            }
        }
    }

    // Action when reset button is pressed
    public void resetButtonPressed() {
        usingFile = false;
        usingRandom = false;
        inputExists = false;
        for (int i = 0; i < 16; i++) {
            listOfTextFields.get(i).setText(null);
            listOfTextFields.get(i).setEditable(true);
        }
        outputArea.setText(null);
        timeTaken.setText("Time elapsed: 0 ms");
        printErrorMessage("No Error Found!");
    }

    // Function to display text in the text area
    public void printTextOutput(String text) {
        outputArea.setText(text);
    }

    // Function to display error messages
    public void printErrorMessage(String text){
        errorLabel.setText("Error: " + text);
    }
}
