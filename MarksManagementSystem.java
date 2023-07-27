import java.util.Scanner;

public class MarksManagementSystem {
    private static final int MAX_STUDENTS = 100; // Maximum number of students
    private static String[] studentNames = new String[MAX_STUDENTS];
    private static int[] marksProgrammingFundamentals = new int[MAX_STUDENTS];
    private static int[] marksDatabaseManagement = new int[MAX_STUDENTS];
    private static String[] studentIDs = new String[MAX_STUDENTS];
    private static boolean[] hasMarks = new boolean[MAX_STUDENTS];
    private static int numStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            clearConsole();
            displayMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    addNewStudentWithMarks(scanner);
                    break;
                case 3:
                    addMarks(scanner);
                    break;
                case 4:
                    updateStudentDetails(scanner);
                    break;
                case 5:
                    updateMarks(scanner);
                    break;
                case 6:
                    deleteStudent(scanner);
                    break;
                case 7:
                    printStudentDetails(scanner);
                    break;
                case 8:
                    printStudentRanks(scanner);
                    break;
                case 9:
                    findBestInProgrammingFundamentals();
                    break;
                case 10:
                    findBestInDatabaseManagement();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            scanner.nextLine(); // Wait for Enter key press
        } while (option != 0);

        scanner.close();
    }

    // Helper method to clear the console
    private static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to display the menu
    private static void displayMenu() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -  - - - - - - - - - -- - - - - - -");
        System.out.println("|    WELCOME TO GDSE MARKS MANAGEMENT SYSTEM           | ");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -  - - -- - - - - - - - - -- - - -");
        System.out.println("[1]	Add New Student                   [2] Add New Student With Marks");
        System.out.println("[3]	Add Marks			              [4] Update Student Details");
        System.out.println("[5]	Update Marks                      [6] Delete Student");
        System.out.println("[7]	Print Student Details		      [8] Print Student Ranks");
        System.out.println("[9]	Best in Programming Fundamentals  [10] Best in Database Management SYSTEM");

        System.out.print("Enter an option to continue > ");
    }

    // Implement the rest of the use case methods here
    private static void addNewStudent(Scanner scanner) {
        if (numStudents >= MAX_STUDENTS) {
            System.out.println("Maximum number of students reached.");
            return;
        }

        String newStudentID;
        String newStudentName;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -  - -");
        System.out.println("|                       ADD NEW STUDENT                 |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -  - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            newStudentID = scanner.next();

            // Check if the Student ID already exists
            if (findStudentIndexByID(newStudentID) != -1) {
                System.out.println("The Student ID already exists.");
            } else {
                break;
            }
        } while (true);

        System.out.print("Enter Student Name      : ");
        newStudentName = scanner.next();

        // Add Student ID as a prefix to the Student Name
        String studentInfo = newStudentID + " " + newStudentName;
        studentNames[numStudents] = studentInfo;
        numStudents++;

        System.out.println("\nStudent has been added successfully.");

        // Ask if the user wants to add another student
        System.out.print("Do you want to add a new student (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            addNewStudent(scanner);
        }
    }


    // Helper method to find the index of a student by Student ID
    private static int findStudentIndexByID(String studentID) {
        for (int i = 0; i < numStudents; i++) {
            String[] parts = studentNames[i].split(" ");
            if (parts[0].equals(studentID)) {
                return i;
            }
        }
        return -1; // Student ID not found
    }

    // Sample method for adding a new student with marks
    private static void addNewStudentWithMarks(Scanner scanner) {
        if (numStudents >= MAX_STUDENTS) {
            System.out.println("Maximum number of students reached.");
            return;
        }

        String newStudentID;
        String newStudentName;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                ADD NEW STUDENT  WITH MARKS            |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            newStudentID = scanner.next();

            // Check if the Student ID already exists
            if (findStudentIndexByID(newStudentID) != -1) {
                System.out.println("The Student ID already exists.");
            } else {
                break;
            }
        } while (true);

        System.out.print("Enter Student Name      : ");
        newStudentName = scanner.next();

        int programmingMarks;
        int dbMarks;

        do {
            System.out.print("Programming Fundamentals Marks    : ");
            programmingMarks = scanner.nextInt();

            if (programmingMarks < 0 || programmingMarks > 100) {
                System.out.println("Invalid marks. Please enter correct marks.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Database Management System Marks  : ");
            dbMarks = scanner.nextInt();

            if (dbMarks < 0 || dbMarks > 100) {
                System.out.println("Invalid marks. Please enter correct marks.");
            } else {
                break;
            }
        } while (true);

        // Add Student ID as a prefix to the Student Name
        String studentInfo = newStudentID + " " + newStudentName;
        studentNames[numStudents] = studentInfo;
        marksProgrammingFundamentals[numStudents] = programmingMarks;
        marksDatabaseManagement[numStudents] = dbMarks;
        numStudents++;

        System.out.println("\nStudent has been added successfully.");

        // Ask if the user wants to add another student
        System.out.print("Do you want to add a new student (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            addNewStudentWithMarks(scanner);
        }
    }

// ...

    private static void addMarks(Scanner scanner) {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        String studentID;
        boolean foundStudent = false;
        int studentIndex = -1;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                 ADD MARKS                             |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            studentID = scanner.next();

            // Check if the Student ID exists
            studentIndex = findStudentIndexByID(studentID);
            if (studentIndex != -1) {
                foundStudent = true;
                break;
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    return;
                }
            }
        } while (true);

        // Check if marks have already been assigned for this student
        if (hasMarks[studentIndex]) {
            System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);
            System.out.println("This student's marks have already been added.");
            System.out.println("If you want to update the marks, please use [4] Update marks option\n");

            System.out.print("Do you want to add marks for another student? (Y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("n")) {
                return;
            } else {
                addMarks(scanner);
                return;
            }
        }

        System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);

        int programmingMarks;
        int dbMarks;

        do {
            System.out.print("Programming Fundamentals Marks    : ");
            programmingMarks = scanner.nextInt();

            if (programmingMarks < 0 || programmingMarks > 100) {
                System.out.println("Invalid marks. Please enter correct marks.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Database Management System Marks  : ");
            dbMarks = scanner.nextInt();

            if (dbMarks < 0 || dbMarks > 100) {
                System.out.println("Invalid marks. Please enter correct marks.");
            } else {
                break;
            }
        } while (true);

        // Update the marks for the student
        marksProgrammingFundamentals[studentIndex] = programmingMarks;
        marksDatabaseManagement[studentIndex] = dbMarks;
        hasMarks[studentIndex] = true; // Set the hasMarks flag to true for this student

        System.out.println("\nStudent marks have been added successfully.");

        // Ask if the user wants to add marks for another student
        System.out.print("Do you want to add marks for another student? (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            addMarks(scanner);
        }
    }

    private static void updateStudentDetails(Scanner scanner) {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        String studentID;
        boolean foundStudent = false;
        int studentIndex = -1;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                 UPDATE STUDENT DETAILS                          |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            studentID = scanner.next();

            // Check if the Student ID exists
            studentIndex = findStudentIndexByID(studentID);
            if (studentIndex != -1) {
                foundStudent = true;
                break;
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    return;
                }
            }
        } while (true);

        System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);

        System.out.print("Enter the new student name : ");
        String newStudentName = scanner.next();

        if (newStudentName.isEmpty()) {
            System.out.println("Student name cannot be empty. Please enter a valid name.");
            updateStudentDetails(scanner);
            return;
        }

        // Update the student name
        studentNames[studentIndex] = studentID + " " + newStudentName;

        System.out.println("\nStudent details have been updated successfully.");

        // Ask if the user wants to update details for another student
        System.out.print("Do you want to update another student details? (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            updateStudentDetails(scanner);
        }
    }

    private static void updateMarks(Scanner scanner) {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        String studentID;
        boolean foundStudent = false;
        int studentIndex = -1;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                 UPDATE MARKS                         |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            studentID = scanner.next();

            // Check if the Student ID exists
            studentIndex = findStudentIndexByID(studentID);
            if (studentIndex != -1) {
                foundStudent = true;
                break;
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    return;
                }
            }
        } while (true);

        // Check if marks have already been assigned for this student
        if (!hasMarks[studentIndex]) {
            System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);
            System.out.println("This student's marks yet to be added.\n");

            System.out.print("Do you want to update marks for another student? (Y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("n")) {
                return;
            } else {
                updateMarks(scanner);
                return;
            }
        }

        System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);
        System.out.println("Programming Fundamentals Marks    : " + marksProgrammingFundamentals[studentIndex]);
        System.out.println("Database Management System Marks  : " + marksDatabaseManagement[studentIndex]);

        int newProgrammingMarks;
        int newDbMarks;

        do {
            System.out.print("\nEnter new programming fundamentals marks      : ");
            newProgrammingMarks = scanner.nextInt();

            if (newProgrammingMarks < 0 || newProgrammingMarks > 100) {
                System.out.println("Invalid marks. Please enter correct marks.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Enter new database management system marks    : ");
            newDbMarks = scanner.nextInt();

            if (newDbMarks < 0 || newDbMarks > 100) {
                System.out.println("Invalid marks. Please enter correct marks.");
            } else {
                break;
            }
        } while (true);

        // Update the marks for the student
        marksProgrammingFundamentals[studentIndex] = newProgrammingMarks;
        marksDatabaseManagement[studentIndex] = newDbMarks;

        System.out.println("\nMarks have been updated successfully.");

        // Ask if the user wants to update marks for another student
        System.out.print("Do you want to update marks for another student? (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            updateMarks(scanner);
        }
    }

    private static void deleteStudent(Scanner scanner) {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        String studentID;
        boolean foundStudent = false;
        int studentIndex = -1;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                 DELETE STUDENT                        |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            studentID = scanner.next();

            // Check if the Student ID exists
            studentIndex = findStudentIndexByID(studentID);
            if (studentIndex != -1) {
                foundStudent = true;
                break;
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    return;
                }
            }
        } while (true);

        System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);

        // Delete the student details
        for (int i = studentIndex; i < numStudents - 1; i++) {
            studentNames[i] = studentNames[i + 1];
            marksProgrammingFundamentals[i] = marksProgrammingFundamentals[i + 1];
            marksDatabaseManagement[i] = marksDatabaseManagement[i + 1];
            hasMarks[i] = hasMarks[i + 1];
        }

        // Decrement the number of students
        numStudents--;

        System.out.println("\nStudent has been deleted successfully.");

        // Ask if the user wants to delete another student
        System.out.print("Do you want to delete another student? (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            deleteStudent(scanner);
        }
    }


    private static void printStudentDetails(Scanner scanner) {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        String studentID;
        boolean foundStudent = false;
        int studentIndex = -1;

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                 PRINT STUDENT DETAILS                   |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        do {
            System.out.print("\nEnter Student ID      : ");
            studentID = scanner.next();

            // Check if the Student ID exists
            studentIndex = findStudentIndexByID(studentID);
            if (studentIndex != -1) {
                foundStudent = true;
                break;
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("n")) {
                    return;
                }
            }
        } while (true);

        System.out.println("Student Name          : " + studentNames[studentIndex].split(" ")[1]);

        // Check if marks have been added for this student
        if (!hasMarks[studentIndex]) {
            System.out.println("Marks yet to be added.\n");

            System.out.print("Do you want to search another student details? (Y/n): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("n")) {
                return;
            } else {
                printStudentDetails(scanner);
                return;
            }
        }

        int programmingMarks = marksProgrammingFundamentals[studentIndex];
        int dbMarks = marksDatabaseManagement[studentIndex];
        int totalMarks = programmingMarks + dbMarks;
        double avgMarks = totalMarks / 2.0;

        // Compute the rank of the student
        int rank = 1;
        for (int i = 0; i < numStudents; i++) {
            int total = marksProgrammingFundamentals[i] + marksDatabaseManagement[i];
            if (total > totalMarks) {
                rank++;
            }
        }

        System.out.println("+-------------------------------+------------+");
        System.out.println("| Programming Fundamentals Marks |      " + programmingMarks + "     |");
        System.out.println("| Database Management System     |      " + dbMarks + "     |");
        System.out.println("| Total Marks                    |      " + totalMarks + "     |");
        System.out.println("| Avg. Marks                     |      " + avgMarks + "     |");
        System.out.println("| Rank                           |  " + rank + getRankText(rank) + "  |");
        System.out.println("+--------------------------------+------------+");

        // Ask if the user wants to search another student details
        System.out.print("\nDo you want to search another student details? (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            printStudentDetails(scanner);
        }
    }

    // Helper method to get the text for the rank
    private static String getRankText(int rank) {
        if (rank == 1) {
            return "(First)";
        } else if (rank == 2) {
            return "(Second)";
        } else if (rank == 3) {
            return "(Third)";
        } else {
            return "(Last)";
        }
    }

    private static void printStudentRanks(Scanner scanner) {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|                 PRINT STUDENT'S RANKS                  |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");

        // Compute the total marks and average marks for each student
        int[] totalMarks = new int[numStudents];
        double[] avgMarks = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            totalMarks[i] = marksProgrammingFundamentals[i] + marksDatabaseManagement[i];
            avgMarks[i] = totalMarks[i] / 2.0;
        }

        // Sort the students based on their total marks in descending order
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = i + 1; j < numStudents; j++) {
                if (totalMarks[i] < totalMarks[j]) {
                    // Swap student IDs
                    String tempID = studentIDs[i];
                    studentIDs[i] = studentIDs[j];
                    studentIDs[j] = tempID;

                    // Swap student names
                    String tempName = studentNames[i];
                    studentNames[i] = studentNames[j];
                    studentNames[j] = tempName;

                    // Swap total marks
                    int tempTotalMarks = totalMarks[i];
                    totalMarks[i] = totalMarks[j];
                    totalMarks[j] = tempTotalMarks;

                    // Swap average marks
                    double tempAvgMarks = avgMarks[i];
                    avgMarks[i] = avgMarks[j];
                    avgMarks[j] = tempAvgMarks;
                }
            }
        }

        System.out.println("+------+------+-------+-------------+-----------+");
        System.out.println("| Rank | ID   | Name | Total Marks | Avg. Marks|");
        System.out.println("+------+------+-------+-------------+-----------+");
        for (int i = 0; i < numStudents; i++) {
            int rank = i + 1;
            String studentID = studentIDs[i];
            String studentName = studentNames[i];
            String totalMarksStr = Integer.toString(totalMarks[i]);
            String avgMarksStr = String.format("%.2f", avgMarks[i]);

            System.out.printf("| %-4d | %-4s | %-5s | %-11s | %-9s|\n", rank, studentID, studentName, totalMarksStr, avgMarksStr);
        }
        System.out.println("+------+------+-------+-------------+-----------+");

        // Ask if the user wants to stay or go back to the main menu
        System.out.print("\nDo you want to go back to main menu? (Y/n): ");
        String response = scanner.next();
        if (response.equalsIgnoreCase("n")) {
            return;
        } else {
            printStudentRanks(scanner);
        }
    }


    // Method to find the best students in Programming Fundamentals
    private static void findBestInProgrammingFundamentals() {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        // Create arrays to store student data for best students
        String[] bestStudentIDs = new String[numStudents];
        String[] bestStudentNames = new String[numStudents];
        int[] bestPFMarks = new int[numStudents];
        int[] bestDBMSMarks = new int[numStudents];

        // Copy student data to the arrays
        for (int i = 0; i < numStudents; i++) {
            bestStudentIDs[i] = studentIDs[i];
            bestStudentNames[i] = studentNames[i];
            bestPFMarks[i] = marksProgrammingFundamentals[i];
            bestDBMSMarks[i] = marksDatabaseManagement[i];
        }

        // Sort the students based on PF marks (Descending order)
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (bestPFMarks[j] < bestPFMarks[j + 1]) {
                    // Swap the elements
                    String tempID = bestStudentIDs[j];
                    String tempName = bestStudentNames[j];
                    int tempPFMarks = bestPFMarks[j];
                    int tempDBMSMarks = bestDBMSMarks[j];

                    bestStudentIDs[j] = bestStudentIDs[j + 1];
                    bestStudentNames[j] = bestStudentNames[j + 1];
                    bestPFMarks[j] = bestPFMarks[j + 1];
                    bestDBMSMarks[j] = bestDBMSMarks[j + 1];

                    bestStudentIDs[j + 1] = tempID;
                    bestStudentNames[j + 1] = tempName;
                    bestPFMarks[j + 1] = tempPFMarks;
                    bestDBMSMarks[j + 1] = tempDBMSMarks;
                }
            }
        }

        // Display the best students' details
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|            BEST IN PROGRAMMING FUNDAMENTALS          |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("| ID  | Name     | PF Marks | DBMS Marks  |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("| %-3s | %-8s | %-8d | %-11d |%n", bestStudentIDs[i], bestStudentNames[i], bestPFMarks[i], bestDBMSMarks[i]);
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        // Prompt whether the user wants to continue or go back to the main menu
        System.out.print("\nDo you want to go back to main menu? (Y/n): ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        if (!response.equalsIgnoreCase("Y")) {
            return;
        }
        scanner.close();
    }

    // Method to find the best students in Database Management System
    private static void findBestInDatabaseManagement() {
        if (numStudents == 0) {
            System.out.println("No student details found. Please add new students first.");
            return;
        }

        // Create arrays to store student data for best students in DBMS
        String[] bestStudentIDs = new String[numStudents];
        String[] bestStudentNames = new String[numStudents];
        int[] bestPFMarks = new int[numStudents];
        int[] bestDBMSMarks = new int[numStudents];

        // Copy student data to the arrays
        for (int i = 0; i < numStudents; i++) {
            bestStudentIDs[i] = studentIDs[i];
            bestStudentNames[i] = studentNames[i];
            bestPFMarks[i] = marksProgrammingFundamentals[i];
            bestDBMSMarks[i] = marksDatabaseManagement[i];
        }

        // Sort the students based on DBMS marks (Descending order)
        for (int i = 0; i < numStudents - 1; i++) {
            for (int j = 0; j < numStudents - i - 1; j++) {
                if (bestDBMSMarks[j] < bestDBMSMarks[j + 1]) {
                    // Swap the elements
                    String tempID = bestStudentIDs[j];
                    String tempName = bestStudentNames[j];
                    int tempPFMarks = bestPFMarks[j];
                    int tempDBMSMarks = bestDBMSMarks[j];

                    bestStudentIDs[j] = bestStudentIDs[j + 1];
                    bestStudentNames[j] = bestStudentNames[j + 1];
                    bestPFMarks[j] = bestPFMarks[j + 1];
                    bestDBMSMarks[j] = bestDBMSMarks[j + 1];

                    bestStudentIDs[j + 1] = tempID;
                    bestStudentNames[j + 1] = tempName;
                    bestPFMarks[j + 1] = tempPFMarks;
                    bestDBMSMarks[j + 1] = tempDBMSMarks;
                }
            }
        }

        // Display the best students' details in DBMS
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("|        BEST IN DATABASE MANAGEMENT SYSTEM        |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -- - - - - -");
        System.out.println("| ID  | Name     | PF Marks | DBMS Marks  |");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("| %-3s | %-8s | %-8d | %-11d |%n", bestStudentIDs[i], bestStudentNames[i], bestPFMarks[i], bestDBMSMarks[i]);
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        // Prompt whether the user wants to continue or go back to the main menu
        System.out.print("\nDo you want to go back to main menu? (Y/n): ");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        if (!response.equalsIgnoreCase("Y")) {
            return;
        }
        scanner.close();
    }
}
