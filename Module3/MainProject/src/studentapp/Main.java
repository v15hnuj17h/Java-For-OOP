// A console-based Student Record Management System that lets you add, display, search, and analyze student records 
// use "chcp 65001" in cmd to enable UTF-8 encoding for better display of special characters.

package studentapp;

import java.util.Scanner;
import studentapp.model.Student;
import studentapp.manager.StudentManager;
import java.util.InputMismatchException;
import studentapp.exceptions.InvalidMarksException;
import studentapp.exceptions.InvalidRollNumberException;
import studentapp.utils.AutoSaveTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        
        int choice = 1;
        String name;
        int rollNumber = 0;
        double[] marks = new double[5];

        AutoSaveTask saveTask = new AutoSaveTask(manager, 10000);
        Thread saveThread = new Thread(saveTask);
        saveThread.setName("AutoSave-Thread");
        saveThread.start();

        do{

            System.out.println();
            System.out.println("\t╔═════════════════════════════════════╗");
            System.out.printf ("\t║     STUDENT MANAGEMENT SYSTEM (%2d)  ║%n",StudentManager.getTotalStudents());
            System.out.println("\t╠═════════════════════════════════════╣");
            System.out.println("\t║  1. Add Student                     ║");
            System.out.println("\t║  2. Display All Students            ║");
            System.out.println("\t║  3. Search Student                  ║");
            System.out.println("\t║  4. Class Statistics                ║");
            System.out.println("\t║  5. Exit                            ║");       
            System.out.println("\t╚═════════════════════════════════════╝");
            System.out.print("\n➤ Enter your choice: ");

            try{
                choice = sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println("✗ Please enter a valid number (1-5)");
                sc.nextLine();
                choice = -1;
            }

            switch (choice) {
                case 1:

                    System.out.println("\n────────── ADD NEW STUDENT ──────────");
                    System.out.print("➤ Enter student name       : ");
                    name = sc.nextLine();
                    boolean validRoll = false;
                    do {
                        try {
                            System.out.print("➤ Enter roll number (1-75): ");
                            rollNumber = sc.nextInt();
                            sc.nextLine();
                            manager.validateRollNumber(rollNumber);
                            validRoll = true;

                        } catch (InputMismatchException e) {
                            System.out.println("✗ Please enter a valid number!");
                            sc.nextLine();

                        } catch (InvalidRollNumberException e) {
                            System.out.println("✗ " + e.getMessage());
                        }
                    } while (!validRoll);

                    boolean studentAdded = false;
                    while (!studentAdded) {
                        try {
                            for (int i = 0; i < 5; i++) {
                                System.out.printf("➤ Enter mark for subject %d : ", i+1);
                                marks[i] = sc.nextDouble();
                            }
                            sc.nextLine();

                            Student s = new Student(name, rollNumber, marks);
                            manager.addStudent(s);
                            System.out.println("✓ Student added successfully!\n");
                            studentAdded = true;

                        } catch (InputMismatchException e) {
                            System.out.println("✗ Please enter valid numbers for marks!");
                            sc.nextLine();

                        } catch (InvalidMarksException e) {
                            System.out.println("✗ " + e.getMessage());
                            System.out.println("Please re-enter all marks.\n");
                            // sc.nextLine();
                        }
                    }
                    break;

                case 2:

                    System.out.println("\n────────── STUDENT LIST ──────────");

                    manager.displayAll();

                    break;

                case 3:

                    System.out.println("\n────────── SEARCH STUDENT ──────────");

                    System.out.print("➤ Enter name to search: ");
                    name = sc.nextLine();
                    manager.searchStudent(name);

                    break;

                case 4:
                    
                    System.out.println("\n────────── CLASS STATISTICS ──────────");

                    manager.displayStatistics();

                    break;

                case 5:
                    saveTask.stop();
                    saveThread.join();
                    System.out.println("\n✓ Exiting system... Goodbye!\n");

                    break;

                default:
                    System.out.println("✗ Invalid choice! Please try again.\n");
            }
        } while (choice != 5);
        
        sc.close();
    }
}