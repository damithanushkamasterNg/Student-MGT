import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;

class Student {
    private String id;
    private String name;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MarksManagementSystem extends JFrame {
    private Scanner scanner;
    private JTextField mainTextField;
    private JPanel homePanel;

    private JPanel mainOptionSelectionPanel;
    private JLabel windowTitleLabel;

    int i = 0;

    List<Student> studentDataList = new ArrayList<>();


    public MarksManagementSystem() {
        setTitle("GDSE Marks Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 400);
        setLayout(new BorderLayout());
        windowTitleLabel = new JLabel("WELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
        windowTitleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Set top gap
        windowTitleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(windowTitleLabel, BorderLayout.NORTH);

        homePanel = new JPanel(new GridLayout(5, 2, 0, 0)); // One column, with gap between rows
        homePanel.add(new JLabel("  [1] Add New Student"));
        homePanel.add(new JLabel("[2] Add New Student With Marks"));
        homePanel.add(new JLabel("  [3] Add Marks"));
        homePanel.add(new JLabel("[4] Update Student Details"));
        homePanel.add(new JLabel("  [5] Update Marks"));
        homePanel.add(new JLabel("[6] Delete Student"));
        homePanel.add(new JLabel("  [7] Print Student Details"));
        homePanel.add(new JLabel("[8] Print Student Ranks"));
        homePanel.add(new JLabel("  [9] Best in Programming Fundamentals"));
        homePanel.add(new JLabel("[10] Best In Database Management System"));
        add(homePanel, BorderLayout.CENTER);

        mainOptionSelectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 6));
        JLabel optionLabel = new JLabel("Enter an option to continue >");
        mainTextField = new JTextField(10);
        mainTextField.setBorder(null);
        mainTextField.setBackground(homePanel.getBackground()); // Set background as parent
        mainTextField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)); // Set cursor as pointing hand
        mainTextField.addActionListener(e -> handleOptionInput());
        mainOptionSelectionPanel.add(optionLabel);
        mainOptionSelectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Increase the top gap
        mainOptionSelectionPanel.add(mainTextField);
        add(mainOptionSelectionPanel, BorderLayout.SOUTH);

        setVisible(true);
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MarksManagementSystem::new);
    }

    private void handleOptionInput() {
        String option = mainTextField.getText();

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
        homePanel.setVisible(false);
        mainOptionSelectionPanel.setVisible(false);

        windowTitleLabel.setText("ADD NEW STUDENT");

        JPanel studentInputPanel = new JPanel(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("Enter Student ID:");
        JTextField idTextField = new JTextField();
        idTextField.setBorder(null);
        idTextField.setBackground(homePanel.getBackground());

        JLabel studentNameLabel = new JLabel("Enter Student Name:");
        JTextField studentNameField = new JTextField();
        studentNameField.setBorder(null);
        studentNameField.setBackground(homePanel.getBackground());

        JLabel successLabel = new JLabel("Student has been added successfully. Do you want to add a new student (y/n):");
        JTextField confirmationField = new JTextField(2);

        idTextField.addActionListener(e -> {
            studentNameLabel.setVisible(true);
            studentNameField.setVisible(true);
            studentNameField.requestFocus();
        });

        studentNameField.addActionListener(e -> {
            successLabel.setVisible(true);
            confirmationField.setVisible(true);
            confirmationField.setBorder(null);
            confirmationField.setBackground(homePanel.getBackground());
            confirmationField.requestFocus();

            // Create a new Student object and add it to the list
            String id = idTextField.getText();
            String name = studentNameField.getText();
            Student student = new Student(id, name);
            studentDataList.add(student);

            // Display the student data in the window
            displayStudentData();
        });

        confirmationField.addActionListener(e -> {
            String confirmation = confirmationField.getText().trim().toLowerCase();
            if (confirmation.equals("y")) {
                successLabel.setVisible(true);
                confirmationField.setVisible(true);
                idLabel.setVisible(true);
                idTextField.setVisible(true);
                studentNameLabel.setVisible(true);
                studentNameField.setVisible(true);
                successLabel.setVisible(false);
                confirmationField.setVisible(false);
                idTextField.setText("");
                studentNameField.setText("");
                idTextField.requestFocus();
            } else {
                // Close window or perform any desired action
            }
        });

        studentInputPanel.add(idLabel);
        studentInputPanel.add(idTextField);
        studentInputPanel.add(studentNameLabel);
        studentInputPanel.add(studentNameField);
        studentInputPanel.add(successLabel);
        studentInputPanel.add(confirmationField);

        successLabel.setVisible(false);
        confirmationField.setVisible(false);

        add(studentInputPanel, BorderLayout.CENTER);

        setVisible(true);
        idTextField.requestFocus(); // Set initial focus on idTextField
    }

    private void displayStudentData() {
        // Create a separate panel to display the student data
        JPanel studentDataPanel = new JPanel(new GridLayout(studentDataList.size() + 1, 2));

        // Add labels for "Enter Student ID" and "Enter Student Name" in the first row
        JLabel idInputLabel = new JLabel("Enter Student ID:");
        JLabel nameInputLabel = new JLabel("Enter Student Name:");
        studentDataPanel.add(idInputLabel);
        studentDataPanel.add(nameInputLabel);

        // Add labels for entered ID and name for each student
        for (Student student : studentDataList) {
            JLabel idLabel = new JLabel(student.getId());
            JLabel nameLabel = new JLabel(student.getName());
            studentDataPanel.add(idLabel);
            studentDataPanel.add(nameLabel);
        }

        // Add the student data panel to the main window
        add(studentDataPanel, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }





}
