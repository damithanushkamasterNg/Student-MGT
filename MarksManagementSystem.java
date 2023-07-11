import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Scanner;

public class MarksManagementSystem extends JFrame {
    private Scanner scanner;
    private JTextField idTextField;
    private JTextField optionTextField;

    private JPanel optionsPanel;
    private JLabel welcomeLabel;
    private JPanel inputPanel;
    private JLabel optionLabel;

    public MarksManagementSystem() {
        setTitle("GDSE Marks Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());
        welcomeLabel = new JLabel("WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Set top gap
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        optionsPanel = new JPanel(new GridLayout(5, 2, 0, 0)); // One column, with gap between rows
        optionsPanel.add(new JLabel("  [1] Add New Student"));
        optionsPanel.add(new JLabel("[2] Add New Student With Marks"));
        optionsPanel.add(new JLabel("  [3] Add Marks"));
        optionsPanel.add(new JLabel("[4] Update Student Details"));
        optionsPanel.add(new JLabel("  [5] Update Marks"));
        optionsPanel.add(new JLabel("[6] Delete Student"));
        optionsPanel.add(new JLabel("  [7] Print Student Details"));
        optionsPanel.add(new JLabel("[8] Print Student Ranks"));
        optionsPanel.add(new JLabel("  [9] Best in Programming Fundamentals"));
        optionsPanel.add(new JLabel("[10] Best In Database Management System"));
        add(optionsPanel, BorderLayout.CENTER);

        inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 6));
        optionLabel = new JLabel("Enter an option to continue >");
        optionTextField = new JTextField(10);
        optionTextField.setBorder(null);
        optionTextField.setBackground(optionsPanel.getBackground()); // Set background as parent
        optionTextField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); // Set cursor as pointing hand
        optionTextField.addActionListener(e -> handleOptionInput());
        inputPanel.add(optionLabel);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Increase the top gap
        inputPanel.add(optionTextField);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MarksManagementSystem::new);
    }

    private void handleOptionInput() {
        String option = optionTextField.getText();

        try {
            int optionValue = Integer.parseInt(option);

            switch (optionValue) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    // Handle option 2: Add New Student With Marks
                    break;
                case 3:
                    // Handle option 3: Add Marks
                    break;
                case 4:
                    // Handle option 4: Update Student Details
                    break;
                case 5:
                    // Handle option 5: Update Marks
                    break;
                case 6:
                    // Handle option 6: Delete Student
                    break;
                case 7:
                    // Handle option 7: Print Student Details
                    break;
                case 8:
                    // Handle option 8: Print Student Ranks
                    break;
                case 9:
                    // Handle option 9: Best in Programming Fundamentals
                    break;
                case 10:
                    // Handle option 10: Best in Database Management System
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid option! Please enter a number.");
        }
    }

    private void addNewStudent() {
        optionsPanel.setVisible(false);
        welcomeLabel.setText("ADD NEW STUDENT");
        JTextField nameTextField1 =new JTextField();
        JPanel studentInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 6));
        JLabel idLabel = new JLabel("Enter Student ID:");
        idTextField = new JTextField(1);
        nameTextField1.setBorder(null);
        nameTextField1.setBackground(optionsPanel.getBackground());
        idTextField.addActionListener(e -> nameTextField1.requestFocus()); // Move focus to nameTextField after pressing Enter
        studentInputPanel.add(idLabel);
        studentInputPanel.add(idTextField);

        JLabel nameLabel = new JLabel("Enter Student Name:");
        JTextField nameTextField2;
        nameTextField2 = new JTextField(1);
        nameTextField2.setBorder(null);
        nameTextField2.setBackground(optionsPanel.getBackground());
        nameTextField2.addActionListener(e -> addNewStudent()); // Show the result label after pressing Enter in nameTextField
        studentInputPanel.add(nameLabel);
        studentInputPanel.add(nameTextField2);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(studentInputPanel, BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
        idTextField.requestFocus(); // Set initial focus on idTextField
    }

}
